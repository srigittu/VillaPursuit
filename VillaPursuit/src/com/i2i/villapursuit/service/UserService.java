/**
 * @author Team #3
 *
 * @created 07/09/16 
 */
package com.i2i.villapursuit.service;

import java.util.List;

import com.i2i.villapursuit.dao.UserDao;
import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Address;
import com.i2i.villapursuit.model.User;

public class UserService {
    private UserDao userDao = new UserDao();
   
    public String addUser(User user) throws VillaPursuitException {
        userDao.insertUser(user);
        return "registration successfull";
    }
   
    public void removeUser(String userName) throws VillaPursuitException {
        userDao.deleteUser(userName);
    }
   
    public User getUser(String userName) throws VillaPursuitException {
        return userDao.retriveUser(userName);
    }
   
    public List<User> getAllUsers() throws VillaPursuitException {
        return userDao.retriveAllUsers();
    }
   
    public String addUserAddress(Address userAddress, int userId) throws VillaPursuitException {
	    userDao.insertUserAddress(userAddress, userId);
 	    return "Address successfully Added";
    }

}
