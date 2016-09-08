package service;

import org.hibernate.HibernateException;

import dao.AddressDao;
import model.Address;

public class AddressService {

	AddressDao addressDao = new AddressDao();
	public String addAddress(Address address) throws HibernateException {
        addressDao.insertAddress(address);
        return "Address added successfully";
    }
}
