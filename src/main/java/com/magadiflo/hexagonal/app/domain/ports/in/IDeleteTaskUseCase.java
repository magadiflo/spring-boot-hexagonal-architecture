package com.magadiflo.hexagonal.app.domain.ports.in;

public interface IDeleteTaskUseCase {
    Boolean deleteTask(Long id);
}
