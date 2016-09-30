package com.i2i.villapursuit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 * This class is used to represent a Facility for an Advertisement with parking,
 * drainage, transport, bedroom and area size information.
 * 
 * @author Team #3
 */
@Embeddable
@Indexed
public class Facility implements Serializable{
    private static final long serialVersionUID = -8047612350638843477L;
    
    private Boolean parking;
    private Boolean drainage;
    private Boolean transport;
    private String bedroom;
    private String areaSize;
    
    @Column
    @Field
    public Boolean getParking() {
        return parking;
    }
    
    @Column
    @Field
    public Boolean getDrainage() {
        return drainage;
    }
    
    @Column
    @Field
    public Boolean getTransport() {
        return transport;
    }
    
    @Column(length = 50)
    @Field
    public String getBedroom() {
        return bedroom;
    }
    
    @Column(name = "area_size", length = 50)
    @Field
    public String getAreaSize() {
        return areaSize;
    }
    
    public void setParking(Boolean parking) {
        this.parking = parking;
    }
    
    public void setDrainage(Boolean drainage) {
        this.drainage = drainage;
    }
    
    public void setTransport(Boolean transport) {
        this.transport = transport;
    }
    
    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }
    
    public void setAreaSize(String areaSize) {
        this.areaSize = areaSize;
    }
    
}
