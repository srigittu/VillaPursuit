// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved

package com.i2i.villapursuit.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Address;
import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.Facility;
import com.i2i.villapursuit.model.Image;
import com.i2i.villapursuit.model.User;
import com.i2i.villapursuit.service.AdvertisementService;

import com.i2i.villapursuit.service.UserService;

/**
 * <p>
 * Controller which fetches request. 
 * Performs login, user registration and address insertion operations.
 * Redirects the request to the corresponding service class.
 * </p>
 *
 * @author Team #3
 *
 * @created 07/09/16 
 * 
 */
 
@Controller
public class VillaPursuitController {   
	private UserService userService = new UserService();
	private AdvertisementService advertisementService = new AdvertisementService();
	private User user;
	
	/**
	 * <p>
	 * Method which fetches request.
	 * Redirects it to the login page.
	 * </p>
	 * @return "login"
	 *     Returning to login page.
	 */
	@RequestMapping(value="welcome")
    public String welcome() {
        return "login";            
    }
	
	/**
	 * <p>
	 * Method which gets login request.
	 * Redirects the request to the home page if login operation was successful.
	 * </p>
	 * @param userName
	 *     Contains name of the user. 
	 * @param password
	 *     Contains password of the user
	 * @param session
	 *     Contains session object
	 * @return "home"
	 *     Returning to the home page.
	 */
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
    public String userLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpSession session, ModelMap model) {
        try {
        	User user = userService.getUser(userName);
            if(password.equals(user.getPassword())) {
                session.setAttribute("userId", String.valueOf(user.getId()));
                session.setAttribute("role", user.getRole());
            	return "home_buyer";	
            } else {
            	return "login";
            }
        }catch(Exception e) {
        	System.out.println(e.toString());
			model.addAttribute("loginException", e.toString());
        	return "login";
        }
	}
	
	@RequestMapping(value="seller")
    public String sellerHome() {
        return "home_seller";            
    }
	/**
	 * <p>
	 * Method which gets registration request.
	 * Redirects it to the corresponding page after registration was completed.
	 * @param user
	 *     Contains object of the user model.
	 * @return "register"
	 *     Returning to the registration form page.
	 */
	
	@RequestMapping(value="register_form", method=RequestMethod.GET)
    public String accessUserObject(User user) {
        return "register";            
    }
	
	/**
	 * <p>
	 * Method which fetches request.
	 * Add address object as the model attribute.
	 * Returns to the home page.
	 * @param address
	 *     Contains object of address model.
	 * @param model
	 *     Contains object of ModelMap class. 
	 * @return home
	 *     Returning to the home page.
	 */

	@RequestMapping(value="address_form", method=RequestMethod.GET)
    public String accessAddressObject(Address address, ModelMap model) {
		model.addAttribute("addAddress", "addressObject");
		return "home_buyer";
    }
	
	@RequestMapping(value="advertisement_form", method=RequestMethod.GET)
    public String accessAdvertisementObject(ModelMap model) {
		Advertisement advertisement = new Advertisement();
		advertisement.setFacility(new Facility());
		advertisement.addImages(new Image());
		advertisement.addImages(new Image());
		advertisement.setAddress(new Address());
		model.addAttribute("advertisement" , advertisement);
		return "advertisement";            
    }
	
    @RequestMapping(value="register")
    public String addUser(User user, BindingResult result, ModelMap model) {
    	try {
    		model.addAttribute("userAddMessage", userService.addUser(user));
    		return "home_buyer";
	/**
	 * <p>
	 * Method which fetches request for registration of user.
	 * Redirects to the corresponding page if the registration was successful.
	 * </p>
	 * @param user
	 *     Contains object of User model.
	 * @param result
	 *     Contains object of BindingResult Object.
	 * @param model
	 *     Contains object of ModelMap class.
	 * @return "home"
	 *     Returning to the home page.
	 */
	
    @RequestMapping(value="register_buyer")
    public String addUser(User user, BindingResult result, ModelMap model) {
    	try {
    		model.addAttribute("userAddMessage", userService.addUser(user));
    		return "confirmlogin";
    	} catch(VillaPursuitException e){
    		model.addAttribute("userAddException", e.toString());
    		return "home_buyer";
    	}
    }
    
    /**
     * <p>
     * Method which fetches request for address registration.
     * Redirects to the home page if address registration was successful.
     * </p>
     * @param address
     *     Contains object of Address model.
     * @param result
     *     Contains object of BindingResult class.
     * @param model
     *     Contains object of ModelMap class.
     * @param session
     *     Contains session object.
     * @return "home"
     *     Returning to the home page.
     */
    
    @RequestMapping(value="user_address")
    public String addAddress(Address address, BindingResult result, ModelMap model, HttpSession session) {
    	try {
    		model.addAttribute("addressAddMessage", userService.addUserAddress(address, Integer.parseInt(session.getAttribute("userId").toString())));
    		return "home_buyer";
    	} catch(VillaPursuitException e){
    		model.addAttribute("addressAddException", e.toString());
    		return "home_buyer";
    	}
    }
    
    @RequestMapping(value="addAdvertisement")
    public String addAdvertisement(@ModelAttribute("advertisement") Advertisement advertisement, BindingResult result, ModelMap model, HttpSession session) {
    	try {
    		model.addAttribute("advertisementAddMessage", advertisementService.addAdvertisement(advertisement, advertisement.getImages(), advertisement.getFacility(), advertisement.getAddress(), Integer.parseInt(session.getAttribute("userId").toString())));
    		return "home_seller";
    	} catch(VillaPursuitException e){
    		model.addAttribute("advertisementAddException", e.toString());
    		return "home_seller";
    	}
    }
}
