package service;

import java.util.List;

import org.hibernate.HibernateException;

import dao.AdvertisementDao;
import model.Advertisement;

public class AdvertisementService {

	AdvertisementDao advertisementDao = new AdvertisementDao();
	
	public String addAdvertisement(Advertisement advertisement) throws HibernateException {
		advertisementDao.insertAdvertisement(advertisement);
        return "Advertisement added successfully";
    }
	
	public boolean updateAdvertisement(Advertisement advertisement) throws HibernateException {
		return advertisementDao.updateUserAdvertisement(advertisement);
	}
	
	public List<Advertisement> getAllAdvertisements() throws HibernateException {
        List<Advertisement> advertisements = advertisementDao.retrieveAllAdvertisements();
        if (advertisements.size() != 0) {
            return advertisements;
        }
        return null;
    } 
	
	public Advertisement getAdvertisementById(int advertisementId) throws HibernateException {               
        return advertisementDao.findAdvertisementById(advertisementId);
    }
}
