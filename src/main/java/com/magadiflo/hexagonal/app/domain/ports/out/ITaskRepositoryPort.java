package com.magadiflo.hexagonal.app.domain.ports.out;

import com.magadiflo.hexagonal.app.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskRepositoryPort {
    List<Task> findAllTasks();

    Optional<Task> findById(Long id);

    Task save(Task task);

    Optional<Task> update(Task task);

    Boolean deleteById(Long id);
}
