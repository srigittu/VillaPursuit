package com.i2i.villapursuit.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.Review;
import com.i2i.villapursuit.model.User;
import com.i2i.villapursuit.service.AdvertisementManager;
import com.i2i.villapursuit.service.ReviewManager;

/**
 * Controller to post Review from buyer.
 *
 * @author Team #3
 */
@Controller
public class ReviewController extends BaseFormController {
    @Autowired
    AdvertisementManager advertisementManager;
    ReviewManager reviewManager;

    /**
     * Method which gets request from home page. Redirects to review page with
     * the corresponding advertisement Id.
     * 
     * @param review
     *            Contains object of Review.
     * @param advertisementId
     *            Contains Id of an advertisement.
     * @param model
     *            Contains object of the model map class.
     * @return "review" Returning to the review page.
     */
    @RequestMapping(value = "/reviewForm", method = RequestMethod.GET)
    public String showForm(Review review, @RequestParam("advertisementId") Long advertisementId, ModelMap model) {
        try {
            model.addAttribute("reviewAdvertisement", advertisementManager.getAdvertisementById(advertisementId));
            model.addAttribute("advertisementId", advertisementId);
            return "review";
        } catch (VillaPursuitException e) {
            model.addAttribute("reviewAddMessage", e.toString());
            return "home";
        }
    }

    /**
     * Method which gets request to add an review from buyer. Gets the values
     * from requested page and saves it into database.
     * 
     * @param review
     *            Contains object of Review.
     * @param errors
     *            Contains error object.
     * @param request
     *            Contains object of the HTTP request.
     * @param advertisementId
     *            Contains Id of an advertisement.
     * @return "review" Returning to the review page.
     */
    @RequestMapping(value = "/addReview", method = RequestMethod.POST)
    public String onSubmit(Review review, BindingResult errors, HttpServletRequest request,
            @RequestParam("advertisementId") Long advertisementId, ModelMap model) {
        // Assigning user to Review
        try {
            User user = this.getUserManager().getUserByUsername(request.getRemoteUser());
            Advertisement advertisement = advertisementManager.getAdvertisementById(advertisementId);
            review.setUser(user);
            review.setAdvertisement(advertisement);
            // saving review to database
            request.setAttribute("review", this.getReviewManager().saveReview(review));
            return "redirect:/home";
        } catch (VillaPursuitException e) {
            model.addAttribute("reviewAddMessage", e.toString());
            return "home";
        }
    }

    /**
     * Method which gets request to add an review from buyer. Gets the values
     * from requested page and saves it into database.
     * 
     * @param request
     *            Contains object of the HTTP request.
     * @param advertisementId
     *            Contains Id of an advertisement.
     * @return "home" Returning to the home page.
     */
    @RequestMapping("/getReview")
    public String getReviews(HttpServletRequest request, @RequestParam("advertisementId") Long advertisementId,
            ModelMap model) {
        try {
            request.setAttribute("reviews", reviewManager.getAdvertisementReviews(advertisementId));
            return "home";
        } catch (VillaPursuitException e) {
            model.addAttribute("reviewAddMessage", e.toString());
            return "home";
        }
    }
}
