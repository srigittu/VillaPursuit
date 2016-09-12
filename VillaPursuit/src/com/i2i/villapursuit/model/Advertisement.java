// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved

package com.i2i.villapursuit.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * <p>
 * Model which allows access to properties of Advertisement using getter and setter methods.
 * </p>
 * 
 * @author Team #3
 * 
 * @created 07/09/16
 * 
 */

@Entity
@Table(name = "advertisements", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Advertisement {

	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id",unique = true, nullable = false)
    private int advertisementId;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private String status;
    
    @Column(name = "availability")
    private String availability;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "advertisement_date")
    private Date date;
    
    @Column(name = "house_type")
    private String houseType;
    
    @Column(name = "rent_type")
    private String rentType;
    
	@Column(name = "advertisement_count")
    private int advertisementCount;
    
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
	
	@OneToMany(mappedBy = "advertisement", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Facility> facilities = new HashSet<Facility>();
	
	@OneToMany(mappedBy = "advertisement", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Image> images = new HashSet<Image>();
	
	@OneToMany(mappedBy = "advertisement", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Review> advertisementReviews = new HashSet<Review>();
	
	public Advertisement() {
	}

	public Advertisement(int advertisementId, String title, String status, String availability, Date date, String houseType, String rentType, int advertisementCount,
			User user, Address address, Set<Facility> facilities, Set<Image> images, Set<Review> advertisementReviews) {
		this.advertisementId = advertisementId;
		this.title = title;
		this.status = status;
		this.availability = availability;
		this.date = date;
		this.advertisementCount = advertisementCount;
		this.user = null;
		this.address = null;
		this.facilities = null;
		this.images = null;
		this.advertisementReviews = null;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(Set<Facility> facility) {
		this.facilities.addAll(facility);
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> image) {
		this.images.addAll(image);
	}

	public Set<Review> getAdvertisementReviews() {
		return advertisementReviews;
	}

	public void setAdvertisementReviews(Set<Review> advertisementReview) {
		this.advertisementReviews.addAll(advertisementReviews);
	}

	public int getAdvertisementCount() {
		return advertisementCount;
	}

	public void setAdvertisementCount(int advertisementCount) {
		this.advertisementCount = advertisementCount;
	}

	public int getAdvertisementId() {
		return advertisementId;
	}

	public void setAdvertisementId(int advertisementId) {
		this.advertisementId = advertisementId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}