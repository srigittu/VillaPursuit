/**
 * @author Team #3
 *
 * @created 08/09/16 
 */
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

public class AdvertisementDao {
	private SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    private Transaction transaction = null;

    public void insertAdvertisement(Advertisement advertisement, List<Image> images, Facility facility, Address advertisementAddress, int userId) throws VillaPursuitException {
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
            throw new VillaPursuitException("\t\"Error occured while Adding Advertisement... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }

    @SuppressWarnings("unchecked")
	public List<Advertisement> retriveAllAdvertisements() throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
        	return session.createQuery("FROM Advertisement").list();        
        } catch (HibernateException exceptionCause) {
            throw new VillaPursuitException("\t\"Error occured while retriving Advertisements... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }

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
            throw new VillaPursuitException("\t\"Error occured while setting Advertisement viewer... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
	}

}