package com.i2i.villapursuit.service;

import java.util.List;

import com.i2i.villapursuit.exception.VillaPursuitException;
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
    List<Advertisement> getActiveAdvertisements() throws VillaPursuitException;

    /**
     * {@inheritDoc}
     */
    List<Advertisement> getInctiveAdvertisements() throws VillaPursuitException;

    /**
     * {@inheritDoc}
     */
    List<Advertisement> getAdvertisements() throws VillaPursuitException;

    /**
     * {@inheritDoc}
     */
    Advertisement saveAdvertisement(Advertisement advertisement) throws VillaPursuitException;

    /**
     * {@inheritDoc}
     */
    Advertisement getAdvertisementById(Long advertisementId) throws VillaPursuitException;

    /**
     * {@inheritDoc}
     */
    void removeAdvertisementById(long advertisementId) throws VillaPursuitException;
}
