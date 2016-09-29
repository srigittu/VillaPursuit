package com.i2i.villapursuit.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.i2i.villapursuit.dao.AdvertisementDao;
import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.exception.VillaPursuitException;

/**
 * This class interacts with Hibernate session to save/delete and retrieve
 * Advertisement objects.
 *
 * @author Team #3
 */
@Repository("advertisementDao")
@Transactional
public class AdvertisementDaoHibernate extends GenericDaoHibernate<Advertisement, Long> implements AdvertisementDao {

    /**
     * Default constructor of AdvertisementDaoHibernate.
     */
    public AdvertisementDaoHibernate() {
        super(Advertisement.class);
    }

    /**
     * Method which retrieves all active advertisements from advertisement
     * database.
     * 
     * @throws VillaPursuitException
     *             If there is failed or interrupted when get all active
     *             advertisements or when connection fails.
     */
    @SuppressWarnings("unchecked")
    public List<Advertisement> getActiveAdvertisements() throws VillaPursuitException {
        try {
            Session session = getSession();
            return session.createCriteria(Advertisement.class).add(Restrictions.eq("status", "active")).list();
        } catch (HibernateException exceptionCause) {
            throw new VillaPursuitException(
                    "\t\"Error occured while Retrieving Active Advertisements... Please try again...\""
                            + exceptionCause.toString());
        }
    }

    /**
     * Method which retrieves all inactive advertisements from advertisement
     * database.
     * 
     * @throws VillaPursuitException
     *             If there is failed or interrupted when get all inactive
     *             advertisements or when connection fails.
     */
    @SuppressWarnings("unchecked")
    public List<Advertisement> getInactiveAdvertisements() throws VillaPursuitException {
        try {
            return getSession().createCriteria(Advertisement.class).add(Restrictions.eq("status", "inactive")).list();
        } catch (HibernateException exceptionCause) {
            throw new VillaPursuitException(
                    "\t\"Error occured while Retrieving Inactive Advertisements... Please try again...\""
                            + exceptionCause.toString());
        }
    }

    /**
     * Method which retrieves all advertisements from advertisement database.
     * 
     * @throws VillaPursuitException
     *             If there is failed or interrupted when get all advertisements
     *             or when connection fails.
     */
    @SuppressWarnings("unchecked")
    public List<Advertisement> getAdvertisements() throws VillaPursuitException {
        try {
            Query qry = getSession().createQuery("from Advertisement");
            return qry.list();
        } catch (HibernateException exceptionCause) {
            throw new VillaPursuitException(
                    "\t\"Error occured while Retrieving All Advertisements... Please try again...\""
                            + exceptionCause.toString());
        }
    }

    /**
     * Method which saves advertisement's details to advertisement database.
     * 
     * @throws VillaPursuitException
     *             If there is failed or interrupted when get all inactive
     *             advertisements or when connection fails.
     */
    public Advertisement saveAdvertisement(Advertisement advertisement) throws VillaPursuitException {
        try {
            getSession().saveOrUpdate(advertisement);
            return advertisement;
        } catch (HibernateException exceptionCause) {
            throw new VillaPursuitException(
                    "\t\"Error occured while Retrieving All Advertisements... Please try again...\""
                            + exceptionCause.toString());
        }
    }

    /**
     * Method which retrieves advertisement by advertisement id.
     * 
     * @param advertisementId
     *            Contains id of an advertisement.
     * @throws VillaPursuitException
     *             If there is failed or interrupted when get an advertisement
     *             or when connection fails.
     */
    public Advertisement getAdvertisementById(Long advertisementId) throws VillaPursuitException {
        try {
            return (Advertisement) getSession().get(Advertisement.class, advertisementId);
        } catch (HibernateException exceptionCause) {
            throw new VillaPursuitException(
                    "\t\"Error occured while Retrieving an Advertisement... Please try again...\""
                            + exceptionCause.toString());
        }
    }

    /**
     * Method which removes advertisement by advertisement Id.
     * 
     * @param advertisementId
     *            Contains id of an advertisement
     * @throws VillaPursuitException
     *             If there is failed or interrupted when remove an
     *             advertisement or when connection fails.
     */
    public void removeAdvertisementById(Long advertisementId) throws VillaPursuitException {
        try {
            Session session = getSession();
            Advertisement advertisement = (Advertisement) session.get(Advertisement.class, advertisementId);
            session.delete(advertisement);
        } catch (HibernateException exceptionCause) {
            throw new VillaPursuitException("\t\"Error occured while Removing an Advertisement... Please try again...\""
                    + exceptionCause.toString());
        }
    }
}
