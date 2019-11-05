package com.r7.rad.hhcc.repository;

import com.r7.rad.hhcc.data.Doctors;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends MongoRepository {

//    @Query(value = "{'users.name': ?0}", fields = "{'users' : 0}")
//    Doctors findUsersByUserName(String name);

}
