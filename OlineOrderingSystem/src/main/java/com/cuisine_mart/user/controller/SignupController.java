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
        User user = new User(userInfoBean.getEmail(),userInfoBean.getPassword(),userInfoBean.getEmail(),false,p.getPersonId());
//        user.setUsername(userInfoBean.getEmail());
        User savedUser =  userService.saveNewUser(user);	
        UserRole userRole = new UserRole(userService.getUserByUsername(userInfoBean.getEmail()),"ROLE_USER");
        //System.out.println(userInfoBean.getUserName());    
        userService.saveUserRole(userRole);
        savedUser.setUserRole(userRole);
        userService.updateNewUser(savedUser);
        model.addAttribute("user", new User());
        return "redirect:/thankyou";
    }
        
    @RequestMapping(value="/validateUser/{username:.+}", method= RequestMethod.GET)
	public String userValidation(@PathVariable("username") String username, Model model){
    	System.out.println(username);
		User usr = userService.getUserByUsername(username);
		System.out.println(usr.getUsername());
		usr.setEnabled(true);
		userService.saveNewUser(usr);
		return "redirect:/login";
	}
    
    @RequestMapping(value="/useredit", method= RequestMethod.GET)
    public String editUserForm(User user, Model model) {
        //model.addAttribute("user",userService.getUserByUsername(username));
        
        //model.addAttribute("userInfoBean", new UserInfoBean());
        return "signup";      
    }
    
    @RequestMapping(value="/useredit/{id}", method= RequestMethod.POST)
    public String saveUpdatedUser(@ModelAttribute("userInfoBean") @Valid UserInfoBean userInfoBean,
            Model model,BindingResult result, @PathVariable("id")String id){
    	
    	User user = userService.findUserByUserId(Long.parseLong(id));
    	userInfoBean.getFirstName();
    	userInfoBean.getLastName();
    	userInfoBean.getPhoneNo();
    	userInfoBean.getStreet();
    	userInfoBean.getCity();
    	userInfoBean.getZip();
    	userInfoBean.getEmail();
    	userInfoBean.getPassword();
    	userService.updateNewUser(user);
        model.addAttribute("user", new User());
    	return "redirect:/home";
    }
}
