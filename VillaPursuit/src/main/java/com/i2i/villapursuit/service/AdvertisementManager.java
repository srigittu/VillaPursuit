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
    List getActiveAdvertisements();

    /**
     * {@inheritDoc}
     */
    List getInctiveAdvertisements();

    /**
     * {@inheritDoc}
     */
    List getAdvertisements();
    
    /**
     * {@inheritDoc}
     */
    Advertisement saveAdvertisement(Advertisement advertisement);
    
    /**
     * {@inheritDoc}
     */
    void removeAdvertisementById(long advertisementId);
}
