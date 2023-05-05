package com.edu.spring.service;

import com.edu.spring.database.entity.Company;
import com.edu.spring.database.repository.CrudRepository;
import com.edu.spring.dto.CompanyReadDto;
import com.edu.spring.listener.entity.AccessType;
import com.edu.spring.listener.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CrudRepository<Integer, Company> crudRepository;
    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public CompanyService(CrudRepository<Integer, Company> crudRepository, UserService userService, ApplicationEventPublisher applicationEventPublisher) {
        this.crudRepository = crudRepository;
        this.userService = userService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Optional<CompanyReadDto> findById(Integer id) {
        return crudRepository.findById(id).map(entity -> {
            applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
            return  new CompanyReadDto(entity.id());
        });
    }
}
