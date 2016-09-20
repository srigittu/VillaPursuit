// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved
package com.i2i.villapursuit.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.villapursuit.connection.HibernateConnection;
import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Address;
import com.i2i.villapursuit.model.User;

/**
 * <p>
 * Dao which performs operations on user database 
 * according to URL mapping
 * </p>
 * 
 * @author Team #3
 * 
 * @created 07/09/16
 */
public class UserDao {
    private SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    private Transaction transaction = null;
    
    /**
     * <p>
     * Method which fetches request from service.
     * Insert user details into database.
     * </p>
     * @param user
     *     Contains object of user model.
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
    public void insertUser(User user) throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(user);                                                                                    //Adding User
            transaction.commit();
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            throw new VillaPursuitException("\t\"Error occured while Adding User... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }
    
    /**
     * <p>
     * Method which fetches request from service.
     * Retrieve all user details from database.
     * </p>
     * @return users
     *     Return all list of user.
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
    @SuppressWarnings("unchecked")
	public List<User> retriveAllUsers() throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            List<User> users = session.createQuery("FROM User").list();                                 //Getting Users
            transaction.commit();
            return users;
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            throw new VillaPursuitException("\t\"Error occured while retriving Users... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }
    
    /**
     * <p>
     * Method which gets request from service.
     * Get user by user name from database.
     * </p>
     * @param userName
     *     Contains name of the user.
     * @return user
     *     Returns object of user model.
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
    public User retriveUser(String userName) throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
            for (User user : retriveAllUsers()) {
                if (user.getUserName().equals(userName)) {
            	    return user;
            	}
            } 
            return null;
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            throw new VillaPursuitException("\t\"Error occured while retriving User... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }
    
    /**
     * <p>
     * Method which gets request from service.
     * Delete user by user name from database.
     * </p>
     * @param userName
     *     Contains name of the user.
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
    public void deleteUser(String userName) throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            User user = (User)session.get(User.class, userName); 
            session.delete(user);                                                                                //Deleting User
            transaction.commit();
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            throw new VillaPursuitException("\t\"Error occured while removing User... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }
    
    /**
     * <p>
     * Method which gets request from service.
     * Update password to the user database.
     * </p>
     * @param userName
     *     Contains name of the user.
     * @param password
     *     Contains password of the user.
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations. 
     */
    public void updatePassword(String userName, String password) throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            User user = (User)session.get(User.class, userName);                             //Updating User Salary
            user.setPassword(password);
            transaction.commit();
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            throw new VillaPursuitException("\t\"Error occured while Updating User Salary... Please try again...\""+
                    exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }
    
    /**
     * <p>
     * Method which gets request from service.
     * Insert address to the address database.
     * Update address Id to the user database.
     * </p>
     * @param address
     *     Contains object of the address model.
     * @param userId
     *     Contains Id of the user.
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations. 
     */
    public void insertUserAddress(Address address, int userId) throws VillaPursuitException {
	Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(address);
            User user = (User)session.get(User.class, userId);
            user.setAddress(address);
            transaction.commit();
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            throw new VillaPursuitException("\t\"Error occured while Adding Address... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }
}
