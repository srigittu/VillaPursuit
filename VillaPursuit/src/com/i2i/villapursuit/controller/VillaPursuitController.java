// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved

package com.i2i.villapursuit.controller;


import javax.servlet.http.HttpSession;

//import javax.validation.Valid;

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
	private ReviewService reviewService = new ReviewService();
	
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
                session.setAttribute("userId", user.getId());
                session.setAttribute("user", user);
                if("buyer".equals(user.getRole())) {
                	session.setAttribute("role", user.getRole());
                    model.addAttribute("advertisements", advertisementService.getAllAdvertisements());
            	    return "redirect:gotohomebuyer";
                } else if("seller".equals(user.getRole())) {
                	session.setAttribute("role", user.getRole());
                	return "home_seller";
                } else {
                	return "login";
                }
            	
            } else {
            	return "login";
            }
        }catch(Exception e) {
        	System.out.println(e.toString());
			model.addAttribute("loginException", e.toString());
        	return "login";
        }
	}
	
	@RequestMapping("/gotohomebuyer")
	public String gotoHomeBuyer(ModelMap model) throws VillaPursuitException {
		model.addAttribute("advertisements", advertisementService.getAllAdvertisements());
		return "home_buyer";
	}
	/**
	 * <p>
	 * Method which gets request from seller.
	 * Redirects it to the corresponding seller page.
	 * </p>
	 * @return "home_seller"
	 *     Returning to the registration form page of seller.
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
	 * Bind advertisement, user and facility objects into single object.
	 * Redirects it to the corresponding review page.
	 * </p>
	 * @param model
	 *     Contains object of the model map class.
	 * @return "review"
	 *     JSP page that contains review form.
	 */
	@RequestMapping(value="review_form", method=RequestMethod.GET)
    public String accessReviewObject(ModelMap model, @RequestParam("advertisementId") int id) {
		Review review = new Review();
		review.setUser(new User());
		model.addAttribute("review",review);
		model.addAttribute("id", id);
        return "review";            
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

    @RequestMapping(value="add_advertisement")
    public String addAdvertisement(@ModelAttribute("advertisement") Advertisement advertisement, BindingResult result, ModelMap model, HttpSession session) {
    	try {
    		model.addAttribute("advertisementAddMessage", advertisementService.addAdvertisement(advertisement, advertisement.getImages(), advertisement.getFacility(), advertisement.getAddress(), Integer.parseInt(session.getAttribute("userId").toString())));
    		return "home_seller";
    	} catch(VillaPursuitException e){
    		model.addAttribute("advertisementAddException", e.toString());
    		return "home_seller";
    	}
    }
    
    /**
     * <p>
     * Method which fetches request for adding an review.
     * Redirects it to the corresponding page.
     * </p>
     * @param advertisementId
     *     Contains advertisement Id.
     * @param review
     *     Contains object of the review model.
     * @param result
     *     Contains object of the binding result class.
     * @param model
     *     Contains object of the model map class.
     * @param session
     *     Contains object of the HTTP session object.
     * @return "home_buyer"
     *     JSP page that contains buyer functionality.
     */
    
    @RequestMapping(value="add_review")
    public String addAdvertisementReview(@ModelAttribute("review") Review review, BindingResult result,
    		ModelMap model, HttpSession session, @RequestParam("advertisementId") int id) {
    	try {
    		model.addAttribute("addressAddMessage", reviewService.addAdvertisementReview(review,
    				id, Integer.parseInt(session.getAttribute("userId").toString())));
    		return "home_buyer";
    	} catch(VillaPursuitException e){
    		model.addAttribute("reviewAddException", e.toString());
    		return "home_buyer";
    	}
    }
    
    /**
     * <p>
     * Method which fetches request for view the reviews.
     * Redirects it to the corresponding page.
     * </p>
     * @param model
     *     Object of the Model map class.
     * @return "view_review"
     *     JSP page that contains review details.
     */
    
    @RequestMapping(value = "view_review")
    public String viewAllReviews(ModelMap model) {
        try {
        	model.addAttribute("reviews",reviewService.retriveAllReviews());
        	return "view_review";
        } catch(VillaPursuitException e) {
        	model.addAttribute("reviewException", e.toString());
        	return "view_review";
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
    
    
	@RequestMapping("/logout")
    public String processRequest(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
