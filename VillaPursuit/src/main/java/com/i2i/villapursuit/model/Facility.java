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
public class Facility implements Serializable {
    private static final long serialVersionUID = -4443344338397303602L;

    private boolean parking;
    private boolean drainage;
    private boolean transport;
    private String bedroom;
    private String areaSize;

    @Column
    @Field
    public boolean isParking() {
        return parking;
    }

    @Column
    @Field
    public boolean isDrainage() {
        return drainage;
    }

    @Column
    @Field
    public boolean isTransport() {
        return transport;
    }

    @Column(length = 10)
    @Field
    public String getBedroom() {
        return bedroom;
    }

    @Column(length = 15)
    @Field
    public String getAreaSize() {
        return areaSize;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public void setDrainage(boolean drainage) {
        this.drainage = drainage;
    }

    public void setTransport(boolean transport) {
        this.transport = transport;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public void setAreaSize(String areaSize) {
        this.areaSize = areaSize;
    }

}
