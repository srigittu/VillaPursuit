package com.i2i.villapursuit.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.Review;
import com.i2i.villapursuit.model.User;
import com.i2i.villapursuit.service.AdvertisementManager;

/**
 * Controller to post Advertisement from seller.
 *
 * @author Team #3
 */
@Controller
public class ReviewController extends BaseFormController {
	@Autowired
    AdvertisementManager advertisementManager;
    @RequestMapping(value = "/reviewForm", method = RequestMethod.GET)
    public String showForm(Review review,@RequestParam("advertisementId") Long adverisementId, ModelMap model) {
    	model.addAttribute("advertisementId", adverisementId);
        return "review";
    }
    
    @RequestMapping(value = "/addReview", method = RequestMethod.POST)
    public String onSubmit(Review review, BindingResult errors, HttpServletRequest request, @RequestParam("advertisementId") Long advertisementId ) {
    	/*if (request.getParameter("cancel") != null) {
            return "redirect:seller";
        }

        if (validator != null) { // validator is null during testing
            validator.validate(review, errors);

            if (errors.hasErrors()) {
                return "review";
            }
        }*/
        
        //Assigning user to Review
    	System.out.println(advertisementId);
        User user = this.getUserManager().getUserByUsername(request.getRemoteUser());
        Advertisement advertisement = advertisementManager.getAdvertisementById(advertisementId);
        review.setUser(user);
        review.setAdvertisement(advertisement);
        //saving review to database
        request.setAttribute("review", this.getReviewManager().saveReview(review));
        
    	return "redirect:/home";
    }
}
