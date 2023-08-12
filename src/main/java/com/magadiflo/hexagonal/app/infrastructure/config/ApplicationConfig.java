package com.magadiflo.hexagonal.app.infrastructure.config;

import com.magadiflo.hexagonal.app.application.services.TaskService;
import com.magadiflo.hexagonal.app.application.usecases.*;
import com.magadiflo.hexagonal.app.domain.ports.in.IGetAdditionalTaskInfoUseCase;
import com.magadiflo.hexagonal.app.domain.ports.out.IExternalServicePort;
import com.magadiflo.hexagonal.app.domain.ports.out.ITaskRepositoryPort;
import com.magadiflo.hexagonal.app.infrastructure.adapters.ExternalServiceAdapter;
import com.magadiflo.hexagonal.app.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public TaskService taskService(ITaskRepositoryPort taskRepositoryPort,
                                   IGetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(new CreateTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase);
    }

    @Bean
    public ITaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public IGetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(IExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public IExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }
}
