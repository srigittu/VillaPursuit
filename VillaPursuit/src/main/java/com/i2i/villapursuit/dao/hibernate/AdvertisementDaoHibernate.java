package com.i2i.villapursuit.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.i2i.villapursuit.dao.AdvertisementDao;
import com.i2i.villapursuit.model.Advertisement;

/**
 * This class interacts with Hibernate session to save/delete and
 * retrieve Advertisement objects.
 *
 * @author Team #3
 */
@Repository("advertisementDao")
public class AdvertisementDaoHibernate extends GenericDaoHibernate<Advertisement, Long> implements AdvertisementDao {
    
	/**
     * Constructor that sets the entity to Advertisement.class.
     */
    public AdvertisementDaoHibernate() {
        super(Advertisement.class);
    }
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Advertisement> getActiveAdvertisements() {
        Query qry = getSession().createQuery("from Advertisement a where a.status = active");
        return qry.list();
    }
    
    /**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	public List<Advertisement> getInactiveAdvertisements() {
		Query qry = getSession().createQuery("from Advertisement a where a.status = inactive");
        return qry.list();
	}
    
	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	public List<Advertisement> getAdvertisements() {
		Query qry = getSession().createQuery("from Advertisement");
        return qry.list();
	}
    
	/**
     * {@inheritDoc}
     */
	public Advertisement saveAdvertisement(Advertisement advertisement) {
		getSession().saveOrUpdate(advertisement);
		return advertisement;
	}
	
	/**
     * {@inheritDoc}
     */
	public void removeAdvertisementById(long advertisementId) {
        Session session = getSessionFactory().getCurrentSession();
        Advertisement advertisement = (Advertisement) session.get(Advertisement.class, advertisementId);
        session.delete(advertisement);
    }
}
