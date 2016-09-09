package service;

import org.hibernate.HibernateException;

import model.User;
import model.Address;
import dao.UserDao;

public class UserService {
	
	UserDao userDao = new UserDao();
	
	public String addUser(User user) throws HibernateException {
        userDao.insertUser(user);
        return "User added successfully";
    }
	
	public User getUserById(int userId) throws HibernateException {               
        return userDao.findUserById(userId);
    }
	
	public boolean allocateAddressToUser(int userId, int addressId) throws HibernateException {
		return userDao.allocateAddress(userId,addressId);
	}
	
	public boolean updateAddress(User user) throws HibernateException {
		return userDao.updateUserAddress(user);
	}
}
