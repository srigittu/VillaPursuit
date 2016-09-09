package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "facility", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Facility {

	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id",unique = true, nullable = false)
    private int facilityId;

    @Column(name = "facility_name")
    private String facilityName;

    @Column(name = "facility_value")
    private String facilityValue;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Advertisement advertisement;
    
    public Facility(int facilityId, String facilityName, String facilityValue, Advertisement advertisement) {
		this.facilityId = facilityId;
		this.facilityName = facilityName;
		this.facilityValue = facilityValue;
		this.advertisement = advertisement;
	}
    
    public Facility() {
    	
    }

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public Advertisement getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}

	public String getFacilityValue() {
		return facilityValue;
	}

	public void setFacilityValue(String facilityValue) {
		this.facilityValue = facilityValue;
	}
}
