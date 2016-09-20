//Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved
package com.i2i.villapursuit.service;

import java.util.List;

import com.i2i.villapursuit.dao.UserDao;
import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Address;
import com.i2i.villapursuit.model.User;

/**
 * <p>
 * Service which gets request from controller.
 * Permits to perform user registration and address insertion operations. 
 * According to URL mapping
 * </p>
 * 
 * @author Team #3
 *
 * @created 07/09/16 
 */
public class UserService {
    private UserDao userDao = new UserDao();
    
    /**
     * <p>
     * Method which gets request from controller.
     * Perform validations to insert user details into database.
     * </p>
     * @param user
     *     Object contains user details to be inserted into database.
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
    public void addUser(User user) throws VillaPursuitException {
        userDao.insertUser(user);
    }
    
    /**
     * <p>
     * Method which gets request from controller.
     * Perform validations to remove user details from database.
     * </p>
     * @param userName
     *     contains name of the user.
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
    public void removeUser(String userName) throws VillaPursuitException {
        userDao.deleteUser(userName);
    }
    
    /**
     * <p>
     * Method which gets request from controller.
     * Perform validations to get user details from database.
     * </p>
     * @param userName
     *     Contains name of the user.
     * @return user
     *     Returns user object. 
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
    public User getUser(String userName) throws VillaPursuitException {
        return userDao.retriveUser(userName);
    }
    
    /**
     * <p>
     * Method which gets request from controller.
     * Perform validations to get list of user details from database.
     * </p>
     * @return List<User>
     *     Returns user list From database.
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
    public List<User> getAllUsers() throws VillaPursuitException {
        return userDao.retriveAllUsers();
    }
    
    /**
     * <p>
     * Method which gets request from controller.
     * Perform validations to insert address details into database.
     * </p>
     * @param userAddress
     *     Object contains user address details to be inserted into database.
     * @param userId
     *     Contains Id of the user.
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
    public void addUserAddress(Address userAddress, int userId) throws VillaPursuitException {
	    userDao.insertUserAddress(userAddress, userId);
    }
}
