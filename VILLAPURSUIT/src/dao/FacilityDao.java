package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import configuration.HibernateConfiguration;
import model.Facility;;

public class FacilityDao {
	private HibernateConfiguration hibernateConfigure = HibernateConfiguration.getConnect();
    private SessionFactory sessionFactory = hibernateConfigure.createSessionFactory(); 

	public boolean insertFacility(Facility facility) throws HibernateException { 
        Session session = sessionFactory.openSession();
        try {  
            Transaction transaction = session.beginTransaction();
            session.save(facility);
            transaction.commit();
            return true;
        } catch(HibernateException e) { 
              throw new HibernateException("Insertion Failed:" +e.getMessage());
        } finally {
            session.close();
        }
    } 
}
