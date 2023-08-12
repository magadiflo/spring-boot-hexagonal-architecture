package com.magadiflo.hexagonal.app.infrastructure.repositories;

import com.magadiflo.hexagonal.app.domain.models.Task;
import com.magadiflo.hexagonal.app.domain.ports.out.ITaskRepositoryPort;
import com.magadiflo.hexagonal.app.infrastructure.entities.TaskEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaTaskRepositoryAdapter implements ITaskRepositoryPort {
    private final IJpaTaskRepository jpaTaskRepository;

    public JpaTaskRepositoryAdapter(IJpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public List<Task> findAllTasks() {
        return this.jpaTaskRepository.findAll().stream().map(TaskEntity::toDomainModel).toList();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return this.jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.formDomainModel(task);
        return this.jpaTaskRepository.save(taskEntity).toDomainModel();
    }

    @Override
    public Optional<Task> update(Task task) {
        return this.jpaTaskRepository.findById(task.getId())
                .map(taskEntity -> {
                    TaskEntity taskEntityForUpdate = TaskEntity.formDomainModel(task);
                    return this.jpaTaskRepository.save(taskEntityForUpdate).toDomainModel();
                });
    }

    @Override
    public Boolean deleteById(Long id) {
        return this.jpaTaskRepository.findById(id)
                .map(taskEntity -> {
                    this.jpaTaskRepository.deleteById(taskEntity.getId());
                    return true;
                })
                .orElseGet(() -> false);
    }
}
