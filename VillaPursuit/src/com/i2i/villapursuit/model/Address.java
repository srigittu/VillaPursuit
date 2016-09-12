// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved

package com.i2i.villapursuit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;	
import javax.persistence.UniqueConstraint;

/**
 * <p>
 * Model which allows access to properties of Address using getter and setter methods.
 * </p>
 * 
 * @author Team #3
 * 
 * @created 07/09/16
 * 
 */

@Entity
@Table(name = "address", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Address {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id",unique = true, nullable = false)
    private int addressId;

    @Column(name = "number")
    private String number;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;
    
    @Column(name = "pincode")
    private int pincode;
    
    @Column(name = "state")
    private String state;
    
    public Address(int addressId, String number, String street, String city, int pincode, String state) {
        this.addressId = addressId;
        this.number = number;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
    }

    public Address() {
    	
    }
    
    public void SetAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setStreet(String street) {
        this.street = street;
    }    
    
    public void setCity(String city) {
        this.city = city;
    } 
    
    public void setPincode(int pincode) {
        this.pincode = pincode;
    } 
    
    public void setState(String state) {
        this.state = state;
    } 
 
    public int getAddressId() {
        return addressId;
    }

    public String getNumber() {
        return number;
    }
    
    public String getStreet() {
        return street;
    }
    
    public String getCity() {
        return city;
    }
    
    public int getPincode() {
        return pincode;
    }
    
    public String getState() {
        return state;
    }
	
}
