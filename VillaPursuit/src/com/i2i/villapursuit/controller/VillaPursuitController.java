/**
 * @author Team #3
 *
 * @created 07/09/16 
 */
package com.i2i.villapursuit.controller;


//import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Address;
import com.i2i.villapursuit.model.User;
import com.i2i.villapursuit.service.UserService;
 
@Controller
public class VillaPursuitController {   
	private UserService userService = new UserService();
	
	@RequestMapping(value="welcome")
    public String welcome() {
        return "login";            
    }
	
	@RequestMapping(value="register_form", method=RequestMethod.GET)
    public String accessUser(User user) {
        return "register";            
    }

	@RequestMapping(value="address_form", method=RequestMethod.GET)
    public String accessAddress(Address address) {
        return "home";            
    }
	
    @RequestMapping(value="register")
    public String addUser(User user, BindingResult result, ModelMap model) throws VillaPursuitException {
    	model.addAttribute("userObject", userService.addUser(user));
        return "home";
    }
    
	@RequestMapping(value="address")
    public String addUserAddress(Address address, BindingResult result, ModelMap model) throws VillaPursuitException {
        model.addAttribute("addressMessage", userService.addUserAddress(address));
        return "home";
    }
	
}
