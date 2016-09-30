package com.i2i.villapursuit.webapp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.User;

/**
 * Controller to post advertisement from seller.
 *
 * @author Team #3
 */
@Controller
public class AdvertisementController extends BaseFormController {

    /**
<<<<<<< HEAD
     * Method which send advertisement form to seller
     * 
     * @param model
     *            Which sends advertisement details as advertisementForm
     * @return to advertisement page.
     */
    @RequestMapping(value = "/advertisementForm", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        Advertisement advertisement = new Advertisement();
        model.addAttribute("advertisementForm", advertisement);
        return "advertisement";
    }

    /**
     * <p>
     * Method which gets advertisement details from seller saves image to
     * resource folder/username.
     * </p>
     * 
     * @param advertisement
     *            Consist of details where seller entered
     * @param errors
     *            Binds if any null values are provided in entered details.
     * @param request
     *            Which sends saved advertisement.
     * @return to the seller page if advertisement saved successfully.
     */
    @RequestMapping(value = "/addAdvertisement", method = RequestMethod.POST)
    public String onSubmit(Advertisement advertisement, BindingResult errors, HttpServletRequest request) {
        if (request.getParameter("cancel") != null) {
            return "redirect:seller";
        }

    /**
     * Method which gets request to add an advertisement's details. If
     * advertisement added successfully, redirects it to seller page.
     * 
     * @param advertisement
     *            Contains object of the advertisement.
     * @param errors
     *            Contains error message which redirects to jsp page.
     * @param request
     *            Contains object of HTTP Request.
     * @return "advertisement" Returning to advertisement page.
     */
    @RequestMapping(value = "/addAdvertisement", method = RequestMethod.POST)
    public String onSubmit(Advertisement advertisement, BindingResult errors, HttpServletRequest request,
            ModelMap model) {
        try {
            if (request.getParameter("cancel") != null) {
                return "redirect:seller";
            }

            if (validator != null) { // validator is null during testing
                validator.validate(advertisement, errors);

                if (errors.hasErrors()) {
                    return "advertisement";
                }
            }
            // Assigning user to Advertisement
            User user = this.getUserManager().getUserByUsername(request.getRemoteUser());
            advertisement.setUser(user);

            // saving advertisement to database
            request.setAttribute("advertisement", this.getAdvertisementManager().saveAdvertisement(advertisement));
            return getSuccessView();
        } catch (VillaPursuitException e) {
            model.addAttribute("advertisementAddException", e.toString());
            return "advertisement";
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("file");

        // the directory to upload to
        String uploadDir = getServletContext().getRealPath("/resources");

        // The following seems to happen when running jetty:run
        if (uploadDir == null) {
            uploadDir = new File("src/main/webapp/resources").getAbsolutePath();
        }
        uploadDir += "/" + request.getRemoteUser() + "/";

        // Create the directory if it doesn't exist
        File dirPath = new File(uploadDir);

        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }

        try {
            // retrieve the file data
            InputStream stream = file.getInputStream();

            // write the file to the file specified
            OutputStream bos = new FileOutputStream(uploadDir + file.getOriginalFilename());
            int bytesRead;
            byte[] buffer = new byte[8192];

            while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            bos.close();

            // close the stream
            stream.close();
        } catch (IOException e) {
            request.setAttribute("advertisementException", "Error in Image Upload");
            return "advertisement";
        }

        // Assigning user to Advertisement
        User user = this.getUserManager().getUserByUsername(request.getRemoteUser());
        advertisement.setUser(user);
        advertisement.setImage(file.getOriginalFilename());
        // saving advertisement to database
        request.setAttribute("advertisement", this.getAdvertisementManager().saveAdvertisement(advertisement));
        return "redirect:seller";
    }

    /**
     * <p>
     * Method which sends buyer viewed advertisement with more information and
     * saves the buyer's info to seller(who viewed the post as notification)
     * </p>
     * 
     * @param request
     *            Which sends reviewed advertisement as viewAdvertisement
     * @return to home page.
     */
    @RequestMapping(value = "/viewAdvertisement", method = RequestMethod.GET)
    public String viewAdvertisement(HttpServletRequest request) {
        Long advertisementId = Long.valueOf((String) request.getParameter("advertisementId"));
        this.getAdvertisementManager().setAdvertisementViewer(advertisementId,
                this.getUserManager().getUserByUsername(request.getRemoteUser()));
        request.setAttribute("viewAdvertisement", this.getAdvertisementManager().getAdvertisementById(advertisementId));
        System.out.println("hello");
        return "home";
    }
}
