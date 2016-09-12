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

    public void insertAdvertisement(Advertisement advertisement, Image image, Facility facility, Address advertisementAddress, int userId) throws VillaPursuitException {
    	Set<Facility> facilities = new HashSet<Facility>();
    	Set<Image> images = new HashSet<Image>();
    	Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(advertisement);
            session.save(image);
            session.save(facility);
            session.save(advertisementAddress);
            images.add(image);
            advertisement.setImages(images);
            facilities.add(facility);
            advertisement.setFacilities(facilities);
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

    /*public Advertisement retriveAdvertisement(String advertisementName) throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            for (Advertisement advertisement : retriveAllAdvertisements()) {
            	if (advertisement.getAdvertisementName().equals(advertisementName)) {
            		return advertisement;
            	}
            }
            transaction.commit();
            return null;
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            throw new VillaPursuitException("\t\"Error occured while retriving Advertisement... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }

    public void deleteAdvertisement(String advertisementName) throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Advertisement advertisement = (Advertisement)session.get(Advertisement.class, advertisementName); 
            session.delete(advertisement);                                                                                //Deleting Advertisement
            transaction.commit();
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            throw new VillaPursuitException("\t\"Error occured while removing Advertisement... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }
    
    public void updatePassword(String advertisementName, String password) throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Advertisement advertisement = (Advertisement)session.get(Advertisement.class, advertisementName);                             //Updating Advertisement Salary
            advertisement.setPassword(password);
            transaction.commit();
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            throw new VillaPursuitException("\t\"Error occured while Updating Advertisement Salary... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }
    
    public void insertAdvertisementAddress(Address address, int advertisementId) throws VillaPursuitException {
		Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(address);
            Advertisement advertisement = (Advertisement)session.get(Advertisement.class, advertisementId);
            advertisement.setAddress(address);
            transaction.commit();
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            System.out.println(advertisementId);
            throw new VillaPursuitException("\t\"Error occured while Adding Address... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
	}
    
    /*public void assignProjectToAdvertisement(String advertisementName, String projectId) throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Advertisement advertisement = (Advertisement)session.get(Advertisement.class, advertisementName);
            Project project = (Project)session.get(Project.class, projectId); 
            advertisement.setProject(project);                                                                  //Assigning Project to Advertisement
            transaction.commit();
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            throw new VillaPursuitException("\t\"Error occured while assigning Project to Advertisement... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }
    
    public void removeProjectFromAdvertisement(String advertisementName) throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Advertisement advertisement = (Advertisement)session.get(Advertisement.class, advertisementName);
            advertisement.setProject(null);                                                                  //Removing Advertisement From project
            transaction.commit();
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            LogFile.error("Error occurred in Advertisement DataBase:removeProjectFromAdvertisement()"+exceptionCause.toString());
            throw new VillaPursuitException("\t\"Error occured while removing Project from Advertisement... Please try again...\"");
        } finally {
            session.close(); 
        }
    }*/

}
