package com.magadiflo.hexagonal.app.domain.ports.in;

import com.magadiflo.hexagonal.app.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface IRetrieveTaskUseCase {
    List<Task> getAllTasks();

    Optional<Task> getTask(Long id);
}
