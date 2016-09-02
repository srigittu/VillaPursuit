package com.i2i.villapursuit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;	
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.NotNull; 

@Entity
@Table(name = "address", uniqueConstraints = @UniqueConstraint(columnNames = "address_id"))
public class Address {

    @Id 
    @GeneratedValue
    @NotNull
    @Column(name = "address_id",unique = true, nullable = false)
    private int addressId;

    @NotNull
    @Column(name = "door_no")
    private String doorNo;

    @NotNull
    @Column(name = "street_name")
    private String streetName;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "pin_code")
    private String pinCode;

    @NotNull
    @Column(name = "state")
    private String state;

    public Address() {
    	
    }
    
    public Address(int addressId, String doorNo, String streetName, String city, String pinCode, String state) {
        this.addressId = addressId;
        this.doorNo = doorNo;
        this.streetName = streetName;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
    }


    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }    
    
    public void setCity(String city) {
        this.city = city;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAddressId() {
        return addressId;
    }
    
    public String getDoorNo() {
        return doorNo;
    }
   
    public String getStreetName() {
        return streetName;
    }
    
    public String getCity() {
        return city;
    }
   
    public String setPinCode() {
        return pinCode;
    }
 
    public String getState() {
        return state;
    }
}
