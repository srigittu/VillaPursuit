package com.i2i.villapursuit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.villapursuit.dao.AdvertisementDao;
import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.service.AdvertisementManager;

/**
 * Implementation of AdvertisementManager interface.
 *
 * @author Team #3
 */
@Service("advertisementManager")
public class AdvertisementManagerImpl extends GenericManagerImpl<Advertisement, Long> implements AdvertisementManager {
    AdvertisementDao advertisementDao;

    /**
     * Constructor of current class.
     * 
     * @param advertisementDao
     *            Contains object of Advertisement Dao class.
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operation or
     *             hibernate connections.
     */
    @Autowired
    public AdvertisementManagerImpl(AdvertisementDao advertisementDao) throws VillaPursuitException {
        super(advertisementDao);
        this.advertisementDao = advertisementDao;
    }

    /**
     * Method which gets request to get all active advertisements.
     * 
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operation or
     *             hibernate connections.
     */
    public List<Advertisement> getActiveAdvertisements() throws VillaPursuitException {
        return advertisementDao.getActiveAdvertisements();
    }

    /**
     * Method which gets request to get all inactive advertisements.
     * 
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operation or
     *             hibernate connections.
     */
    public List<Advertisement> getInctiveAdvertisements() throws VillaPursuitException {
        return advertisementDao.getInactiveAdvertisements();
    }

    /**
     * Method which gets request to get all advertisements.
     * 
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operation or
     *             hibernate connections.
     */
    public List<Advertisement> getAdvertisements() throws VillaPursuitException {
        return advertisementDao.getAdvertisements();
    }

    /**
     * Method which gets request to save an advertisement.
     * 
     * @param advertisement
     *            Contains object of the advertisement.
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operation or
     *             hibernate connections.
     */
    public Advertisement saveAdvertisement(Advertisement advertisement) throws VillaPursuitException {
        return advertisementDao.saveAdvertisement(advertisement);
    }

    /**
     * Method which gets request to get an advertisement by advertisement id.
     * 
     * @param advertisementId
     *            Contains id of the advertisement.
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operation or
     *             hibernate connections.
     */
    public Advertisement getAdvertisementById(Long advertisementId) throws VillaPursuitException {
        return advertisementDao.getAdvertisementById(advertisementId);
    }

    /**
     * Method which gets request to remove an advertisement by advertisement id.
     * 
     * @param advertisementId
     *            Contains id of the advertisement.
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operation or
     *             hibernate connections.
     */
    public void removeAdvertisementById(long advertisementId) throws VillaPursuitException {
        advertisementDao.removeAdvertisementById(advertisementId);
    }

}
