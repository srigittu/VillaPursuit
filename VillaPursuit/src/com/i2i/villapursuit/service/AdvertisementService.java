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
	   
    public String addAdvertisement(Advertisement advertisement, Image images, Facility facilities, Address advertisementAddress, int userId) throws VillaPursuitException {
    	advertisementDao.insertAdvertisement(advertisement, images, facilities, advertisementAddress, userId);
        return "advertisement successfully posted";
    }
    
    public List<Advertisement> getAllAdvertisement() throws VillaPursuitException {
        return advertisementDao.retriveAllAdvertisements();
    } 
    
    /*public void removeAdvertisement(String userName) throws VillaPursuitException {
        userDao.deleteUser(userName);
    }
   
    public User getUser(String userName) throws VillaPursuitException {
        return userDao.retriveUser(userName);
    }
   
    public String addUserAddress(Address userAddress, int userId) throws VillaPursuitException {
	    userDao.insertUserAddress(userAddress, userId);
 	    return "Address successfully Added";
    }*/
}
