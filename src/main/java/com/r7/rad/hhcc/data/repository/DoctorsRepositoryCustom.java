package com.r7.rad.hhcc.data.repository;

import com.r7.rad.hhcc.data.model.Doctors;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorsRepositoryCustom  extends MongoRepository<Doctors, String> {
}
