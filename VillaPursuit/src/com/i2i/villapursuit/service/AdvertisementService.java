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
 * Service which gets request from controller. Permits to perform advertisement
 * insertion and advertisement retrieval operations. According to URL mapping
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
     * Method which gets request from controller. Perform validations to insert
     * advertisement details into database.
     * </p>
     * 
     * @param advertisement
     *            Object contains advertisement details to be inserted into
     *            database.
     * @param images
     *            Object contains image details to be inserted into database.
     * @param facility
     *            Object contains facility details to be inserted into database.
     * @param advertisementAddress
     *            Object contains address details to be inserted into database.
     * @param userId
     *            Contains user Id of a seller.
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operations.
     */
    public void addAdvertisement(Advertisement advertisement, List<Image> images, Facility facility, Address address,
            int userId) throws VillaPursuitException {
        advertisementDao.insertAdvertisement(advertisement, images, facility, address, userId);
    }

    /**
     * <p>
     * Method which gets request from controller. Perform validations to
     * retrieve all advertisement detail from database.
     * </p>
     * 
     * @return list 
     *             Contains list of advertisements
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operations.
     */
    public List<Advertisement> getAllAdvertisements() throws VillaPursuitException {
        return advertisementDao.retriveAllAdvertisements();
    }

    /**
     * <p>
     * Method which gets request from controller. Perform validations to
     * retrieve advertisement detail from database.
     * </p>
     * 
     * @param advertisementId
     *            Contains advertisementId of the particular advertisement
     * @return advertisement
     *             Contains the detail of particular advertisement.
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operations.
     */
    public Advertisement retriveAdvertisementById(int advertisementId) throws VillaPursuitException {
        return advertisementDao.retriveAdvertisementById(advertisementId);
    }

    /**
     * <p>
     * Method which gets request from controller. Perform association of buyer
     * viewed the particular advertisement detail from database.
     * </p>
     * 
     * @param userId
     *            Contains user Id of a buyer.
     * @param advertisementId
     *            Contains Id of the advertisement.-
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operations.
     * 
     */
    public void setAdvertisementViewer(int userId, int advertisementId) throws VillaPursuitException {
        advertisementDao.setAdvertisementViewer(userId, advertisementId);
    }

    /**
     * <p>
     * Method which gets request from controller. Perform validations to
     * retrieve advertisement details which has inactive status from database.
     * </p>
     * 
     * @return list Returns the list of inactive advertisement.
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operations.
     */
    public List<Advertisement> getAllInactiveAdvertisements() throws VillaPursuitException {
        return advertisementDao.retriveAllInactiveAdvertisements();
    }

    /**
     * <p>
     * Method which gets request from controller. Perform validations to
     * retrieve advertisement details which has inactive status from database.
     * </p>
     * 
     * @return list 
     *             Returns the list of active advertisement
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operations.
     */
    public List<Advertisement> getAllActiveAdvertisements() throws VillaPursuitException {
        return advertisementDao.retriveAllActiveAdvertisements();
    }

    /**
     * <p>
     * Method which gets request from controller. Perform validations to update
     * status of an advertisement.
     * </p>
     * 
     * @param advertisementId
     *            Contains Id of the advertisement.
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operations.
     */
    public void updateStatus(int advertisementId) throws VillaPursuitException {
        advertisementDao.updateAdStatus(advertisementId);
    }
    
    /**
     *  <p>
     * Method which gets request from advertisement service. Performs search operations
     * based on the parameters to get the advertisements .
     * </p>
     * 
     * @param houseType
     *            Contains houseType value to search the match advertisements.
     * @param rentType
     *            Contains rentType value to search the match advertisements.
     * @param price
     *            Contains price value to search the advertisements.
     * @return list
     *             Returns the list of search parameter matched  advertisements.
     * @throws VillaPursuitException
     *             If there is failed or interrupted database and hibernate operations.
     */
	public List<Advertisement> filterSearchAdvertisements(String houseType, String rentType, String price) throws VillaPursuitException {
        return advertisementDao.filterSearchAdvertisements(houseType, rentType, price);
	}
}
