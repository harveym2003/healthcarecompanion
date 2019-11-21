package com.r7.rad.hhcc.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public class DoctorsRepositoryCustomImpl {

    @Autowired
    MongoTemplate mongoTemplate;

}
