package com.r7.rad.hhcc.data.repository;

import com.r7.rad.hhcc.data.model.Doctors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@NoRepositoryBean
public class DoctorsRepositoryCustomImpl {

    @Autowired
    MongoTemplate mongoTemplate;

//    public List<Doctors> updateDoctors() {
//        Query query = new Query();
//        query.addCriteria(Criteria
//                .where("name").exists(true)
//                .orOperator(Criteria.where("name").is("appleD"),
//                        Criteria.where("name").is("appleE")));
//        Update update = new Update();
//
//        //update age to 11
//        update.set("age", 11);
//
//        //remove the createdDate field
//        update.unset("createdDate");
//
//        // if use updateFirst, it will update 1004 only.
//        // mongoOperation.updateFirst(query4, update4, User.class);
//
//        // update all matched, both 1004 and 1005
//        mongoOperation.updateMulti(query, update, User.class);
//
//        System.out.println(query.toString());
//
//        List<User> usersTest4 = mongoOperation.find(query4, User.class);
//
//        for (User userTest4 : usersTest4) {
//            System.out.println("userTest4 - " + userTest4);
//        }
//    }

}
