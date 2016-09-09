package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import configuration.HibernateConfiguration;
import model.Advertisement;

public class AdvertisementDao {
	
	private HibernateConfiguration hibernateConfigure = HibernateConfiguration.getConnect();
    private SessionFactory sessionFactory = hibernateConfigure.createSessionFactory(); 

	public boolean insertAdvertisement(Advertisement advertisement) throws HibernateException { 
        Session session = sessionFactory.openSession();
        try {  
            Transaction transaction = session.beginTransaction();
            session.save(advertisement);
            transaction.commit();
            return true;
        } catch(HibernateException e) { 
              throw new HibernateException("Insertion Failed:" +e.getMessage());
        } finally {
            session.close();
        }
    } 
	
	public boolean updateUserAdvertisement(Advertisement advertisement) throws HibernateException {
        Session session = sessionFactory.openSession();
        try {
        	Transaction transaction = session.beginTransaction();
        	session.update(advertisement);
        	transaction.commit();
        	return true;
        } catch(HibernateException e) {
            throw new HibernateException("cannot assign");
        } finally {
            session.close();
        }   
    }
	
	public Advertisement findAdvertisementById(int advertisementId) throws HibernateException {
        Session session = sessionFactory.openSession();
        try { 
        	Transaction transaction = session.beginTransaction();
        	Advertisement advertisement = (Advertisement)session.get(Advertisement.class, advertisementId);
            transaction.commit();
            return advertisement;
        } catch(HibernateException e) {
        	 e.printStackTrace();
            throw new HibernateException("Cannot Find" +advertisementId);
        } finally {
            session.close();
        }                                                                                          
    }
	
	public List<Advertisement> retrieveAllAdvertisements() throws HibernateException {
        Session session = sessionFactory.openSession();
        try {
        	Transaction transaction = session.beginTransaction();
            List<Advertisement> advertisements = session.createQuery("From Advertisement").list();
            transaction.commit();
            return advertisements;
        } catch(HibernateException e) {
           throw new HibernateException("Cannot retrieve all Advertisements");
        } finally {
            session.close();
        }    
    }  
}
