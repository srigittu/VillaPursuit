package com.i2i.villapursuit.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.i2i.villapursuit.service.AdvertisementManager;


@Controller
public class SellerController {
	AdvertisementManager advertisementManager = null;
	
	@Autowired
    public void setAdvertisementManager(AdvertisementManager advertisementManager) {
        this.advertisementManager = advertisementManager;
    }
	
	@RequestMapping("/seller")
    public String getActiveAdvertisements(HttpServletRequest request){
		System.out.println("hell00o");
		request.setAttribute("sellerAdvertisements", this.advertisementManager.getAdvertisements());
		System.out.println(this.advertisementManager.getAdvertisements().size());
    	return "seller";
    }
}
