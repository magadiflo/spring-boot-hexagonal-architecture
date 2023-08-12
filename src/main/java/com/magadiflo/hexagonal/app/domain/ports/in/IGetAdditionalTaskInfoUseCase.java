package com.magadiflo.hexagonal.app.domain.ports.in;

import com.magadiflo.hexagonal.app.domain.models.AdditionalTaskInfo;

public interface IGetAdditionalTaskInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
