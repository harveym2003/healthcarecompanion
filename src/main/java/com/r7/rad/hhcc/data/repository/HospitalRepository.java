package com.r7.rad.hhcc.data.repository;

import com.r7.rad.hhcc.data.dto.DoctorsDTO;
import com.r7.rad.hhcc.data.dto.HospitalsDTO;
import com.r7.rad.hhcc.data.model.Doctors;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface HospitalRepository extends MongoRepository<HospitalsDTO, String> {

//    @Query(value = "{'doctors.city': ?0}", fields = "{'doctors' : 0}")
    List<HospitalsDTO> findHospitalsByCity(String city);

//    List findDoctorsByDoctorSpecialty(String name);
}
