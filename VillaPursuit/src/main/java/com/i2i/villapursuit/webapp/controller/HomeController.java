package com.i2i.villapursuit.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller which retrieve all advertisements and redirects to home page.
 *
 * @author Team #3
 */
@Controller
public class HomeController extends BaseFormController {

    /**
     * Method to display active advertisements in buyer page
     * 
     * @param request
     *            Which sends active advertisements as advertisements
     * @return to home page
     */
    @RequestMapping("/home")
    public String getActiveAdvertisements(HttpServletRequest request) {
        request.setAttribute("advertisements", getAdvertisementManager().getActiveAdvertisements());
        return "home";
    }
}
