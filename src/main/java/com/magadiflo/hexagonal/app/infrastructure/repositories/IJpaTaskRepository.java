package com.magadiflo.hexagonal.app.infrastructure.repositories;

import com.magadiflo.hexagonal.app.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}
