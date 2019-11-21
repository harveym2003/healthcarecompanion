package com.r7.rad.hhcc.controllers;

import com.r7.rad.hhcc.ApplicationConstants;
import com.r7.rad.hhcc.data.dto.DoctorsDTO;
import com.r7.rad.hhcc.data.model.Doctors;
import com.r7.rad.hhcc.data.repository.DoctorsRepository;
import com.r7.rad.hhcc.data.repository.DoctorsRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(ApplicationConstants.URL_DOCTORS)
public class DoctorsController {

    @Autowired
    private DoctorsRepository doctorsRepository;

    @Autowired
    private DoctorsRepositoryCustom doctorsRepositoryCustom;

    @RequestMapping(value = "/getDoctors", method = RequestMethod.GET)
    public List<DoctorsDTO> getDoctors(String specialization, String city, HttpServletRequest request) {
        List<DoctorsDTO> doctors = new ArrayList<DoctorsDTO>();
        doctors = this.doctorsRepository.findDoctorsByCityAndSpecialization(city, specialization);
        return doctors;
    }

    @RequestMapping(value = "/getAllDoctors", method = RequestMethod.GET)
    public List<Doctors> getAllDoctors() {
        System.out.println("getting doctors' details.......... in progress ");
        List<Doctors> doctors = new ArrayList<Doctors>();
        doctors = this.doctorsRepository.findAll();
        System.out.println("getting doctors' details.......... completed");
        return doctors;
    }

    @PostMapping(value = "/insertDoctors")
    public void insertDoctors(@RequestBody List<Doctors> doctors) {
        this.doctorsRepository.insert(doctors);
    }

    @PostMapping(value = "/insertDoctor")
    public void insertDoctors(@RequestBody Doctors doctors) {
        this.doctorsRepository.insert(doctors);
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
