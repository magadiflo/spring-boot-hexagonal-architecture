package com.magadiflo.hexagonal.app.application.usecases;

import com.magadiflo.hexagonal.app.domain.models.Task;
import com.magadiflo.hexagonal.app.domain.ports.in.IUpdateTaskUseCase;
import com.magadiflo.hexagonal.app.domain.ports.out.ITaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements IUpdateTaskUseCase {
    private final ITaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(ITaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return this.taskRepositoryPort.findById(id)
                .map(taskDB -> {
                    taskDB.setTitle(updateTask.getTitle());
                    taskDB.setDescription(updateTask.getDescription());
                    return this.taskRepositoryPort.save(taskDB);
                });
    }
}
