package com.i2i.villapursuit.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * This class represents the basic "advertisement" object in that allows for
 * user to post advertisement based on the privilege of seller.
 *
 * @author Team #3
 */
@Entity
@Table(name = "seller_advertisement")
@Indexed
@XmlRootElement
public class Advertisement implements Serializable {
    private static final long serialVersionUID = -1480620281214041633L;

    private Long id;
    private String title;
    private String status;
    private String availability;
    private String price;
    private Date date;
    private String houseType;
    private String rentType;
    private String image;
    private String advertisementCount;
    private String notificationCount;
    private Address address;
    private Facility facility;
    private User user;
    private Set<User> advertisementViewer = new HashSet<User>();
    private Set<AdvertisementReview> advertisementReviews;
    
    public Advertisement() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Column(nullable = false, length = 128)
    @Field
    public String getTitle() {
        return title;
    }

    @Column(nullable = false, length = 32)
    @Field
    public String getStatus() {
        return status;
    }

    @Column(nullable = false, length = 32)
    @Field
    public String getAvailability() {
        return availability;
    }

    @Column(nullable = false, length = 32)
    @Field
    public String getPrice() {
        return price;
    }

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Field
    public Date getDate() {
        return date;
    }

    @Column(name = "house_type", nullable = false, length = 32)
    @Field
    public String getHouseType() {
        return houseType;
    }

    @Column(name = "rent_type", nullable = false, length = 32)
    @Field
    public String getRentType() {
        return rentType;
    }

    @Column(name = "advertisement_count", length = 10)
    @Field
    @XmlTransient
    public String getAdvertisementCount() {
        return advertisementCount;
    }

    @Column(name = "notification_count", length = 10)
    @Field
    @XmlTransient
    public String getNotificationCount() {
        return notificationCount;
    }
    
    @Embedded
    @IndexedEmbedded
    public Facility getFacility() {
        return facility;
    }

    @Embedded
    @IndexedEmbedded
    public Address getAddress() {
        return address;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }
    
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(
            name = "advertisement_viewer",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = @JoinColumn(name = "advertisement_id")
    )
    public Set<User> getAdvertisementViewer() {
        return advertisementViewer;
    }
    
    @OneToMany(mappedBy = "advertisement", cascade = javax.persistence.CascadeType.ALL)
    public Set<AdvertisementReview> getAdvertisementReviews() {
        return advertisementReviews;
    }
    
    @Column
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAdvertisementReviews(Set<AdvertisementReview> advertisementReviews) {
        this.advertisementReviews = advertisementReviews;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public void setAdvertisementViewer(Set<User> advertisementViewer) {
        this.advertisementViewer = advertisementViewer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public void setAdvertisementCount(String advertisementCount) {
        this.advertisementCount = advertisementCount;
    }

    public void setNotificationCount(String notificationCount) {
        this.notificationCount = notificationCount;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
