package com.i2i.villapursuit.dao.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.i2i.villapursuit.dao.AdvertisementDao;
import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.User;

/**
 * This class interacts with Hibernate session to save/delete and
 * retrieve Advertisement objects.
 *
 * @author Team #3
 */
@Repository("advertisementDao")
@Transactional
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
        return getSession().createCriteria(Advertisement.class).add(Restrictions.eq("status", "active")).list();
    }
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Advertisement> getInactiveAdvertisements() {
        return getSession().createCriteria(Advertisement.class).add(Restrictions.eq("status", "inactive")).list();
    }
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Advertisement> getAdvertisements() {
        return getSession().createQuery("from Advertisement").list();
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
    public void removeAdvertisementById(Long advertisementId) {
        Advertisement advertisement = (Advertisement)getSession().get(Advertisement.class, advertisementId);
        getSession().delete(advertisement);
    }

    /**
     * {@inheritDoc}
     */
    public void setAdvertisementViewer(Long advertisementId, User user) {
        Set<User> advertisementViewer = new HashSet<User>();
        Advertisement advertisement = (Advertisement)getSession().get(Advertisement.class, advertisementId);
        advertisementViewer.add(user);
        advertisement.setAdvertisementViewer(advertisementViewer);
        getSession().saveOrUpdate(advertisement);
    }

    /**
     * {@inheritDoc}
     */
    public Advertisement getAdvertisementById(Long advertisementId) {
        return (Advertisement)getSession().get(Advertisement.class, advertisementId);
    }
}

