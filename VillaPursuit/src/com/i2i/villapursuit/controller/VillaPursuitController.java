/**
 * @author Team #3
 *
 * @created 07/09/16 
 */
package com.i2i.villapursuit.controller;


import javax.servlet.http.HttpSession;
import javax.websocket.Session;

//import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Address;
import com.i2i.villapursuit.model.User;
import com.i2i.villapursuit.service.UserService;
 
@Controller
public class VillaPursuitController {   
	private UserService userService = new UserService();
	private User user;
	@RequestMapping(value="welcome")
    public String welcome() {
        return "login";            
    }
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
    public String userLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpSession session) {
        try {
        	user = userService.getUser(userName);
            if(password.equals(user.getPassword())) {
                session.setAttribute("userId", String.valueOf(user.getId()));
                session.setAttribute("role", user.getRole());
            	return "home";	
            } else {
            	return "login";
            }
        }catch(Exception e) {
        	System.out.println(e.toString());
        	return "login";
        }
	}
	
	@RequestMapping(value="register_form", method=RequestMethod.GET)
    public String accessUser(User user) {
        return "register";            
    }

	@RequestMapping(value="address_form", method=RequestMethod.GET)
    public String accessAddress(Address address) {
        return "home";
    }
	
    @RequestMapping(value="register_buyer")
    public String addUser(User user, BindingResult result, ModelMap model) {
    	try {
    		model.addAttribute("userAddMessage", userService.addUser(user));
    		return "home";
    	} catch(VillaPursuitException e){
    		model.addAttribute("addressAddMessage", e.toString());
    		return "home";
    	}
    }
    
    @RequestMapping(value="user_address")
    public String addAddress(Address address, BindingResult result, ModelMap model, HttpSession session) {
    	try {
    		model.addAttribute("addressAddMessage", userService.addUserAddress(address, Integer.parseInt(session.getAttribute("userId").toString())));
    		return "home";
    	} catch(VillaPursuitException e){
    		model.addAttribute("addressAddMessage", e.toString());
    		return "home";
    	}
    }
	
}
