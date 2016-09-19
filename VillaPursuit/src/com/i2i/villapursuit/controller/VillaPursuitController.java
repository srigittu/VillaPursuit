// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved
package com.i2i.villapursuit.controller;


import java.util.ArrayList;
import java.util.List;

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
import com.i2i.villapursuit.model.Review;
import com.i2i.villapursuit.model.User;
import com.i2i.villapursuit.service.AdvertisementService;
import com.i2i.villapursuit.service.ReviewService;
import com.i2i.villapursuit.service.UserService;

/**
 * <p>
 * Controller which fetches request from the user. 
 * Performs login, user registration, Advertisement posting, 
 * Review an Advertisement and address insertion operations.
 * Redirects the request to the corresponding service classes
 * such as User Service, Advertisement Service and Review Service.
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
	private ReviewService reviewService = new ReviewService();
	
	/**
	 * <p>
	 * Method which fetches request from index page.
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
	 * Method which gets login request with it credentials.
	 * Authenticates the user name and its password if authentication 
	 * operation was successful session is created for user id, user role.
	 * Redirects the request to the home page.
	 * </p>
	 * @param userName
	 *     Contains user name of the user. 
	 * @param password
	 *     Contains password of the user.
	 * @param model
	 *    Contains object of ModelMap class with an advertisements attribute to list
	 *    the set of advertisements.
	 * @param session
	 *     Contains session object such as userId and role.
	 * @return "home_buyer"
	 *     Returning to the Buyer home page.
	 *     If the credentials are not match with the database then it,
	 *     redirects back to the login page.
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
    public String userLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpSession session, ModelMap model) {
        try {
        	User user = userService.getUser(userName);
            if(password.equals(user.getPassword())) {
                session.setAttribute("userId", String.valueOf(user.getId()));
                session.setAttribute("role", user.getRole());
            	return "redirect:gotobuyerpage";	
            } else {
            	return "login";
            }
        }catch(VillaPursuitException e) {
			model.addAttribute("loginException", e.toString());
        	return "login";
        }
	}
	
	/**
	 * <p>
	 * Method which gets request from the user.
	 * If the user role is privileged to seller then it, 
	 * collects all the sellers advertisements.
	 * Redirects it to the corresponding seller page.
	 * </p>
	 * 
	 * @return "home_seller"
	 *     Returning to the seller home page.
	 */
	@RequestMapping(value="seller")
    public String sellerHome(ModelMap model, HttpSession session) {
		List<Advertisement> sellerAdvertisement = new ArrayList<Advertisement>();
		try {
        	for (Advertisement advertisement: advertisementService.getAllAdvertisements()) {
        		if ((advertisement.getUser()).getId() == Integer.parseInt(session.getAttribute("userId").toString())) {
        			sellerAdvertisement.add(advertisement);
        		}
        	}
        	model.addAttribute("sellerAdvertisements", sellerAdvertisement);
        	return "home_seller";
        }catch(VillaPursuitException e) {
			model.addAttribute("sellerException", e.toString());
        	return "home_buyer";
        }
    }
	
	/**
	 * <p>
	 * Method which gets request from user.
	 * If the user role is privileged to seller then
	 * Redirects to buyer
	 * </p>
	 */
	@RequestMapping(value="gotobuyerpage")
	public String gotoBuyer(ModelMap model) {
		try {
		    model.addAttribute("advertisements", advertisementService.getAllAdvertisements());
    	    return "home_buyer";
		} catch(VillaPursuitException e) {
			model.addAttribute("sellerException", e.toString());
        	return "home_buyer";
		}
    }
	/**
	 * <p>
	 * Method which gets registration request from the user.
	 * Then, it redirects the User Object to the Registration page.
	 * </p>
	 * @param user
	 *     Contains object of the user model such as user name, first name,
	 *     last name, password, mobile number, email id and user role.
	 * @return "register"
	 *     Returning to the registration form page.
	 */
	@RequestMapping(value="register_form", method=RequestMethod.GET)
    public String accessUserObject(User user) {
        return "register";            
    }
    
	/**
	 * <p>
	 * Method which gets Address addition request from the user.
	 * Then, it redirects the Address Object to the address form page.
	 * </p>
	 * @param address
	 *     Contains object of the user model such as number, street,
	 *     city, state and pincode.
	 * @param model
	 *    Contains object of ModelMap class with an addAdresss attribute to acknowledge
	 *    back to the user.
	 * @return "home_buyer"
	 *     Returning back buyer home page with address form.
	 */
	@RequestMapping(value="address_form", method=RequestMethod.GET)
    public String accessAddressObject(Address address, ModelMap model) {
		model.addAttribute("addAddress", "addressObject");
		return "home_buyer";
    }
	
	/**
	 * <p>
	 * Method which gets Advertisement addition request from the user.
	 * an advertisement object is created, on binding various model class objects
	 * such as images, facility and address to it.
	 * Then, it redirects the various Advertisement Object to the Advertisement form page.
	 * </p>
	 * @param model
	 *    Contains object of ModelMap class with an advertisement attribute to acknowledge
	 *    back to the seller.
	 * @return "advertisement"
	 *    Returning to the advertisement form page.
	 */
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
	
	/**
	 * <p>
	 * Method which gets review addition request from the buyer.
	 * Then, it redirects the review Object to the review form page.
	 * @param review
	 *    Contains review object such as comment and rating. 
	 * @param model
	 *    Contains object of ModelMap class with an addRewiew attribute to acknowledge
	 *    back to the buyer.
	 * @return "home_buyer"
	 *    Returning back buyer home page with review form.
	 */
	@RequestMapping(value="review_form", method=RequestMethod.GET)
    public String accessReviewObject(@RequestParam("advertisementId") String advertisementId, Review review, ModelMap model) {
		try {
			for (Advertisement advertisement : advertisementService.getAllAdvertisements()) {
				if (advertisement.getAdvertisementId() == Integer.parseInt(advertisementId)){
					model.addAttribute("reviewAdvertisement", advertisement);
				}
			}
			model.addAttribute("addReview", "reviewObject");
			return "home_buyer";
		}catch(VillaPursuitException e) {
			model.addAttribute("loginException", e.toString());
        	return "login";
        }
		
    }
	
	/**
	 * <p>
	 * Method which gets registration request from user with their credentials.
	 * If, the values are Validated then user is added to the database
	 * Then, it redirects to the buyer home page.
	 * </p>
	 * @param user
	 *    Contains user object with it values such as user name, first name,
	 *    last name, password, mobile number, email id and user role.
	 * @param result
	 *    Contains object of BindingResult class with any errors in the user
	 *    provided values.
	 * @param model
	 *    Contains object of ModelMap class in order to send a acknowledgement 
	 *    message to the user whether the user is added are not with an Attribute userAddMessage.
	 * @return "home_buyer"
	 *    Returning to the buyer home page.
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
	 * Method which gets address addition request from user with their credentials.
	 * If, the values are Validated then user address is added to the database
	 * Then, it redirects to the buyer home page.
	 * </p>
     * @param address
     *    Contains user object with it values such as number, street,
	 *     city, state and pincode.
     * @param result
     *    Contains object of BindingResult class with any errors in the address
	 *    provided values.
     * @param model
     *    Contains object of ModelMap class in order to send a acknowledgement 
	 *    message to the user whether the user address is added are not with an Attribute addressAddMessage.
     * @param session
     *    Contains session object such as userId in order to add the address to the user.
     * @return "home_buyer"
     *    Returning to the buyer home page.
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
     * Method which gets advertisement post request from the seller with their credentials.
	 * If, the values are Validated then seller advertisement is added to the database
	 * Then, it redirects to the seller home page.
     * @param advertisement
     *    Contains advertisement object with it values, where various model class objects
	 *    such as images, facility and address are binded to it.
     * @param result
     *    Contains object of BindingResult class with any errors in the advertisement
	 *    provided values.
     * @param model
     *    Contains object of ModelMap class in order to send a acknowledgement 
	 *    message to the seller whether the advertisement is posted 
	 *    are not with an Attribute advertisementAddMessage.
     * @param session
     *    Contains session object such as userId in order to add the user to which posted the advertisement.
     * @return "home_seller"
     *   Returning to the seller home page.
     */
    @RequestMapping(value="add_advertisement")
    public String addAdvertisement(@ModelAttribute("advertisement") Advertisement advertisement, BindingResult result, ModelMap model, HttpSession session) {
    	try {
    		model.addAttribute("advertisementAddMessage", advertisementService.addAdvertisement(advertisement, advertisement.getImages(), advertisement.getFacility(), advertisement.getAddress(), Integer.parseInt(session.getAttribute("userId").toString())));
    		model.addAttribute("advertisements", advertisementService.getAllAdvertisements());
    		return "home_seller";
    	} catch(VillaPursuitException e){
    		model.addAttribute("advertisementAddException", e.toString());
    		return "home_seller";
    	}
    }
    
    /**
     * Method which gets advertisement review request from the buyer with their credentials.
	 * If, the values are Validated then buyer review to the particular advertisement is added to the database
	 * Then, it redirects to the buyer home page.
     * @param advertisementId
     *    Contains id for the particular advertisement to which buyer provides the review.
     * @param review
     *    Contains the review object such as comment and rating.
     * @param result
     *    Contains object of BindingResult class with any errors in the advertisement
	 *    provided values.
     * @param model
     *    Contains object of ModelMap class in order to send a acknowledgement 
	 *    message to the buyer whether the advertisement review is posted
	 *    are not with an Attribute reviewAddMessage.
     * @param session
     *    Contains session object such as userId in order to add the user to which posted the advertisement review.
     * @return "home_buyer"
     *    Returning to the buyer home page.
     */
    @RequestMapping(value="add_review")
    public String addAdvertisementReview(@RequestParam("advertisementId") String advertisementId, Review review, BindingResult result, ModelMap model, HttpSession session) {
    	try {
    		model.addAttribute("reviewAddMessage", reviewService.addAdvertisementReview(review, Integer.parseInt(advertisementId), Integer.parseInt(session.getAttribute("userId").toString())));
    		model.addAttribute("advertisements", advertisementService.getAllAdvertisements());
    		return "home_buyer";
    	} catch(VillaPursuitException e){
    		model.addAttribute("addressAddException", e.toString());
    		return "home_buyer";
    	}
    }
    
    /**
     * Method which gets viewer for the particular advertisement request from the buyer.
	 * If, the user viewed the advertisement then user is updated to the database
	 * Then, it redirects to the buyer home page.
     * @param advertisementId
     *    Contains id for the particular advertisement to which buyer provides the review.
     * @param model
     *    Contains object of ModelMap class in order to send a acknowledgement 
	 *    message to the seller whenever buyer viewed the advertisement
	 *    are not with an Attribute viewSellerAdvertisement.
     * @param session
     *    Contains session object such as userId in order to add the user to which posted the advertisement.
     * @return
     */
    @RequestMapping(value="view_seller")
    public String viewSeller(@RequestParam("advertisementId") String advertisementId, ModelMap model, HttpSession session) {
    	try {
    		advertisementService.setAdvertisementViewer(Integer.parseInt(session.getAttribute("userId").toString()), Integer.parseInt(advertisementId));
    		model.addAttribute("viewSellerAdvertisement", advertisementService.retriveAdvertisementById(Integer.parseInt(advertisementId)));
    		return "home_buyer";
    	} catch(VillaPursuitException e){
    		model.addAttribute("addressAddException", e.toString());
    		return "home_buyer";
    	}
    }
    
    /**
     * Method which gets request from the user privileged page.
	 * Then, it redirects to the buyer home page.
     * @param model
     *    Contains object of ModelMap class with an advertisements attribute to list
	 *    the set of advertisements.
     * @return "home_buyer"
     *    Returning to the buyer home page.
     */
    @RequestMapping(value="home")
    public String home(ModelMap model) {
    	try {
    		model.addAttribute("advertisements", advertisementService.getAllAdvertisements());
    		return "home_buyer";
    	} catch(VillaPursuitException e){
    		model.addAttribute("addressAddException", e.toString());
    		return "home_buyer";
    	}
    }
    
    /**
     * <p>
     * Method which performs logout operation.
     * </p>
     * @param session
     *     Contains object of the HTTP session.
     * @return "login"
     *     JSP page that contains login form.
     */
    @RequestMapping(value="logout")
    public String logout(HttpSession session) {
        session.invalidate();
    	return "login";            
    }
}
