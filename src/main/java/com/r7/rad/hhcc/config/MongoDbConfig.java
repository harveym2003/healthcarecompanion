package com.r7.rad.hhcc.config;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = {"com.r7.rad.hhcc.data.model.repository"})
public class MongoDbConfig {
}
