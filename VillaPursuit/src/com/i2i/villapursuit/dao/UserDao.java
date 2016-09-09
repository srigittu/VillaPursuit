/**
 * @author Team #3
 * 
 * @created 07/09/16
 */
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



public class UserDao {
    private SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    private Transaction transaction = null;
    
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

    public User retriveUser(String userName) throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            User user = (User)session.get(User.class, userName);                                    //Getting User
            transaction.commit();
            return user;
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            throw new VillaPursuitException("\t\"Error occured while retriving User... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }

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
            throw new VillaPursuitException("\t\"Error occured while Updating User Salary... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }

	public void insertUserAddress(Address userAddress) {
		// TODO Auto-generated method stub
		
	}
    
    /*public void assignProjectToUser(String userName, String projectId) throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            User user = (User)session.get(User.class, userName);
            Project project = (Project)session.get(Project.class, projectId); 
            user.setProject(project);                                                                  //Assigning Project to User
            transaction.commit();
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            throw new VillaPursuitException("\t\"Error occured while assigning Project to User... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }
    
    public void removeProjectFromUser(String userName) throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            User user = (User)session.get(User.class, userName);
            user.setProject(null);                                                                  //Removing User From project
            transaction.commit();
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            LogFile.error("Error occurred in User DataBase:removeProjectFromUser()"+exceptionCause.toString());
            throw new VillaPursuitException("\t\"Error occured while removing Project from User... Please try again...\"");
        } finally {
            session.close(); 
        }
    }*/
}
