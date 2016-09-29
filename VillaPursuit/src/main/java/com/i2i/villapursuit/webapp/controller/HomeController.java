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
public class HomeController extends BaseFormController{
    
    /**
     * Method which gets request from user.
     * Redirects to home page which contains all the posted advertisements.
     * @param request
     *            Contains object of HTTP Request.
     */
    @RequestMapping("/home")
    public String getActiveAdvertisements(HttpServletRequest request){
        request.setAttribute("advertisements", getAdvertisementManager().getActiveAdvertisements());
        System.out.println(getAdvertisementManager().getActiveAdvertisements().size());
        return "home";
    }
}
