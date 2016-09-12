// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved

package com.i2i.villapursuit.service;

import java.util.List;

import com.i2i.villapursuit.dao.AdvertisementDao;
import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Address;
import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.Facility;
import com.i2i.villapursuit.model.Image;

/**
 * <p>
 * Service which gets request from controller.
 * Permits to perform advertisement insertion and advertisement retrieval operations.
 * According to URL mapping
 * </p>
 * 
 * @author Team #3
 *
 * @created 07/09/16 
 * 
 */

public class AdvertisementService {
	private AdvertisementDao advertisementDao = new AdvertisementDao();

/**
	 * <p>
	 * Method which gets request from controller.
     * Perform validations to insert advertisement details into database.
	 * </p>
	 * @param advertisement
	 *     Object contains advertisement details to be inserted into database.
	 * @param images
	 *     Object contains image details to be inserted into database.
	 * @param facility
	 *     Object contains facility details to be inserted into database.
	 * @param advertisementAddress
	 *     Object contains address details to be inserted into database.
	 * @param userId
	 *     Contains user Id of a seller.
	 * @return string
	 *     Contains status message.
	 * @throws VillaPursuitException
	 *     If there is failed or interrupted database operations.
	 */
   
    public String addAdvertisement(Advertisement advertisement, List<Image> images, Facility facility, Address address, int userId) throws VillaPursuitException {
    	advertisementDao.insertAdvertisement(advertisement, images, facility, address, userId);
        return "advertisement successfully posted";
    }

/**
     * <p>
     * Method which gets request from controller.
     * Perform validations to retrieve advertisement details from database.
     * </p>
     * @return list
     *     Contains list of advertisements
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
    
    public List<Advertisement> getAllAdvertisement() throws VillaPursuitException {
        return advertisementDao.retriveAllAdvertisements();
    } 
    
    /*public void removeAdvertisement(String userName) throws VillaPursuitException {
        userDao.deleteUser(userName);
    }
   
    public User getUser(String userName) throws VillaPursuitException {
        return userDao.retriveUser(userName);
    }
   
    public String addUserAddress(Address userAddress, int userId) throws VillaPursuitException {
	    userDao.insertUserAddress(userAddress, userId);
 	    return "Address successfully Added";
    }*/
}
