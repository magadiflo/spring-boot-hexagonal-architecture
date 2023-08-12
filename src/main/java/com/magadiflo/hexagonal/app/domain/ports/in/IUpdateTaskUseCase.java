package com.magadiflo.hexagonal.app.domain.ports.in;

import com.magadiflo.hexagonal.app.domain.models.Task;

import java.util.Optional;

public interface IUpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task updateTask);
}
