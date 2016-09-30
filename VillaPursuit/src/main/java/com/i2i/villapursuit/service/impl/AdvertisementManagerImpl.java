package com.i2i.villapursuit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.villapursuit.dao.AdvertisementDao;
import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.User;
import com.i2i.villapursuit.service.AdvertisementManager;

/**
 * Implementation of AdvertisementManager interface.
 *
 * @author Team #3
 */
@Service("advertisementManager")
public class AdvertisementManagerImpl extends GenericManagerImpl<Advertisement, Long> implements AdvertisementManager{
    AdvertisementDao advertisementDao;

    /**
     * Constructor of current class.
     * 
     * @param advertisementDao
     *            Contains object of Advertisement Dao class.
     */
    @Autowired
    public AdvertisementManagerImpl(AdvertisementDao advertisementDao) {
        super(advertisementDao);
        this.advertisementDao = advertisementDao;
    }

    /**
     * Method which gets request to get all active advertisements.
     * 
     * @return all active advertisements from database.
     */
    public List<Advertisement> getActiveAdvertisements() {
        return advertisementDao.getActiveAdvertisements();
    }

    /**
     * Method which gets request to get all inactive advertisements.
     * 
     * @return all inactive advertisements from database.
     */
    public List<Advertisement> getInctiveAdvertisements() {
        return advertisementDao.getInactiveAdvertisements();
    }

    /**
     * Method which gets request to get all advertisements.
     * 
     * @return all advertisements from database.
     */
    public List<Advertisement> getAdvertisements() {
        return advertisementDao.getAdvertisements();
    }

    /**
     * Method which gets request to save an advertisement.
     * 
     * @param advertisement
     *            Contains object of the advertisement.
     * @return saved advertisement.
     */
    public Advertisement saveAdvertisement(Advertisement advertisement) {
        return advertisementDao.saveAdvertisement(advertisement);
    }

    /**
     * Method which gets request to get an advertisement by advertisement id.
     * 
     * @param advertisementId
     *            Contains id of the advertisement.
     * @return advertisement belongs to the advertisementId
     */
    public Advertisement getAdvertisementById(Long advertisementId) {
        return advertisementDao.getAdvertisementById(advertisementId);
    }

    /**
     * Method which gets request to remove an advertisement by advertisement id.
     * 
     * @param advertisementId
     *            Contains id of the advertisement.
     */
    public void removeAdvertisementById(long advertisementId) {
        advertisementDao.removeAdvertisementById(advertisementId);
    }
    
    /**
     * Method which gets request to set buyer who viewed an advertisement.
     * 
     * @param advertisementId
     *            Contains id of the advertisement.
     @param user
     *            Contains user info who viewed the advertisement.
     */
    public void setAdvertisementViewer(Long advertisementId, User user) {
        advertisementDao.setAdvertisementViewer(advertisementId, user);
    }
}
