package com.r7.rad.hhcc.service;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

//import com.nibmeetings.backend.config.ApplicationSettings;
//import com.nibmeetings.backend.model.Meeting;
//import com.nibmeetings.backend.model.Role;
//import com.nibmeetings.backend.model.RoleNames;
//import com.nibmeetings.backend.model.User;
//import com.nibmeetings.backend.model.UserCard;
//import com.nibmeetings.backend.model.UserSettings;
//import com.nibmeetings.backend.model.dto.UserDTO;
//import com.nibmeetings.backend.model.enumeration.UserVisibility;
//import com.nibmeetings.backend.model.repository.AuthorityRepository;
//import com.nibmeetings.backend.model.repository.UserCardRepository;
//import com.nibmeetings.backend.model.repository.UserRepository;
//import com.nibmeetings.backend.model.repository.UserSettingsRepository;
//import com.nibmeetings.backend.notification.MailService;
//import com.nibmeetings.backend.utils.HeaderUtil;
//import com.nibmeetings.backend.utils.ImageUtils;
//import com.nibmeetings.backend.utils.TextUtils;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private UserCardRepository userCardRepository;
//    @Autowired
//    private UserSettingsRepository userSettingsRepository;
//
//    @Autowired
//    private AuthorityRepository authorityRepository;
//
//    @Autowired
//    private ApplicationSettings propertiesHelper;
//
//    private MailService mailService = new MailService();
//
//
//    public User activateRegistration(String key) {
//        log.debug("Activating user for activation key {}", key);
//        return Optional.ofNullable(userRepository.findOneByActivationKey(key))
//                .map(user -> {
//
//                    // activate given user for the registration key.
//                    user.setEnabled(true);
//                    user.setActivationKey(null);
//
//                    userRepository.save(user);
//                    log.debug("Activated user: {}", user);
//                    return user;
//                })
//                .orElse(null);
//    }
//
//    private User createUser(String name, String email) {
//        if (name == null) {
//            name = email;
//        }
//        log.debug("Adding " + name + " as " + email);
//        User newUser = new User();
//        Role authority = authorityRepository.findOneByName(RoleNames.User.getValue());
//        Set<Role> authorities = new HashSet<>();
//        newUser.setLogin(email);
//        newUser.setName(name);
//        // new user gets initially a generated password
//        newUser.setPassword(TextUtils.generatePassword());
//        // new user is not active
//        newUser.setEnabled(false);
//        // new user gets registration key
//        newUser.setActivationKey(TextUtils.generateActivationKey());
//        authorities.add(authority);
//        newUser.setRoles(authorities);
//
//        User saved = userRepository.save(newUser);
//        log.debug(saved + "is ssaved");
//        return saved;
//    }
//
//    public User createInvitedUser(User invitee, String name, String email, Meeting meeting, String baseURL) {
//
//        //  final Locale locale = Locale.forLanguageTag("En");
//        // String content =
//        // mailTemplate.createHtmlContentFromTemplate(user, locale,
//        User newUser = createUser(name, email);
//        // request, response);
//
//        try {
//
//            mailService.sendInvitation(invitee, newUser, meeting, baseURL);
//
//        } catch (NullPointerException err) {
//            log.error(err.getMessage());
//        }
//        log.debug("Created Information for User: {}", newUser);
//        return newUser;
//    }
//
//    public User createUserInformation(String password, String firstName, String lastName, String email, String name,
//                                      String langKey, byte[] avatar, String avatarContentType, boolean isSocial) {
//        User newUser = new User();
//        Role authority = authorityRepository.findOneByName(RoleNames.User.getValue());
//
//        Set<Role> authorities = new HashSet<>();
//        UserCard card = new UserCard();
//        UserSettings settings = new UserSettings();
//        card.setShowMail(true);
//
//        if (password == null)
//            password = TextUtils.generatePassword();
//        String encryptedPassword = passwordEncoder.encode(password);
//        log.debug("Encoded Pass : " + encryptedPassword);
//        newUser.setLogin(email);
//        newUser.setName(name);
//        // new user gets initially a generated password
//        newUser.setPassword(encryptedPassword);
//        newUser.setFirstName(firstName);
//        newUser.setLastName(lastName);
//        newUser.setLangKey(langKey);
//        if (avatar != null) {
//            newUser.setAvatar(avatar);
//            newUser.setAvatarContentType(avatarContentType);
//        }
//        // new user is not active
//        newUser.setEnabled(isSocial);
//        // new user gets registration key
//        newUser.setActivationKey(TextUtils.generateActivationKey());
//        authorities.add(authority);
//
//        newUser.setRoles(authorities);
//        userSettingsRepository.save(settings);
//        newUser.setSettings(settings);
//        userCardRepository.save(card);
//        newUser.setCard(card);
//        userRepository.save(newUser);
//        log.debug("Created Information for User: {}", newUser);
//        return newUser;
//    }
//
//
//    public void changePassword(String username, String password) {
//        User currentUser = userRepository.findByLoginIgnoreCase(username);
//        String encryptedPassword = passwordEncoder.encode(password);
//        currentUser.setPassword(encryptedPassword);
//        userRepository.save(currentUser);
//        log.debug("Changed password for User: {}", currentUser);
//    }
//
//    @Transactional(readOnly = true)
//    public User getUserEager(String username) {
//        User currentUser = userRepository.findByLoginIgnoreCase(username);
//        if (currentUser != null) {
//            currentUser.getRoles().size(); // eagerly load the association
//            currentUser.getCard();
//            currentUser.getSettings();
//            currentUser.getCompany();
//        }
//        return currentUser;
//    }
//
//    /*
//    /**
//     * Not activated users should be automatically deleted after 3 days.
//     * <p/>
//     * <p>
//     * This is scheduled to get fired everyday, at 01:00 (am).
//     * </p>
//     */
//    /*
//    @Scheduled(cron = "0 0 1 * * ?")
//    public void removeNotActivatedUsers() {
//        DateTime now = new DateTime();
//        List<User> users = userRepository.findNotActivatedUsersByCreationDateBefore(now.minusDays(3));
//        for (User user : users) {
//            log.debug("Deleting not activated user {}", user.getLogin());
//            userRepository.delete(user);
//        }
//    }
//    */
//    public Optional<User> completePasswordReset(String newPassword, String key) {
//        log.debug("Reset user password for reset key {}", key);
//
//        return userRepository.findOneByResetKey(key)
//                .filter(user -> {
//                	Date in =  user.getResetDate();
//                	LocalDateTime resetDate = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
//                	LocalDateTime oneDayAgo = LocalDateTime.now().minusHours(24);
//                    return resetDate.isAfter(oneDayAgo);
//                })
//                .map(user -> {
//                    user.setPassword(passwordEncoder.encode(newPassword));
//                    user.setResetKey(null);
//                    user.setResetDate(null);
//                    userRepository.save(user);
//                    return user;
//                });
//    }
//
//    public Optional<User> requestPasswordReset(String mail) {
//        return userRepository.findOneByLoginIgnoreCase(mail)
//                .filter(User::isUserEnabled)
//                .map(user -> {
//                    user.setResetKey(TextUtils.generateActivationKey());
//                    user.setResetDate(new Date());
//                    userRepository.save(user);
//                    return user;
//                });
//    }
//
//    /**
//     * Not activated users should be automatically deleted after 3 days.
//     * <p>
//     * This is scheduled to get fired everyday, at 01:00 (am).
//     * </p>
//     */
//    @Scheduled(cron = "0 0 1 * * ?")
//    public void removeNotActivatedUsers() {
//        final Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, -3);
//
//        List<User> users = userRepository.findAllByEnabledFalseAndCreatedDateBefore(cal.getTime());
//        for (User user : users) {
//            log.debug("Deleting not activated user {}", user.getLogin());
//            userRepository.delete(user);
//        }
//    }
//
//
//    public User updateUserInformation(String userName, byte[] image, String contentType) throws NullPointerException {
//        User userInDB = Optional.ofNullable(getUserEager(userName)).orElseThrow(NullPointerException::new);
//        userInDB.setAvatar(image);
//        userInDB.setAvatarContentType(contentType);
//        return userRepository.save(userInDB);
//    }
//
//
//    public ResponseEntity<byte[]> getImage(String userName, boolean isDefault) throws IOException {
//        log.debug("getting image of " + userName);
//        User userInDB = Optional.ofNullable(getUserEager(userName)).orElseThrow(NullPointerException::new);
//        byte[] img = userInDB.getAvatar();
//
//        String contentType = userInDB.getAvatarContentType();
//        if (img != null) {
//            log.debug(new String(img));
//
//            img = Base64.getDecoder().decode(img);
//            log.debug("DECODED: " + new String(img));
//            ByteArrayInputStream inputStream = new ByteArrayInputStream(img);
//            try {
//                log.debug("resizing");
//                BufferedImage imgBuf = ImageUtils.getThumbnail(inputStream, propertiesHelper.getImageProfileSize());
//               // BufferedImage src = ImageIO.read(inputStream);
//             //   BufferedImage imgBuf = ImageUtils.getScaledImage(src, propertiesHelper.getImageProfileSize(), propertiesHelper.getImageProfileSize());
//                img = ImageUtils.bufferedImageToBytes(imgBuf, "jpg");
//                log.debug("RESIZED:", new String(img));
//            } catch (IOException e) {
//                img = ImageUtils.noProfilePhoto();
//                contentType = HeaderUtil.PNG_IMAGE_CONTENTTYPE;
//                e.printStackTrace();
//            }
//            if (img == null) {
//                img = ImageUtils.noProfilePhoto();
//                contentType = HeaderUtil.PNG_IMAGE_CONTENTTYPE;
//            }
//        } else {
//            log.debug("User got no avatar");
//            if(isDefault){
//                img = ImageUtils.defaultProfile();
//            }else{
//            img = ImageUtils.noProfilePhoto();
//            }
//
//            contentType = HeaderUtil.PNG_IMAGE_CONTENTTYPE;
//        }
//        log.debug(new String(img));
//        HttpHeaders headers = HeaderUtil.generateContentType(contentType);
//        return new ResponseEntity<byte[]>(img, headers, HttpStatus.OK);
//
//    }
//
//    public ResponseEntity<?> updateUserInformation(UserDTO userDTO, String login) {
//        log.debug("Fetching user from db....");
//        User currentUser = userRepository.findByLoginIgnoreCase(login);
//        if (currentUser != null) {
//            log.debug("Got " + currentUser.getLogin());
//            if (userDTO.getName() != null)
//                currentUser.setName(userDTO.getName());
//            if (userDTO.getFirstName() != null)
//                currentUser.setFirstName(userDTO.getFirstName());
//            if (userDTO.getLastName() != null)
//                currentUser.setLastName(userDTO.getLastName());
//            if (userDTO.getAvatar() != null) {
//                currentUser.setAvatar(userDTO.getAvatar());
//                currentUser.setAvatarContentType(userDTO.getAvatarContentType());
//            }
//            if (userDTO.getVisibility() != null) {
//                if (currentUser.getCard() != null)
//                    currentUser.getCard().setVisibility(UserVisibility.getVisibility(userDTO.getVisibility()));
//                else {
//                    UserCard card = new UserCard();
//                    card.setVisibility(UserVisibility.getVisibility(userDTO.getVisibility()));
//                    userCardRepository.save(card);
//                    currentUser.setCard(card);
//                }
//            }
//            if (!StringUtils.isEmpty(userDTO.getCompanyName())) {
//                log.debug("Got company name !!? ", userDTO.getCompanyName());
//                if (currentUser.getCard() != null) {
//                    log.debug("Got card ");
//                    currentUser.getCard().setCompanyName(userDTO.getCompanyName());
//                } else {
//                    log.debug("User has no card, creating one");
//                    UserCard card = new UserCard();
//                    card.setCompanyName(userDTO.getCompanyName());
//                    userCardRepository.save(card);
//                    currentUser.setCard(card);
//                }
//            }
//            if (userDTO.getAddress() != null)
//                if (currentUser.getCard() != null) {
//
//                    currentUser.getCard().setAddress(userDTO.getAddress());
//                } else {
//                    UserCard card = new UserCard();
//                    card.setAddress(userDTO.getAddress());
//                    userCardRepository.save(card);
//                    currentUser.setCard(card);
//                }
//
//            if (userDTO.getWebSite() != null) {
//                if (currentUser.getCard() != null) {
//                    currentUser.getCard().setWebSite(userDTO.getWebSite());
//                } else {
//                    UserCard card = new UserCard();
//                    card.setCompanyName(userDTO.getWebSite());
//                    userCardRepository.save(card);
//                    currentUser.setCard(card);
//                }
//            }
//
//            if (userDTO.getDesignation() != null) {
//                if (currentUser.getCard() != null) {
//                    currentUser.getCard().setDesignation(userDTO.getDesignation());
//                } else {
//                    UserCard card = new UserCard();
//                    card.setDesignation(userDTO.getDesignation());
//                    userCardRepository.save(card);
//                    currentUser.setCard(card);
//                }
//            }
//            if (userDTO.showNotifications() != null) {
//                if (currentUser.getSettings() != null)
//                    currentUser.getSettings().setShowNotifications(true);
//                else {
//                    UserSettings settings = new UserSettings();
//                    settings.setShowNotifications(true);
//                    userSettingsRepository.save(settings);
//                }
//            }
//
//
//            userRepository.save(currentUser);
//
//            log.debug("Changed Information for User: {}", currentUser);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        }
//    }
}



