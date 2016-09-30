package com.i2i.villapursuit.dao;

import java.util.List;

import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.User;

/**
 * Advertisement Data Access Object (GenericDao) interface.
 *
 * @author Team #3
 */
public interface AdvertisementDao extends GenericDao<Advertisement, Long> {

    /**
     * Gets a list of Advertisements based on "active" status.
     *
     * @return List populated list of advertisements
     */
    List<Advertisement> getActiveAdvertisements();
    
    /**
     * Gets a list of Advertisements based on "inactive" status.
     *
     * @return List populated list of advertisements
     */
    List<Advertisement> getInactiveAdvertisements();
    
    /**
     * Gets a list of Advertisements.
     *
     * @return List populated list of advertisements
     */
    List<Advertisement> getAdvertisements();
    
    /**
     * Saves a advertisement's information.
     * 
     * @param advertisement the object to be saved
     * @return the persisted advertisement object
     */
    Advertisement saveAdvertisement(Advertisement advertisement);
    
    /**
     * Removes a advertisement from the database by advertisementId
     * 
     * @param advertisementId the advertisement's id
     */
    void removeAdvertisementById(Long advertisementId);

    /**
     * Retrieves the particular Advertisement associated with the advertisementId
     * 
     * @param advertisementId the advertisement's id
     * @return the particular advertisement.
     */
    Advertisement getAdvertisementById(Long advertisementId);
    
    /**
     * Keeps the record of viewers for that particular Advertisement
     * 
     * @param advertisementId the advertisement's id
     * @param userId the user's id
     */
    void setAdvertisementViewer(Long advertisementId, User user);
    
}
