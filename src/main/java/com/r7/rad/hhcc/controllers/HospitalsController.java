package com.r7.rad.hhcc.controllers;

import com.r7.rad.hhcc.ApplicationConstants;
import com.r7.rad.hhcc.data.dto.DoctorsDTO;
import com.r7.rad.hhcc.data.dto.HospitalsDTO;
import com.r7.rad.hhcc.data.model.Doctors;
import com.r7.rad.hhcc.data.repository.DoctorsRepository;
import com.r7.rad.hhcc.data.repository.DoctorsRepositoryCustom;
import com.r7.rad.hhcc.data.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(ApplicationConstants.URL_HOSPITALS)
public class HospitalsController {

    @Autowired
    private HospitalRepository hospitalRepository;

//    @Autowired
//    private DoctorsRepositoryCustom doctorsRepositoryCustom;

    @RequestMapping(value = "/getHospitals", method = RequestMethod.GET)
    public List<HospitalsDTO> getHospitals(String city) {
        List<HospitalsDTO> hospitals = new ArrayList<HospitalsDTO>();
        hospitals = this.hospitalRepository.findDoctorsByCity(city);
        return hospitals;
    }

    @RequestMapping(value = "/getAllHospitals", method = RequestMethod.GET)
    public List<HospitalsDTO> getAllDoctors() {
        System.out.println("getting hospitals' details.......... in progress ");
        List<HospitalsDTO> hospitals = new ArrayList<HospitalsDTO>();
        hospitals = this.hospitalRepository.findAll();
        System.out.println("getting hospitals' details.......... completed");
        return hospitals;
    }

    @PostMapping(value = "/insertHospitals")
    public void insertDoctors(@RequestBody List<HospitalsDTO> hospitals) {
        this.hospitalRepository.insert(hospitals);
    }

    @PostMapping(value = "/insertHospital")
    public void insertHospitals(@RequestBody HospitalsDTO hospitals) {
        this.hospitalRepository.insert(hospitals);
    }

//        return Optional.ofNullable(usersRepository.findByEmailAddressIgnoreCase(userDTO.getEmailAddress()))
//                .map(user -> new ResponseEntity("Email address already in use ", HttpStatus.BAD_REQUEST))
//                .orElseGet(() -> {
//                    if (usersRepository.findByEmailAddressIgnoreCase(userDTO.getEmailAddress()) != null) {
//                        return new ResponseEntity<String>("e-mail address already in use ", HttpStatus.BAD_REQUEST);
//                    }
//                    UserDTO user = userService.createUserInformation(userDTO.getPassword(), userDTO.getFirstName(),
//                            userDTO.getLastName(), userDTO.getLogin().toLowerCase(), userDTO.getName(),
//                            userDTO.getLangKey(), userDTO.getAvatar(), userDTO.getAvatarContentType(), false);
//                    if (user.getLangKey() == null) {
//                        user.setLangKey("EN");
//                    }
//                    final Locale locale = Locale.forLanguageTag(user.getLangKey());
//                    // String content =
//                    // mailTemplate.createHtmlContentFromTemplate(user, locale,
//                    // request, response);
//                    mailService.sendActivationNotification(user, locale, HeaderUtil.getBaseUrl(request));
//                    return new ResponseEntity<>(HttpStatus.OK);
//                });
//
////        usersRepository.save(user);
////        return user;
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public User login(@RequestBody User user) {
//        usersRepository.save(user);
//        return user;
//    }

    @RequestMapping("/welcome")
    @GetMapping
    public String welcome(){
        return "Welcome to HHCC Backend";
    }

}
