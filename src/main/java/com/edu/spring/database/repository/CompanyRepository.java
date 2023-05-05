package com.edu.spring.database.repository;

import com.edu.spring.bpp.Auditing;
import com.edu.spring.bpp.InjectBean;
import com.edu.spring.bpp.Transaction;
import com.edu.spring.database.entity.Company;
import com.edu.spring.database.pool.ConnectionPool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Transaction
@Auditing
@Component
@RequiredArgsConstructor
@Slf4j
public class CompanyRepository implements CrudRepository<Integer, Company> {


    private final ConnectionPool pool1;
    private final List<ConnectionPool> pools;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        log.info("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        log.info("delete method...");
    }


}
