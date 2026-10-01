package com.jobconnect.service;

import org.springframework.stereotype.Service;

import com.jobconnect.entity.Application;
import com.jobconnect.repository.ApplicationRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }
}