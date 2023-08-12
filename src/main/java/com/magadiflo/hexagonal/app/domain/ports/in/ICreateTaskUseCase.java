package com.magadiflo.hexagonal.app.domain.ports.in;

import com.magadiflo.hexagonal.app.domain.models.Task;

public interface ICreateTaskUseCase {
    Task createTask(Task task);
}
