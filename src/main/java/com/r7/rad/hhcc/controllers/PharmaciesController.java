package com.r7.rad.hhcc.controllers;

import com.r7.rad.hhcc.ApplicationConstants;
import com.r7.rad.hhcc.data.dto.DoctorsDTO;
import com.r7.rad.hhcc.data.dto.PharmaciesDTO;
import com.r7.rad.hhcc.data.model.Doctors;
import com.r7.rad.hhcc.data.model.Pharmacies;
import com.r7.rad.hhcc.data.repository.DoctorsRepository;
import com.r7.rad.hhcc.data.repository.DoctorsRepositoryCustom;
import com.r7.rad.hhcc.data.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(ApplicationConstants.URL_PHARMACIES)
public class PharmaciesController {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @RequestMapping(value = "/getPharmacies", method = RequestMethod.GET)
    public List<PharmaciesDTO> getPharmacies(String city) {
        List<PharmaciesDTO> pharmacies = new ArrayList<PharmaciesDTO>();
        pharmacies = pharmacyRepository.findPharmiciesByCity(city);
        return pharmacies;
    }

    @RequestMapping(value = "/getAllPharmaciess", method = RequestMethod.GET)
    public List<PharmaciesDTO> getAllPharmacies() {
        System.out.println("getting pharmacies' details.......... in progress ");
        List<PharmaciesDTO> pharmacies = new ArrayList<PharmaciesDTO>();
        pharmacies = pharmacyRepository.findAll();
        System.out.println("getting pharmacies' details.......... completed");
        return pharmacies;
    }

    @PostMapping(value = "/insertPharmacies")
    public void insertPharmacies(@RequestBody List<PharmaciesDTO> pharmacies) {
        this.pharmacyRepository.insert(pharmacies);
    }

//    @PostMapping(value = "/insertDoctor")
//    public void insertDoctors(@RequestBody Doctors doctors) {
//        this.pharmacyRepository.insert(doctors);
//
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
