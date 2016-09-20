// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved

package com.i2i.villapursuit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * <p>
 * Model which allows access to properties of Facility using getter and setter methods.
 * </p>
 * 
 * @author Team #3
 * 
 * @created 07/09/16
 * 
 */
@Entity
@Table(name = "facilities", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Facility {
	
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id",unique = true, nullable = false)
    private int facilityId;
    
    @Column(name = "parking")
    private boolean parking; 
    
    @Column(name = "drainage")
    private boolean drainage;
    
    @Column(name = "transport")
    private boolean transport;
	
    @Column(name = "bedroom")
    private String bedroom;
	
    @Column(name = "area")
    private String area;
	
    @OneToOne
    private Advertisement advertisement;
    
    public Facility() {
    }

    public int getFacilityId() {
	return facilityId;
    }

    public void setFacilityId(int facilityId) {
	this.facilityId = facilityId;
    }

    public boolean isParking() {
	return parking;
    }

    public void setParking(boolean parking) {
	this.parking = parking;
    }

    public boolean isDrainage() {
	return drainage;
    }

    public void setDrainage(boolean drainage) {
	this.drainage = drainage;
    }

    public boolean isTransport() {
	return transport;
    }

    public void setTransport(boolean transport) {
	this.transport = transport;
    }

    public String getBedroom() {
	return bedroom;
    }

    public void setBedroom(String bedroom) {
	this.bedroom = bedroom;
    }

    public String getArea() {
	return area;
    }

    public void setArea(String area) {
	this.area = area;
    }

    public Advertisement getAdvertisement() {
	return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
	this.advertisement = advertisement;
    }
}
