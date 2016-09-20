// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved
package com.i2i.villapursuit.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.villapursuit.connection.HibernateConnection;
import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Address;
import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.Facility;
import com.i2i.villapursuit.model.Image;
import com.i2i.villapursuit.model.User;

/**
 * <p>
 * Dao which performs operations on advertisement database according to URL
 * mapping
 * </p>
 * @author Team #3
 * 
 * @created 07/09/16
 */
public class AdvertisementDao {
    private SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    private Transaction transaction = null;
    
    /**
     * <p>
     * Method which fetches request from service.
     * Insert user details into database.
     * </p>
     * @param advertisement
     *     Contains object of the advertisement model.
     * @param image
     *     Contains object of the image model.
     * @param facility
     *     Contains object of the facility model.
     * @param advertisementAddress
     *     Contains object of the address model.
     * @param userId
     *     Contains user Id who posts the advertisement.
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
    public void insertAdvertisement(Advertisement advertisement, List<Image> images, Facility facility, Address advertisementAddress, 
            int userId) throws VillaPursuitException {
    	Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(advertisement);
            for (Image image : images) {
            	session.save(image);
            	image.setAdvertisement(advertisement);
            }
            session.save(facility);
            session.save(advertisementAddress);
            advertisement.setImages(images);
            advertisement.setFacility(facility);
            advertisement.setAddress(advertisementAddress);
            User user = (User)session.get(User.class, userId);
            advertisement.setUser(user);
            transaction.commit();
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            throw new VillaPursuitException("\t\"Error occured while Adding Advertisement... Please try again...\""+
                     exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }
    
    /**
     * <p>
     * Method which fetches request from service.
     * Retrieves all advertisement details from database.
     * </p>
     * @return list
     *     Returns the list of advertisements.
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
    @SuppressWarnings("unchecked")
    public List<Advertisement> retriveAllAdvertisements() throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Advertisement").list();        
        } catch (HibernateException exceptionCause) {
            throw new VillaPursuitException("\t\"Error occured while retriving Advertisements... Please try again...\""+
                    exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }
    
    /**
     * <p>
     * Method which fetches request from service.
     * Retrieve advertisement details from database.
     * </p>
     * @param advertisementId
     *    Contains the id value for the particular advertisement
     * @return
     *    Returns the particular advertisement.
     * @throws VillaPursuitException
     */
    public Advertisement retriveAdvertisementById(int advertisementId) throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
            return (Advertisement)session.get(Advertisement.class, advertisementId);
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
     * Method which fetches request from service.
     * Assigns viewed particular user to that particular advertisement details from database.
     * </p>
     * @param userId
     *    Contains user Id who posts the advertisement.
     * @param advertisementId
     *    Contains the id value for the particular advertisement
     * @throws VillaPursuitException
     */
    public void setAdvertisementViewer(int userId, int advertisementId) throws VillaPursuitException {
        Set<User> viewers = new HashSet<User>();
	Session session = sessionFactory.openSession();
	try {
	    transaction = session.beginTransaction();
	    User viewer = (User)session.get(User.class, userId);
	    viewers.add(viewer);
	    Advertisement advertisement = (Advertisement)session.get(Advertisement.class, advertisementId);
	    advertisement.setAdvertisementViewer(viewers);
	    session.update(advertisement);
	    transaction.commit();
	} catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            throw new VillaPursuitException("\t\"Error occured while setting Advertisement viewer... Please try again...\""+
                    exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }
}
