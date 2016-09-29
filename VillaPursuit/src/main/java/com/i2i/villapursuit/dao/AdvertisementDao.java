package com.i2i.villapursuit.dao;

import java.util.List;

import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Advertisement;

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
     * 
     * @throws VillaPursuitException
     *             If there is failed or interrupted when get all active
     *             advertisements or when connection fails.
     */
    List<Advertisement> getActiveAdvertisements() throws VillaPursuitException;

    /**
     * Gets a list of Advertisements based on "inactive" status.
     *
     * @return List populated list of advertisements
     * 
     * @throws VillaPursuitException
     *             If there is failed or interrupted when get all inactive
     *             advertisements or when connection fails.
     */
    List<Advertisement> getInactiveAdvertisements() throws VillaPursuitException;

    /**
     * Gets a list of Advertisements.
     *
     * @return List populated list of advertisements.
     * 
     * @throws VillaPursuitException
     *             If there is failed or interrupted when get all advertisements
     *             or when connection fails.
     */
    List<Advertisement> getAdvertisements() throws VillaPursuitException;

    /**
     * Saves a advertisement's information.
     * 
     * @param advertisement
     *            the object to be saved
     * @return the persisted advertisement object
     * 
     * @throws VillaPursuitException
     *             If there is failed or interrupted when get all inactive
     *             advertisements or when connection fails.
     */
    Advertisement saveAdvertisement(Advertisement advertisement) throws VillaPursuitException;

    /**
     * Gets a advertisement's information.
     * 
     * @param advertisementId
     *            the object to be saved
     * @return the persisted advertisement object
     * 
     * @throws VillaPursuitException
     *             If there is failed or interrupted when get an advertisement
     *             or when connection fails.
     */
    Advertisement getAdvertisementById(Long advertisementId) throws VillaPursuitException;

    /**
     * Removes a advertisement from the database by advertisementId
     * 
     * @param advertisementId
     *            the advertisement's id.
     * @throws VillaPursuitException
     *             If there is failed or interrupted when remove an
     *             advertisement or when connection fails.
     */
    void removeAdvertisementById(Long advertisementId) throws VillaPursuitException;
}
