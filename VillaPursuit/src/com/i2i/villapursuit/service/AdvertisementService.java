/**
 * @author Team #3
 *
 * @created 09/09/16 
 */
package com.i2i.villapursuit.service;

import java.util.List;

import com.i2i.villapursuit.dao.AdvertisementDao;
import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Address;
import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.Facility;
import com.i2i.villapursuit.model.Image;

public class AdvertisementService {
	private AdvertisementDao advertisementDao = new AdvertisementDao();
	   
    public String addAdvertisement(Advertisement advertisement, List<Image> images, Facility facility, Address address, int userId) throws VillaPursuitException {
    	advertisementDao.insertAdvertisement(advertisement, images, facility, address, userId);
        return "advertisement successfully posted";
    }
    
    public List<Advertisement> getAllAdvertisements() throws VillaPursuitException {
        return advertisementDao.retriveAllAdvertisements();
    } 
    
    public Advertisement retriveAdvertisementById(int advertisementId) throws VillaPursuitException {
    	return advertisementDao.retriveAdvertisementById(advertisementId);
    }
    
    public void setAdvertisementViewer(int userId, int advertisementId) throws VillaPursuitException {
        advertisementDao.setAdvertisementViewer(userId, advertisementId);
    }
}
