package com.i2i.villapursuit.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.User;

/**
 * Controller which performs from seller operation.
 *
 * @author Team #3
 */
@Controller
public class SellerController extends BaseFormController {

    /**
     * Method which from seller
     * Redirects it to seller page with the list of advertisements.
     * @param request
     *            Contains object of the HTTP request.
     * @return "seller" Returning to the seller page.
     */
    @RequestMapping("/seller")
    public String getSellerAdvertisements(HttpServletRequest request) {
        List<Advertisement> sellerAdvertisements = new ArrayList<Advertisement>();
        User user = this.getUserManager().getUserByUsername(request.getRemoteUser());
        for (Advertisement advertisement : getAdvertisementManager().getAdvertisements()) {
            if (advertisement.getUser().getId() == user.getId()) {
                sellerAdvertisements.add(advertisement);
                System.out.println(advertisement.getUser().getId());
                System.out.println(user.getId());
            }
        }
        request.setAttribute("sellerAdvertisements", sellerAdvertisements);
        System.out.println(sellerAdvertisements.size());
        return "seller";
    }
}
