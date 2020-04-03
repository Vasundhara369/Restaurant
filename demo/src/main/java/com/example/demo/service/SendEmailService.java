package com.example.demo.service;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
@Service
@NoArgsConstructor
public class SendEmailService {
private JavaMailSender mailSender= new JavaMailSenderImpl();

    public String sendMail(String email) {
    	String otp = generateOtp();
		email = email.replaceAll("%40", "@");
        email = email.substring(0, email.length()-1);
        SimpleMailMessage msg = new SimpleMailMessage();  
        msg.setTo(email);
        msg.setFrom("vasundharamyakala99@gmail.com");
        msg.setSubject("OTP to register to our job portal");
        msg.setText(otp+" is your one time OTP.");
        try{
            mailSender.send(msg);
        }
        catch (MailException ex) {
            
            System.err.println(ex.getMessage());
        }
        return otp;
    }
    public String generateOtp() {
		int length = 4;
		String numbers = "1234567890";
	      Random random = new Random();
	      String otp = "";

	      for(int i = 0; i< length ; i++) {
	         otp+= ""+ numbers.charAt(random.nextInt(numbers.length()));
	      }
	      return otp;
	}
}
