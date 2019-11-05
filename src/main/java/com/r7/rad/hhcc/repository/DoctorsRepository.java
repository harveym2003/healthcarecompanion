package com.r7.rad.hhcc.repository;

import com.r7.rad.hhcc.data.Doctors;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorsRepository extends MongoRepository {

//    @Query(value = "{'doctors.name': ?0}", fields = "{'doctors' : 0}")
//    Doctors findDoctorsByName(String name);

//    List findDoctorsByDoctorSpecialty(String name);
}
