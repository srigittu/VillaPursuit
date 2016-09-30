package com.i2i.villapursuit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.Field;

/**
 * This class is used to represent a Review for an Advertisement with 
 * comments and ratings information.
 * @author Team #3
 */
@Entity
@Table(name = "advertisement_review")
public class AdvertisementReview implements Serializable{
    private static final long serialVersionUID = -2131687729799096642L;
    
    private Long id;
    private String comment;
    private String rating;
    private Date date;
    private User user;
    private Advertisement advertisement;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }
    
    @Column(nullable = false, length = 128)
    @Field
    public String getComment() {
        return comment;
    }
    
    @Column(nullable = false, length = 32)
    @Field
    public String getRating() {
        return rating;
    }
    @Column(name = "date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    @Field
    public Date getDate() {
        return date;
    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "advertisement_id")
    public Advertisement getAdvertisement() {
        return advertisement;
    }
    
    public AdvertisementReview() {
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }
    
    
}
