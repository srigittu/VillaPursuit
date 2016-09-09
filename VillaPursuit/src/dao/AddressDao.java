package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import configuration.HibernateConfiguration;
import model.Address;

public class AddressDao {
	
	private HibernateConfiguration hibernateConfigure = HibernateConfiguration.getConnect();
    private SessionFactory sessionFactory = hibernateConfigure.createSessionFactory(); 

	public boolean insertAddress(Address address) throws HibernateException { 
        Session session = sessionFactory.openSession();
        try {  
            Transaction transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
            return true;
        } catch(HibernateException e) { 
              throw new HibernateException("Insertion Failed:" +e.getMessage());
        } finally {
            session.close();
        }
    } 
}
