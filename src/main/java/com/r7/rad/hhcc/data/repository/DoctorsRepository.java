package com.r7.rad.hhcc.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import com.r7.rad.hhcc.data.dto.DoctorsDTO;
import com.r7.rad.hhcc.data.model.Doctors;
import java.util.List;

@NoRepositoryBean
public interface DoctorsRepository extends MongoRepository {

    @Query(value = "{'doctors.city': ?0}", fields = "{'doctors' : 0}")
    List<DoctorsDTO> findDoctorsByCityAndSpecialization(String city, String specialization);

//    List findDoctorsByDoctorSpecialty(String name);
}
