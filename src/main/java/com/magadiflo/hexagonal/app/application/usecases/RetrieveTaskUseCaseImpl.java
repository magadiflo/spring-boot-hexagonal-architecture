package com.magadiflo.hexagonal.app.application.usecases;

import com.magadiflo.hexagonal.app.domain.models.Task;
import com.magadiflo.hexagonal.app.domain.ports.in.IRetrieveTaskUseCase;
import com.magadiflo.hexagonal.app.domain.ports.out.ITaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveTaskUseCaseImpl implements IRetrieveTaskUseCase {
    private final ITaskRepositoryPort taskRepositoryPort;

    public RetrieveTaskUseCaseImpl(ITaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public List<Task> getAllTasks() {
        return this.taskRepositoryPort.findAllTasks();
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return this.taskRepositoryPort.findById(id);
    }
}
