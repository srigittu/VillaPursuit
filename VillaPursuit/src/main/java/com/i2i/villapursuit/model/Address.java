package com.i2i.villapursuit.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 * This class is used to represent an address with address,
 * area, city, state, land mark and pincode information.
 *
 * @author Team #3
 */
@Embeddable
@Indexed
public class Address extends BaseObject implements Serializable {
    private static final long serialVersionUID = 3617859655330969141L;
    
    private String address;
    private String area;
    private String city;
    private String state;
    private String landMark;
    private String pincode;

    @Column(length = 150)
    @Field
    public String getAddress() {
        return address;
    }
    
    @Column(length = 50)
    @Field
    public String getArea() {
        return area;
    }

    @Column(length = 50)
    @Field
    public String getCity() {
        return city;
    }
    
    @Column(length = 50)
    @Field
    public String getState() {
        return state;
    }
    
    @Column(name = "land_mark", length = 150)
    @Field
    public String getLandMark() {
        return landMark;
    }
    
    @Column(length = 15)
    @Field(analyze= Analyze.NO)
    public String getPincode() {
        return pincode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setArea(String area) {
        this.area = area;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    /**
     * Overridden equals method for object comparison. Compares based on hashCode.
     *
     * @param o Object to compare
     * @return true/false based on hashCode
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }

        final Address address1 = (Address) o;

        return this.hashCode() == address1.hashCode();
    }

    /**
     * Overridden hashCode method - compares on address, city, area, state, land mark and pincode.
     *
     * @return hashCode
     */
    public int hashCode() {
        int result;
        result = (address != null ? address.hashCode() : 0);
        result = 29 * result + (area != null ? area.hashCode() : 0);
        result = 29 * result + (city != null ? city.hashCode() : 0);
        result = 29 * result + (state != null ? state.hashCode() : 0);
        result = 29 * result + (landMark != null ? landMark.hashCode() : 0);
        result = 29 * result + (pincode != null ? pincode.hashCode() : 0);
        return result;
    }

    /**
     * Returns a multi-line String with key=value pairs.
     *
     * @return a String representation of this class.
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("landMark", this.landMark)
                .append("area", this.area)
                .append("address", this.address)
                .append("state", this.state)
                .append("pincode", this.pincode)
                .append("city", this.city).toString();
    }
}
