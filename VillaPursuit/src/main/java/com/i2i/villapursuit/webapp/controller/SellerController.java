package com.i2i.villapursuit.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/seller*")
public class SellerController extends BaseFormController{
	
	public SellerController() {
        System.out.println("hello");
		setCancelView("redirect:/home");
        setSuccessView("seller");
    }
    
    public String getActiveAdvertisements(HttpServletRequest request){
        request.setAttribute("advertisements", this.getAdvertisementManager().getActiveAdvertisements());
    	return getSuccessView();
    }
}
