package com.magadiflo.hexagonal.app.application.usecases;

import com.magadiflo.hexagonal.app.domain.ports.in.IDeleteTaskUseCase;
import com.magadiflo.hexagonal.app.domain.ports.out.ITaskRepositoryPort;

public class DeleteTaskUseCaseImpl implements IDeleteTaskUseCase {
    private final ITaskRepositoryPort taskRepositoryPort;

    public DeleteTaskUseCaseImpl(ITaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Boolean deleteTask(Long id) {
        return this.taskRepositoryPort.deleteById(id);
    }
}
