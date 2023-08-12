package com.magadiflo.hexagonal.app.domain.ports.out;

import com.magadiflo.hexagonal.app.domain.models.AdditionalTaskInfo;

public interface IExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
