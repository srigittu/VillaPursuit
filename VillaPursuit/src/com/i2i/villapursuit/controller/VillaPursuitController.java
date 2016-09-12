/**
 * @author Team #3
 *
 * @created 07/09/16 
 */
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
 
@Controller
public class VillaPursuitController {   
	private UserService userService = new UserService();
	private AdvertisementService advertisementService = new AdvertisementService();
	private ReviewService reviewService = new ReviewService();
	
	@RequestMapping(value="welcome")
    public String welcome() {
        return "login";            
    }
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
    public String userLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpSession session, ModelMap model) {
        try {
        	User user = userService.getUser(userName);
            if(password.equals(user.getPassword())) {
                session.setAttribute("userId", String.valueOf(user.getId()));
                session.setAttribute("role", user.getRole());
                model.addAttribute("advertisements", advertisementService.getAllAdvertisements());
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
	
	@RequestMapping(value="register_form", method=RequestMethod.GET)
    public String accessUserObject(User user) {
        return "register";            
    }

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
    	} catch(VillaPursuitException e){
    		model.addAttribute("userAddException", e.toString());
    		return "home_buyer";
    	}
    }
    
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
     * 
     * @param advertisement
     * @param result
     * @param model
     * @param session
     * @return
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
    
    @RequestMapping(value="add_review")
    public String addAdvertisementReview(@RequestParam("advertisementId") String advertisementId, Review review, BindingResult result, ModelMap model, HttpSession session) {
    	try {
    		model.addAttribute("addressAddMessage", reviewService.addAdvertisementReview(review, Integer.parseInt(session.getAttribute("advertisementId").toString()), Integer.parseInt(session.getAttribute("userId").toString())));
    		return "home_buyer";
    	} catch(VillaPursuitException e){
    		model.addAttribute("addressAddException", e.toString());
    		return "home_buyer";
    	}
    }
}
