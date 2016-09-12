// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved

package com.i2i.villapursuit.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * <p>
 * Model which allows access to properties of Review using getter and setter methods.
 * </p>
 * 
 * @author Team #3
 * 
 * @created 07/09/16
 * 
 */

@Entity
@Table(name = "reviews", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Review {
	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id",unique = true, nullable = false)
    private int reviewId;
    
	@Column(name = "comment")
    private String comment;
	
    @Column(name = "rating")
    private String rating;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "advertisement_date")
    private Date date;
    
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
	
    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Advertisement advertisement;

    
	public Review() {
	}


	public Review(int reviewId, String comment, String rating, Date date, User user, Advertisement advertisement) {
		super();
		this.reviewId = reviewId;
		this.comment = comment;
		this.rating = rating;
		this.date = date;
		this.user = null;
		this.advertisement = null;
	}


	public int getReviewId() {
		return reviewId;
	}


	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Advertisement getAdvertisement() {
		return advertisement;
	}


	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}
	
		
}
