package com.ecommerce.helper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Async
    public void sendOtp(String name, String email, Integer otp) throws MessagingException, UnsupportedEncodingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setFrom("admin", "admin@ecommerce.com");
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("one time password for account creation");

        String text = "<html><body>"
                + "<h3>hello <b>" + name + "</b>,</h3>"
                + "<h3>your one time password is <b>" + otp + "</b></h3>"
                + "<h3>otp will be valid for only <b>5 minutes</b>."
                + "</body></html>";

        mimeMessageHelper.setText(text, true);
        javaMailSender.send(mimeMessage);
    }

    @Async
    public void sendConfirmation(String name, String email, String password) throws MessagingException, UnsupportedEncodingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setFrom("admin", "admin@ecommerce.com");
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("registration successful");

        String text = "<html><body>"
                + "<h3>hello <b>" + name + "</b>,</h3>"
                + "<h3>your account has been successfully registered.</h3>"
                + "<table>"
                + "<tr><td>email:</td><td>" + email + "</td></tr>"
                + "<tr><td>password:</td><td>" + password + "</td></tr>"
                + "</table>"
                + "</body></html>";

        mimeMessageHelper.setText(text, true);
        javaMailSender.send(mimeMessage);
    }

    @Async
    public void sendPaymentConfirmation(String name, String email, Double amount) throws MessagingException, UnsupportedEncodingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setFrom("admin", "admin@ecommerce.com");
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("payment successful");

        String text = "<html><body>"
                + "<h3>hello " + name + ",</h3>"
                + "<p>your payment of <b>₹" + amount + "</b> was successful.</p>"
                + "<p>thank you.</p>"
                + "</body></html>";

        mimeMessageHelper.setText(text, true);
        javaMailSender.send(mimeMessage);
    }
}
