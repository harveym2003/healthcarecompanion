package com.r7.rad.hhcc.data.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Doctors")
public class DoctorsDTO {

    private String name;
    private String details;
    private String services;
    private String schedule;
    private String address;

    private List doctorSpecialty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List getDoctorSpecialty() {
        return doctorSpecialty;
    }

    public void setDoctorSpecialty(List doctorSpecialty) {
        this.doctorSpecialty = doctorSpecialty;
    }


}
