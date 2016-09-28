package com.i2i.villapursuit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.villapursuit.dao.AdvertisementDao;
import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.service.AdvertisementManager;

/**
 * Implementation of AdvertisementManager interface.
 *
 * @author Team #3
 */
@Service("advertisementManager")
public class AdvertisementManagerImpl extends GenericManagerImpl<Advertisement, Long> implements AdvertisementManager{
	AdvertisementDao advertisementDao;

    @Autowired
    public AdvertisementManagerImpl(AdvertisementDao advertisementDao) {
        super(advertisementDao);
        this.advertisementDao = advertisementDao;
    }
	
    /**
     * {@inheritDoc}
     */
	public List<Advertisement> getActiveAdvertisements() {
		return advertisementDao.getActiveAdvertisements();
	}
    
	/**
     * {@inheritDoc}
     */
	public List<Advertisement> getInctiveAdvertisements() {
		return advertisementDao.getInactiveAdvertisements();
	}
    
	/**
     * {@inheritDoc}
     */
	public List<Advertisement> getAdvertisements() {
		return advertisementDao.getAdvertisements();
	}
    
	/**
     * {@inheritDoc}
     */
	public Advertisement saveAdvertisement(Advertisement advertisement) {
		return advertisementDao.saveAdvertisement(advertisement);
	}
    
	/**
     * {@inheritDoc}
     */
	public Advertisement getAdvertisementById(Long advertisementId) {
		return advertisementDao.getAdvertisementById(advertisementId);
	}
	
	/**
     * {@inheritDoc}
     */
	public void removeAdvertisementById(long advertisementId) {
		advertisementDao.removeAdvertisementById(advertisementId);
	}
	
}
