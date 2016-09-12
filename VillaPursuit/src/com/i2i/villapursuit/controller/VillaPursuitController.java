// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved

package com.i2i.villapursuit.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
	
	/**
	 * <p>
	 * Method which gets request from seller.
	 * Redirects it to the corresponding seller page.
	 * </p>
	 * @return "home"
	 *     Returning to the registration form page.
	 */
	
	@RequestMapping(value="seller")
    public String sellerHome() {
        return "home_seller";            
    }
	
	/**
	 * <p>
	 * Method which gets registration request from seller.
	 * Redirects it to the corresponding page after registration was completed.
	 * </p>
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
	 * </p>
	 * @param address
	 *     Contains object of address model.
	 * @param model
	 *     Contains object of ModelMap class. 
	 * @return home
	 *     Returning to the home page for buyer.
	 */

	@RequestMapping(value="address_form", method=RequestMethod.GET)
    public String accessAddressObject(Address address, ModelMap model) {
		model.addAttribute("addAddress", "addressObject");
		return "home_buyer";
    }
	
	/**
	 * <p>
	 * Method which fetches request.
	 * Bind advertisement, image, facility and address objects into single object.
	 * Redirects it to the corresponding home page.
	 * </p>
	 * @param model
	 *     Contains object of model map class.
	 * @return advertisement
	 *     Returning to the advertisement page.
	 */
	
	@RequestMapping(value="advertisement_form", method=RequestMethod.GET)
    public String accessAdvertisementObject(ModelMap model) {
		List<Object> advertisementObject = new ArrayList<Object>();
		advertisementObject.add(new Advertisement());
		advertisementObject.add(new Image());
		advertisementObject.add(new Facility());
		advertisementObject.add(new Address());
		model.addAttribute("advertisementObject", advertisementObject);
		return "advertisement";            
    }
	
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
	 * @return "home_buyer"
	 *     Returning to the home page of the buyer.
	 */
    
    @RequestMapping(value="register")
    public String addUser(User user, BindingResult result, ModelMap model) {
    	try {
    		model.addAttribute("userAddMessage", userService.addUser(user));
    		return "home_buyer";
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
     * @return "home_buyer"
     *     Returning to the home page of the buyer.
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
    
    /**
     * <p>
     * Method which fetches request for posting advertisement details.
     * Redirects it to the corresponding page.
     * </p>
     * @param advertisement
     *     Contains object of the advertisement model.
     * @param images
     *     Contains object of the image model.
     * @param facilities
     *     Contains object of the facility model.
     * @param advertisementAddress
     *     Contains object of the address model.
     * @param result
     *     Contains object of the binding result class
     * @param model
     *     Contains object of the model map class
     * @param session
     *     Contains the HTTP session object.
     * @return "home_seller"
     *     Returning it to the page that contains seller post information.
     *     
     */
    
    @RequestMapping(value="addAdvertisement")
    public String addAdvertisement(Advertisement advertisement, Image images, Facility facilities, Address advertisementAddress, BindingResult result, ModelMap model, HttpSession session) {
    	try {
    		model.addAttribute("advertisementAddMessage", advertisementService.addAdvertisement(advertisement, images, facilities, advertisementAddress, Integer.parseInt(session.getAttribute("userId").toString())));
    		return "home_seller";
    	} catch(VillaPursuitException e){
    		model.addAttribute("advertisementAddException", e.toString());
    		return "home_seller";
    	}
    }
}
