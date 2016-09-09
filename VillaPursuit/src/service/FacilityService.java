package service;

import org.hibernate.HibernateException;

import dao.FacilityDao;
import model.Facility;
import dao.AdvertisementDao;

public class FacilityService {

	FacilityDao facilityDao = new FacilityDao();
	public String addFacility(Facility facility) throws HibernateException {
		facilityDao.insertFacility(facility);
        return "Address added successfully";
    }
	
	public boolean updateFacility(Facility facility) throws HibernateException {
		return facilityDao.updateAdFacility(facility);
	}
}
