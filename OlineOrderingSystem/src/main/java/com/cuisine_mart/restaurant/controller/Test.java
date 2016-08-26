package com.cuisine_mart.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rajiv on 8/25/2016.
 */
@Controller
@RequestMapping("/admin")
public class Test {
    @RequestMapping("/testUrl")
    public String testView(ModelMap modelMap){
        modelMap.addAttribute("message", "this is test message");
        return "demo";
    }
}
