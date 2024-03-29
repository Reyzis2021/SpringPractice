package com.edu.spring.database.repository;

import com.edu.spring.database.pool.ConnectionPool;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class UserRepository {

    @Qualifier("pool2")
    private final ConnectionPool connectionPool;

}
