package com.edu.spring;

import com.edu.spring.config.ApplicationConfiguration;
import com.edu.spring.database.pool.ConnectionPool;
import com.edu.spring.database.repository.CrudRepository;
import com.edu.spring.service.CompanyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
       try(var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
           var connectionPool = context.getBean("pool1", ConnectionPool.class);
           System.out.println(connectionPool);

           var companyService = context.getBean("companyService", CompanyService.class);
           System.out.println(companyService.findById(1));
       }
    }
}
