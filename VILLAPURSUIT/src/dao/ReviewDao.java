package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import configuration.HibernateConfiguration;
import model.Advertisement;
import model.Review;

public class ReviewDao {
	
	private HibernateConfiguration hibernateConfigure = HibernateConfiguration.getConnect();
    private SessionFactory sessionFactory = hibernateConfigure.createSessionFactory(); 

	public boolean insertReview(Review review) throws HibernateException { 
        Session session = sessionFactory.openSession();
        try {  
            Transaction transaction = session.beginTransaction();
            session.save(review);
            transaction.commit();
            return true;
        } catch(HibernateException e) { 
              throw new HibernateException("Insertion Failed:" +e.getMessage());
        } finally {
            session.close();
        }
    } 
	
	public boolean updateUserReview(Review review) throws HibernateException {
        Session session = sessionFactory.openSession();
        try {
        	Transaction transaction = session.beginTransaction();
        	session.update(review);
        	transaction.commit();
        	return true;
        } catch(HibernateException e) {
            throw new HibernateException("cannot assign");
        } finally {
            session.close();
        }   
    }
	
	public List<Review> retrieveAllReviews() throws HibernateException {
        Session session = sessionFactory.openSession();
        try {
        	Transaction transaction = session.beginTransaction();
            List<Review> advertisements = session.createQuery("From Review").list();
            transaction.commit();
            return advertisements;
        } catch(HibernateException e) {
           throw new HibernateException("Cannot retrieve all Reviews");
        } finally {
            session.close();
        }    
    }  
}
