package com.i2i.villapursuit.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.User;

/**
 * Controller to post Advertisement from seller.
 *
 * @author Team #3
 */
@Controller
@RequestMapping("/seller/advertisement*")
public class AdvertisementController extends BaseFormController {
    
	public AdvertisementController() {
        setCancelView("redirect:/seller");
        setSuccessView("advertisementDisplay");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    public Advertisement showForm() {
        return new Advertisement();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Advertisement advertisement, BindingResult errors, HttpServletRequest request) {
    	if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(advertisement, errors);

            if (errors.hasErrors()) {
                return "advertisement";
            }
        }
        
        //Assigning user to Advertisement
        User user = this.getUserManager().getUserByUsername(request.getRemoteUser());
        advertisement.setUser(user);
        
        //saving advertisement to database
        request.setAttribute("advertisement", this.getAdvertisementManager().saveAdvertisement(advertisement));
    	return getSuccessView();
    }
}
