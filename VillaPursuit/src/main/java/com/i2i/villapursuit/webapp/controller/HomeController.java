package com.i2i.villapursuit.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.i2i.villapursuit.service.AdvertisementManager;

@Controller
public class HomeController {
    AdvertisementManager advertisementManager = null;
	
	@Autowired
    public void setAdvertisementManager(AdvertisementManager advertisementManager) {
        this.advertisementManager = advertisementManager;
    }
	
	@RequestMapping("/home")
    public String getActiveAdvertisements(HttpServletRequest request){
		System.out.println("hell00o");
		request.setAttribute("advertisements", this.advertisementManager.getActiveAdvertisements());
		System.out.println(this.advertisementManager.getActiveAdvertisements().size());
    	return "home";
    }
}
