/**
 * 
 */
package com.cuisine_mart.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.cuisine_mart.email.SmtpGmailSender;
import com.cuisine_mart.user.domain.User;

/**
 * @author Sadiksha
 *
 */
@Aspect
@Component
public class UserAdvice {
	@Autowired
	private SmtpGmailSender smtpGmailSender;
	@After("execution(* com.cusine_mart.user.service.Implementation.*.save(..))&&args(user)")	
	public String traceSignupMethod(JoinPoint joinPoint,User user)throws Throwable{
		String successMsg = "You have successfully signed up in to the system. Please confirm your email by click on following link "+"http://localhost:8080/verify/"+user.getUsername();
		smtpGmailSender.send(user.getEmail(), "Sign Up Successful", successMsg);
		System.out.println("User successfully signed up and email already sent");
		return "success_msg";
	}

}
