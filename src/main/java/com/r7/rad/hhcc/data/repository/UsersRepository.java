package com.r7.rad.hhcc.data.repository;

import com.r7.rad.hhcc.data.model.Doctors;
//import com.r7.rad.hhcc.data.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
//@Repository
public interface UsersRepository extends MongoRepository<String, String> {

//    @Query(value = "{'users.name': ?0}", fields = "{'users' : 0}")
//    User findUsersByUserName(String name);
//
//    User findByEmailAddressIgnoreCase(String emailAddress);

}
