package com.i2i.villapursuit.service;

import java.util.List;

import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.User;

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
    void removeAdvertisementById(Long advertisementId);
    
    /**
     * {@inheritDoc}
     */
    Advertisement getAdvertisementById(Long advertisementId);
       
    /**
     * {@inheritDoc}
     */
    void setAdvertisementViewer(Long advertisementId, User user);
}
