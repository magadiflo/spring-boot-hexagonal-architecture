package com.magadiflo.hexagonal.app.application.usecases;

import com.magadiflo.hexagonal.app.domain.models.Task;
import com.magadiflo.hexagonal.app.domain.ports.in.ICreateTaskUseCase;
import com.magadiflo.hexagonal.app.domain.ports.out.ITaskRepositoryPort;

public class CreateTaskUseCaseImpl implements ICreateTaskUseCase {
    private final ITaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(ITaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return this.taskRepositoryPort.save(task);
    }
}
