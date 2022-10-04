package com.danieldinu.mealhub.service;

import com.danieldinu.mealhub.model.User;
import com.danieldinu.mealhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final JavaMailSender mailSender;

    @Autowired
    public UserService(UserRepository userRepository, JavaMailSender mailSender) {
        this.userRepository = userRepository;
        this.mailSender = mailSender;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User findByName(String username) {
        return userRepository.findByName(username);
    }

    public Boolean existsByName(String username) {
        return userRepository.existsByName(username);
    }

    public Boolean existsByEmail(String username) {
        return userRepository.existsByEmail(username);
    }

    public void sendVerificationEmail(User user, String siteURL)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "danieldinu6091@gmail.com";
        String senderName = "MealHub";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "MealHub.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", StringUtils.capitalize(user.getName()));
        content = content.replace("[[URL]]", siteURL);

        helper.setText(content, true);

        mailSender.send(message);

    }
}
