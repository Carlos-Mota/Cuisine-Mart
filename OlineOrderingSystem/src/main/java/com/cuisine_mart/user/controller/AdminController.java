package com.cuisine_mart.user.controller;

import com.cuisine_mart.beans.RestaurantInfoBean;
import com.cuisine_mart.order.domain.Food;
import com.cuisine_mart.order.domain.FoodType;
import com.cuisine_mart.restaurant.domain.CuisineCategory;
import com.cuisine_mart.restaurant.domain.Menu;
import com.cuisine_mart.restaurant.domain.Restaurant;
import com.cuisine_mart.restaurant.service.IServiceContract.ICuisineCategoryService;
import com.cuisine_mart.restaurant.service.IServiceContract.IMenuService;
import com.cuisine_mart.restaurant.service.IServiceContract.IRestaurantService;
import com.cuisine_mart.user.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Rajiv on 8/29/2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ICuisineCategoryService iCuisineCategoryService;

    @Autowired
    IRestaurantService iRestaurantService;

    @Autowired
    IMenuService menuService;

    @RequestMapping("/dashboard")
    public String dashboard(ModelMap modelMap){
        List<Restaurant> restaurants = iRestaurantService.findAll();
        List<Menu> menus = menuService.findAll();
        modelMap.addAttribute("restaurants",restaurants);
        modelMap.addAttribute("menus",menus);
        return "adminDashboard";
    }
    @RequestMapping("/restaurantDetail/{restaurantId}")
    public String restaurantDetail(@PathVariable Long restaurantId,ModelMap modelMap){
        Restaurant restaurant = iRestaurantService.get(restaurantId);
        modelMap.addAttribute("restaurant",restaurant);
        return "restaurantDetail";
    }

    @RequestMapping("/addRestaurant")
    public String addRestaurant(ModelMap modelMap){
        List<CuisineCategory> cuisineCategoryList = iCuisineCategoryService.findAll();
        modelMap.addAttribute("restaurantInfoBean", new RestaurantInfoBean());
        modelMap.addAttribute("cuisines", cuisineCategoryList);
        return "addRestaurant";
    }

    @RequestMapping(value = "/saveRestaurant", method = RequestMethod.POST)
    public String saveRestaurant(@ModelAttribute("restaurantInfoBean") RestaurantInfoBean restaurantInfoBean,
                                 BindingResult resultRestaurant,ModelMap modelMap){
        if(resultRestaurant.hasErrors()) return "redirect:/admin/addRestaurant";
        CuisineCategory cuisineCategory = iCuisineCategoryService.get(restaurantInfoBean.getCuisineId());
        Address address = new Address(restaurantInfoBean.getStreet(),restaurantInfoBean.getCity(),restaurantInfoBean.getState(),
                restaurantInfoBean.getZip(),restaurantInfoBean.getPhoneNumber());
        Restaurant restaurant = new Restaurant(restaurantInfoBean.getName(),restaurantInfoBean.getDescription(),
                restaurantInfoBean.getImage(),Arrays.asList(address),cuisineCategory,null);
        iRestaurantService.save(restaurant);
        return "redirect:/admin/dashboard";
    }

    @RequestMapping("/addMenu")
    public String addMenu(ModelMap modelMap){
        List<Restaurant> restaurants = iRestaurantService.findAll();
        modelMap.addAttribute("restaurants",restaurants);
        modelMap.addAttribute("menu",new Menu());
        return "addMenu";
    }

    @RequestMapping("/saveMenu")
    public String saveMenu(RedirectAttributes redirectAttributes,@ModelAttribute Menu menu,
                           BindingResult bindingResult,@RequestParam String restaurantId){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/admin/addMenu";
        }
        Restaurant restaurant = iRestaurantService.get(Long.parseLong(restaurantId));
        menu.setRestaurant(restaurant);
        menuService.create(menu);
        return "redirect:/admin/dashboard";
    }

    @RequestMapping("/addFood")
     public String addFood(ModelMap modelMap){
        List<Restaurant> restaurants = iRestaurantService.findAll();
        List<Menu> menus = menuService.findAll();
        modelMap.addAttribute("restaurants",restaurants);
        modelMap.addAttribute("foodTypes", FoodType.values());
        modelMap.addAttribute("menus",menus);
        return "addFood";
    }

    @RequestMapping("/saveFood")
    public String saveFood(RedirectAttributes redirectAttributes,@ModelAttribute Food food,
                           BindingResult bindingResult,@RequestParam String restaurantId,ModelMap modelMap){
        List<Restaurant> restaurants = iRestaurantService.findAll();
        List<Menu> menus = menuService.findAll();
        modelMap.addAttribute("restaurants",restaurants);
        modelMap.addAttribute("foodTypes", FoodType.values());
        modelMap.addAttribute("menus",menus);
        return "addFood";
    }
}
