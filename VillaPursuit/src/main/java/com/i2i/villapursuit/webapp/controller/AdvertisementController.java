package com.i2i.villapursuit.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.User;

/**
 * Controller to post Advertisement from seller.
 *
 * @author Team #3
 */
@Controller
public class AdvertisementController extends BaseFormController {

    /**
     * Method which gets request to post advertisement from seller. Redirects it
     * to the advertisement page.
     * 
     * @param advertisement
     *            Contains object of the advertisement
     * @return "advertisement" Returning to the advertisement page.
     */
    @RequestMapping(value = "/advertisementForm", method = RequestMethod.GET)
    public String showForm(Advertisement advertisement) {
        return "advertisement";
    }

    /**
     * Method which gets request to add an advertisement's details. If
     * advertisement added successfully, redirects it to seller page.
     * 
     * @param advertisement
     *            Contains object of the advertisement.
     * @param errors
     *            Contains error message which redirects to jsp page.
     * @param request
     *            Contains object of HTTP Request.
     * @return "advertisement" Returning to advertisement page.
     */
    @RequestMapping(value = "/addAdvertisement", method = RequestMethod.POST)
    public String onSubmit(Advertisement advertisement, BindingResult errors, HttpServletRequest request,
            ModelMap model) {
        try {
            if (request.getParameter("cancel") != null) {
                return "redirect:seller";
            }

            if (validator != null) { // validator is null during testing
                validator.validate(advertisement, errors);

                if (errors.hasErrors()) {
                    return "advertisement";
                }
            }
            // Assigning user to Advertisement
            User user = this.getUserManager().getUserByUsername(request.getRemoteUser());
            advertisement.setUser(user);

            // saving advertisement to database
            request.setAttribute("advertisement", this.getAdvertisementManager().saveAdvertisement(advertisement));
            return getSuccessView();
        } catch (VillaPursuitException e) {
            model.addAttribute("advertisementAddException", e.toString());
            return "advertisement";
        }
    }
}
