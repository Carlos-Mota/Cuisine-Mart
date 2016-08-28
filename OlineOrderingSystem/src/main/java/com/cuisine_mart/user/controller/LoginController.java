package com.cuisine_mart.user.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Rajiv on 8/25/2016.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/handleLogin", method = RequestMethod.GET)
    public String handleLogin(){
        String view = "";
        if (userHasAuthority("ROLE_ADMIN")) view = "/admin/dashboard";
        else if(userHasAuthority("ROLE_USER")) view = "/user/dashboard";
        return "redirect:"+view;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");
        return model;

    }

    public boolean userHasAuthority(String authority)
    {
        List<GrantedAuthority> authorities = getUserAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (authority.equals(grantedAuthority.getAuthority())) {
                return true;
            }
        }
        return false;
    }

    public List<GrantedAuthority> getUserAuthorities(){
        return (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

//    @RequestMapping(value="/logout", method = RequestMethod.GET)
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("inside logout");
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
//    }
}

