// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved

package com.i2i.villapursuit.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    
    @Column(name = "price")
    private String price;
    
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name="date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
    private Date date;
    
    @Column(name = "house_type")
    private String houseType;
    
    @Column(name = "rent_type")
    private String rentType;
    
	@Column(name = "advertisement_count")
    private int advertisementCount;
    
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "address_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Address address;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
    private User user;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "facility_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
    private Facility facility;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "advertisement", cascade = CascadeType.PERSIST)
	@OnDelete(action = OnDeleteAction.CASCADE)
    private List<Image> images = new ArrayList<Image>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "advertisement", cascade = CascadeType.PERSIST)
	@OnDelete(action = OnDeleteAction.CASCADE)
    private List<Review> advertisementReviews = new ArrayList<Review>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "ADVERTISEMENT_USER", joinColumns = { @JoinColumn(name = "advertisement_id")},
    inverseJoinColumns = { @JoinColumn(name = "user_id") })
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Set<User> advertisementViewer = new HashSet<User>(5);
	
	public Advertisement() {
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
    
	public Set<User> getAdvertisementViewer() {
		return advertisementViewer;
	}

	public void setAdvertisementViewer(Set<User> advertisementViewer) {
		this.advertisementViewer.addAll(advertisementViewer);
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

	
	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Review> getAdvertisementReviews() {
		return advertisementReviews;
	}

	public void setAdvertisementReviews(List<Review> advertisementReviews) {
		this.advertisementReviews = advertisementReviews;
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
	
	public void addImages(Image image){
		this.images.add(image);
	}
	
    public void addReviews(Review review) {
        this.advertisementReviews.add(review);
    }
}