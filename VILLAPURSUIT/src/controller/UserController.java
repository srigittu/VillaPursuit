package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import model.User;
import model.Address;
import model.Advertisement;
import model.Facility;
import model.Review;
import service.AddressService;
import service.UserService;
import service.AdvertisementService;
import service.FacilityService;
import service.ReviewService;

@Controller
public class UserController {
	private Advertisement advertisement;
    private User user;
	UserService userService = new UserService();
	AddressService addressService = new AddressService();
	AdvertisementService advertisementService = new AdvertisementService();
	FacilityService facilityService = new FacilityService();
	ReviewService reviewService = new ReviewService();
	
	@RequestMapping(value = "/index", method = RequestMethod.POST)
    public String userLogin(@RequestParam("userId") String userId, @RequestParam("password") String password, HttpSession session ) {
        try {
        	user = userService.getUserById(Integer.parseInt(userId));
            if(password.equals(user.getPassword())) {
                return "mainpage";	
            } else {
            	return "index";
            }
        }catch(Exception e) {
        	return "index";
        }
	}
	
	@RequestMapping("/initiate")
    public String accessUser(ModelMap model) {
        model.addAttribute("adduser", new User());
        return "insertuser";
    }
	
	@RequestMapping(value = "/insertuser")
    private ModelAndView insertUser(@ModelAttribute("adduser") User user, BindingResult result) {
        String message = " ";
        System.out.println(user.getFirstName());
        try {
            if(null != userService.addUser(user)) {
                System.out.println(user.getEmail());
                message = "inserted successfully";
            } else {
                message = "insertion failed";
            }
        } catch (Exception e) {
            message = e.toString();
        } finally {
            return new ModelAndView("insertuser", "Message", message);
        }
    }
	
	@RequestMapping("/insertanaddress")
    public String accessAddress(ModelMap modelMap) {
        modelMap.addAttribute("addaddress", new Address());
        return "insertaddress";
    }
	
	@RequestMapping(value = "/insertaddress")
    private ModelAndView insertEmployee(@ModelAttribute("addaddress") Address address, BindingResult result) {
        String message = " ";
        try {
            if(null != addressService.addAddress(address)) {
            	user.setUserAddress(address);
            	userService.updateAddress(user);
                message = "inserted successfully";
            } else {
                message = "insertion failed";
            }
        } catch (Exception e) {
            message = e.toString();
        } finally {
            return new ModelAndView("insertaddress", "Message", message);
        }
    }
	
	@RequestMapping("/insertanadvertisement")
    public String accessAdvertisement(ModelMap modelMap) {
        modelMap.addAttribute("addadvertisement", new Advertisement());
        return "insertadvertisement";
    }
	
	@RequestMapping(value = "/insertadvertisement")
    private ModelAndView insertAdvertisement(@ModelAttribute("addadvertisement") Advertisement advertisement, BindingResult result) {
        String message = " ";
        try {
            if(null != advertisementService.addAdvertisement(advertisement)) {
            	advertisement.setUser(user);
            	advertisementService.updateAdvertisement(advertisement);
                message = "inserted successfully";
            } else {
                message = "insertion failed";
            }
        } catch (Exception e) {
            message = e.toString();
        } finally {
            return new ModelAndView("insertadvertisement", "Message", message);
        }
    }
	
	@RequestMapping("/insertanfacility")
    public String accessFacility(ModelMap modelMap) {
        modelMap.addAttribute("addfacility", new Facility());
        return "insertfacility";
    }
	
	@RequestMapping(value = "/insertfacility")
    private ModelAndView insertFacility(@ModelAttribute("addfacility") Facility facility, BindingResult result) {
        String message = " ";
        try {
            if(null != facilityService.addFacility(facility)) {
                message = "inserted successfully";
            } else {
                message = "insertion failed";
            }
        } catch (Exception e) {
            message = e.toString();
        } finally {
            return new ModelAndView("insertfacility", "Message", message);
        }
    }
	
	@RequestMapping("/viewalladvertisements")
    private String viewAllAdvertisements(ModelMap model) {
        try {
            model.addAttribute("advertisements",advertisementService.getAllAdvertisements());
        } catch (Exception e) {
        	model.addAttribute("Message",e.toString());
        } finally {
        	return "viewalladvertisements";
        }
    }
	
	
	@RequestMapping("/insertanreview")
    public String accessReview(ModelMap modelMap, @RequestParam("advertisementId") String advertisementId) {
        modelMap.addAttribute("addreview", new Review());
        return "redirect:insertreview?advertisementId="+advertisementId;
    }
	
	@RequestMapping(value = "/insertreview")
    private ModelAndView insertReview(@ModelAttribute("addreview") Review review,@RequestParam("advertisementId") String advertisementId ) {
        String message = " ";
        System.out.println(advertisementId);
        try {
            if(null != reviewService.addReview(review)) {
            	System.out.println(advertisementId);
            	review.setUser(user);
            	reviewService.updateReview(review);
            	advertisement = advertisementService.getAdvertisementById(Integer.parseInt(advertisementId));
            	review.setAdvertisement(advertisement);
            	reviewService.updateReview(review);
                message = "inserted successfully";
            } else {
                message = "insertion failed";
            }
        } catch (Exception e) {
            message = e.toString();
        } finally {
            return new ModelAndView("insertreview", "Message", message);
        }
    }
	
	@RequestMapping("/viewallreviews")
    private String viewAllReviews(ModelMap model,@RequestParam("advertisementId") String advertisementId) {
        try {
        	advertisement = advertisementService.getAdvertisementById(Integer.parseInt(advertisementId));
        	List<Review> reviews = advertisement.getReviews();
        	System.out.println(reviews);
            model.addAttribute("reviews",reviews);
        } catch (Exception e) {
        	model.addAttribute("Message",e.toString());
        } finally {
        	return "viewallreviews";
        }
    }
	
	@RequestMapping("/logout")
    public String processRequest(HttpSession session) {
        	session.invalidate();
        return "index";
    }
}

