package com.r7.rad.hhcc.data.repository;

import com.r7.rad.hhcc.data.dto.DoctorsDTO;
import com.r7.rad.hhcc.data.dto.PharmaciesDTO;
import com.r7.rad.hhcc.data.model.Doctors;
import com.r7.rad.hhcc.data.model.Pharmacies;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PharmacyRepository extends MongoRepository<PharmaciesDTO, String> {

    List<PharmaciesDTO> findPharmiciesByCity(String city);

//    List findDoctorsByDoctorSpecialty(String name);
}
