package com.i2i.villapursuit.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.User;

/**
 * Controller to display seller's advertisement.
 *
 * @author Team #3
 */
@Controller
public class SellerController extends BaseFormController {

    /**
     * Method which sends seller posted advertisements.
     * 
     * @param request
     *            which sends current seller posted advertisement as sellerAdvertisements
     * @return to seller page.
     */
    @RequestMapping("/seller")
    public String getSellerAdvertisements(HttpServletRequest request) {
        List<Advertisement> sellerAdvertisements = new ArrayList<Advertisement>();
        User user = this.getUserManager().getUserByUsername(request.getRemoteUser());
        for (Advertisement advertisement : getAdvertisementManager().getAdvertisements()) {
            if (advertisement.getUser().getId() == user.getId()) {
                sellerAdvertisements.add(advertisement);
            }
        }
        request.setAttribute("sellerAdvertisements", sellerAdvertisements);
        return "seller";
    }
}
