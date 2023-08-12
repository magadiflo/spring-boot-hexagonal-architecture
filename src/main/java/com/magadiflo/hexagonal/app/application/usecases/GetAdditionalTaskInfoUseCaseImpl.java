package com.magadiflo.hexagonal.app.application.usecases;

import com.magadiflo.hexagonal.app.domain.models.AdditionalTaskInfo;
import com.magadiflo.hexagonal.app.domain.ports.in.IGetAdditionalTaskInfoUseCase;
import com.magadiflo.hexagonal.app.domain.ports.out.IExternalServicePort;

public class GetAdditionalTaskInfoUseCaseImpl implements IGetAdditionalTaskInfoUseCase {
    private final IExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(IExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return this.externalServicePort.getAdditionalTaskInfo(id);
    }
}
