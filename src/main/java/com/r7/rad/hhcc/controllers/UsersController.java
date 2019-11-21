package com.r7.rad.hhcc.controllers;

import com.r7.rad.hhcc.ApplicationConstants;
//import com.r7.rad.hhcc.data.dto.User;
//import com.r7.rad.hhcc.data.dto.UserDTO;
//import com.r7.rad.hhcc.data.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(ApplicationConstants.URL_ACCOUNT)
public class UsersController {

//    @Autowired
//    private UsersRepository usersRepository;
//    @Autowired
//    private UserService userService;

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public User register(@RequestBody UserDTO userDTO, HttpServletRequest request) {
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
