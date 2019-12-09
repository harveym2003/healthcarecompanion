package com.r7.rad.hhcc.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import com.r7.rad.hhcc.data.dto.DoctorsDTO;
import com.r7.rad.hhcc.data.model.Doctors;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DoctorsRepository extends MongoRepository<Doctors, String> {

//    @Query(value = "{'doctors.city': ?0}", fields = "{'doctors' : 0}")
    List<DoctorsDTO> findDoctorsByCityAndSpecializationLike(String city, String specialization);

//    List<DoctorsDTO> updateDoctors(String details, String specialization);

//    List findDoctorsByDoctorSpecialty(String name);
}
