/**
 * 
 */
package com.cuisine_mart.aop;

import com.cuisine_mart.email.SmtpGmailSender;
import com.cuisine_mart.restaurant.domain.Restaurant;
import com.cuisine_mart.user.domain.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

/**
 * @author Sadiksha
 *
 */
@Aspect
@Component
public class EmailAdvice {
	@Autowired
	private SmtpGmailSender smtpGmailSender;
	@After("execution(* com.cuisine_mart.user.service.Implementation.*.saveNewUser(..))&& args(user)")
	public void printSavedUser(JoinPoint joinPoint,User user)throws Throwable{
		printMessage("THank you!!!");
		String successMsg = "You have successfully signed up in to the system. Please confirm your email by click on following link "+"http://localhost:9080/validateUser/"+user.getUsername();
		smtpGmailSender.send(user.getEmail(), "Sign Up Successful", successMsg);
		printMessage("User successfully signed up and email already sent");
		printMessage("success_msg");
	}

    @After("execution(* com.cuisine_mart.restaurant.service.implementation.RestaurantServiceImpl.save(..)) && args(restaurant)")
	public void sendEmailAfterAddingRestaurant(Restaurant restaurant) throws MessagingException {
        printMessage("restaurant.getEmail() = " + restaurant.getEmail());
        printMessage("Email is now sending to the restaurant as a notification ...... ");
        String emailBody = "You are now added to our portal as a member. Congratulations!!";
        boolean status = smtpGmailSender.send(restaurant.getEmail(),"Successfully Added to Our Portal",emailBody);
        if(status){
            printMessage("Successfully sent an Email Notification to the Restaurant: "+restaurant.getName());
        } else {
            printMessage("Failed to send an Email Notification to the Restaurant: " + restaurant.getName());
        }
    }

    public void printMessage(String message){
        System.out.println(message);
    }

}
