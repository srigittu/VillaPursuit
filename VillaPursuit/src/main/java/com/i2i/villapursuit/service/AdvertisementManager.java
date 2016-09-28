package com.i2i.villapursuit.service;

import java.util.List;

import com.i2i.villapursuit.model.Advertisement;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * @author Team #3
 */
public interface AdvertisementManager extends GenericManager<Advertisement, Long> {
	/**
     * {@inheritDoc}
     */
    List<Advertisement> getActiveAdvertisements();

    /**
     * {@inheritDoc}
     */
    List<Advertisement> getInctiveAdvertisements();

    /**
     * {@inheritDoc}
     */
    List<Advertisement> getAdvertisements();
    
    /**
     * {@inheritDoc}
     */
    Advertisement saveAdvertisement(Advertisement advertisement);
    
    /**
     * {@inheritDoc}
     */
    Advertisement getAdvertisementById(Long advertisementId);
    
    
    /**
     * {@inheritDoc}
     */
    void removeAdvertisementById(long advertisementId);
}
