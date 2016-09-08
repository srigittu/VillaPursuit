package service;

import org.hibernate.HibernateException;

import dao.FacilityDao;
import model.Facility;

public class FacilityService {

	FacilityDao facilityDao = new FacilityDao();
	public String addFacility(Facility facility) throws HibernateException {
		facilityDao.insertFacility(facility);
        return "Address added successfully";
    }
}
