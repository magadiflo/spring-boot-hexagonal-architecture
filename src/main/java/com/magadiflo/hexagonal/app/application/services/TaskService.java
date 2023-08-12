package com.magadiflo.hexagonal.app.application.services;

import com.magadiflo.hexagonal.app.domain.models.AdditionalTaskInfo;
import com.magadiflo.hexagonal.app.domain.models.Task;
import com.magadiflo.hexagonal.app.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

public class TaskService implements ICreateTaskUseCase, IUpdateTaskUseCase, IDeleteTaskUseCase, IRetrieveTaskUseCase,
        IGetAdditionalTaskInfoUseCase {
    private final ICreateTaskUseCase createTaskUseCase;
    private final IUpdateTaskUseCase updateTaskUseCase;
    private final IDeleteTaskUseCase deleteTaskUseCase;
    private final IRetrieveTaskUseCase retrieveTaskUseCase;
    private final IGetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    public TaskService(ICreateTaskUseCase createTaskUseCase, IUpdateTaskUseCase updateTaskUseCase,
                       IDeleteTaskUseCase deleteTaskUseCase, IRetrieveTaskUseCase retrieveTaskUseCase,
                       IGetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }

    @Override
    public Task createTask(Task task) {
        return this.createTaskUseCase.createTask(task);
    }

    @Override
    public Boolean deleteTask(Long id) {
        return this.deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return this.getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return this.retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return this.retrieveTaskUseCase.getTask(id);
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return this.updateTaskUseCase.updateTask(id, updateTask);
    }
}
