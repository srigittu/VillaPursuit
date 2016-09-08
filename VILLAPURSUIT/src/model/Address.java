package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;	
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "address", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Address {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id",unique = true, nullable = false)
    private int addressId;

    @Column(name = "door_number")
    private String doorNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;
    
    @Column(name = "pin_code")
    private int pinCode;
    
    @Column(name = "state")
    private String state;
    
    public Address(int addressId, String doorNumber, String street, String city, int pinCode, String state) {
        this.addressId = addressId;
        this.doorNumber = doorNumber;
        this.street = street;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
    }

public Address() {
    	
    }
    
    public void SetAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }    
    
    public void setCity(String city) {
        this.city = city;
    } 
    
    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    } 
    
    public void setState(String state) {
        this.state = state;
    } 
 
    public int getAddressId() {
        return addressId;
    }

    public String getDoorNumber() {
        return doorNumber;
    }
    
    public String getStreet() {
        return street;
    }
    
    public String getCity() {
        return city;
    }
    
    public int getPinCode() {
        return pinCode;
    }
    
    public String getState() {
        return state;
    }

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", doorNumber=" + doorNumber + ", street=" + street + ", city="
				+ city + ", pinCode=" + pinCode + ", state=" + state + "]";
	}
}
