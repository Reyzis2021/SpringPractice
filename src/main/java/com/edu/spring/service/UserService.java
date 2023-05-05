package com.edu.spring.service;

import com.edu.spring.database.entity.Company;
import com.edu.spring.database.repository.CrudRepository;
import com.edu.spring.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;


}
