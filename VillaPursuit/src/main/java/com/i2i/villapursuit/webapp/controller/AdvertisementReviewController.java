package com.i2i.villapursuit.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.AdvertisementReview;
import com.i2i.villapursuit.model.User;

/**
 * Controller to post review to advertisement from buyer.
 *
 * @author Team #3
 */
@Controller
public class AdvertisementReviewController extends BaseFormController {

    /**
     * Method which send advertisement review form to buyer
     * 
     * @param request
     *            Which gets avdertisement id to which buyer to give review
     * @param advertisementReview
     *            To which buyer to put comments and ratings
     * @param model
     *            Which sends particular advertisement details as
     *            reviewAdvertisement
     * @return to advertisementReview page.
     */
    @RequestMapping(value = "/reviewForm", method = RequestMethod.GET)
    public String reviewForm(HttpServletRequest request, AdvertisementReview advertisementReview, ModelMap model) {
        for (Advertisement advertisement : getAdvertisementManager().getActiveAdvertisements()) {
            if (advertisement.getId() == Long.valueOf((String) request.getParameter("advertisementId"))) {
                model.addAttribute("reviewAdvertisement", advertisement);
            }
        }
        return "advertisementReview";
    }

    /**
     * Method which saves advertisement review from buyer
     * 
     * @param advertisementReview
     *            Consist of comment and ratings
     * @param request
     *            Which gets avdertisement id to which buyer to give review
     * @param result
     *            Binds if any null values are provided in entered details.
     * @param model
     *            Which sends notification to buyer about review addition
     * @return to advertisementReview page.
     */
    @RequestMapping(value = "/addReview")
    public String reviewForm(AdvertisementReview advertisementReview, HttpServletRequest request, BindingResult result,
            ModelMap model) {
        Long advertisementId = Long.valueOf((String) request.getParameter("advertisementId"));
        User user = this.getUserManager().getUserByUsername(request.getRemoteUser());
        getAdvertisementReviewManager().saveAdvertisementReview(advertisementReview, advertisementId, user);
        model.addAttribute("reviewAddMessage", "Review Posted Successfully");
        return "advertisementReview";
    }

}
