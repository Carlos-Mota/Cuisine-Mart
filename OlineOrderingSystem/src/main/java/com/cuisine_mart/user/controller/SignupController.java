/**
 * 
 */
package com.cuisine_mart.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cuisine_mart.beans.UserInfoBean;
import com.cuisine_mart.email.SmtpGmailSender;
import com.cuisine_mart.user.domain.Address;
import com.cuisine_mart.user.domain.Person;
import com.cuisine_mart.user.domain.User;
import com.cuisine_mart.user.domain.UserRole;
import com.cuisine_mart.user.service.IServiceContract.IAddressService;
import com.cuisine_mart.user.service.IServiceContract.IPersonService;
import com.cuisine_mart.user.service.IServiceContract.IUserService;

/**
 * @author Sadiksha
 *
 */
@Controller
public class SignupController {
	@Autowired
    private IAddressService addressService;
    @Autowired
    private IPersonService personService;
    @Autowired
    private IUserService userService;
    
    @Autowired
	private SmtpGmailSender smtpGmailSender;
    
    @RequestMapping(value="/signup",method = RequestMethod.GET)
    public String getSignupForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userInfoBean", new UserInfoBean());
        return "signup";      
    }
    @RequestMapping(value="/thankyou", method=RequestMethod.GET)
    public String thankyouPage(){
    	return "thankyou";
    }
    
    @RequestMapping(value="/signup",method = RequestMethod.POST)
    public String proccessSignUp(@ModelAttribute("userInfoBean") @Valid UserInfoBean userInfoBean,
            Model model,BindingResult result) {
        if(result.hasErrors()) {
            return "signup";
        }
        Address address1 = new Address(userInfoBean.getStreet(),userInfoBean.getCity(),userInfoBean.getState(), userInfoBean.getZip(),userInfoBean.getPhoneNo());
        List<Address>addList = new ArrayList<>();
        addList.add(address1);
        Person person = new Person(userInfoBean.getFirstName(), userInfoBean.getLastName(),userInfoBean.getEmail(),addList);
        Person p = personService.create(person);
        User user = new User(userInfoBean.getUserName(),userInfoBean.getPassword(),userInfoBean.getEmail(),false);
        User savedUser =  saveUser(user);
        UserRole userRole = new UserRole(userService.getUserByUsername(userInfoBean.getUserName()),"ROLE_USER");
        System.out.println(userInfoBean.getUserName());    
        userService.saveUserRole(userRole);
        savedUser.setUserRole(userRole);
        userService.saveNewUser(savedUser);
        model.addAttribute("user", new User());
        return "redirect:/thankyou";
    }
    
    public User saveUser(User user){
    	System.out.println("test");
    	return userService.saveNewUser(user);		
    	
    }
    
    
    
    @RequestMapping(value="/validateUser/{username}", method= RequestMethod.POST)
	public String userValidation(@PathVariable String username, Model model){
		User usr = userService.getUserByUsername(username);
		usr.setEnabled(true);
		userService.saveNewUser(usr);
		return "redirect:/login";
	}
}
