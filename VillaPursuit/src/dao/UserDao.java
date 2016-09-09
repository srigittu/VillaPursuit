package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import configuration.HibernateConfiguration;
import model.Address;
import model.User;

public class UserDao {
	private HibernateConfiguration hibernateConfigure = HibernateConfiguration.getConnect();
    private SessionFactory sessionFactory = hibernateConfigure.createSessionFactory();  

    public boolean insertUser(User user) throws HibernateException { 
        Session session = sessionFactory.openSession();
        try {  
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            return true;
        } catch(HibernateException e) { 
              throw new HibernateException("Insertion Failed:" +e.getMessage());
        } finally {
            session.close();
        }
    } 
    
    public User findUserById(int userId) throws HibernateException {
        Session session = sessionFactory.openSession();
        try { 
        	Transaction transaction = session.beginTransaction();
            User user = (User)session.get(User.class, userId);
            transaction.commit();
            return user;
        } catch(HibernateException e) {
        	 e.printStackTrace();
            throw new HibernateException("Cannot Find" +userId);
        } finally {
            session.close();
        }                                                                                          
    }
    
    public boolean allocateAddress(int userId, int addressId) throws HibernateException {
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            User user = (User)session.get(User.class, userId);
            Address address = (Address)session.get(Address.class, addressId);
            user.setUserAddress(address);
            transaction.commit();
            return true;
        } catch(HibernateException e) {
            throw new HibernateException("cannot assign address");
        } finally {
            session.close();
        }   
    } 
    
    public boolean updateUserAddress(User user) throws HibernateException {
        Session session = sessionFactory.openSession();
        try {
        	Transaction transaction = session.beginTransaction();
        	session.update(user);
        	transaction.commit();
        	return true;
        } catch(HibernateException e) {
            throw new HibernateException("cannot assign address");
        } finally {
            session.close();
        }   
    }
}
