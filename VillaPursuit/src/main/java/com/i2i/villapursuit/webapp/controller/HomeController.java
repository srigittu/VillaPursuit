package com.i2i.villapursuit.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController extends BaseFormController{
    
	@RequestMapping("/home")
    public String getActiveAdvertisements(HttpServletRequest request){
		System.out.println("hell00o");
		request.setAttribute("advertisements", getAdvertisementManager().getActiveAdvertisements());
		System.out.println(getAdvertisementManager().getActiveAdvertisements().size());
    	return "home";
    }
}
