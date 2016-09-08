package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    private int facilityValue;
    
    @ManyToMany(mappedBy="facilities")
	private Set<Advertisement> advertisements = new HashSet<Advertisement>();
    
    public Facility(int facilityId, String facilityName, int facilityValue, Set<Advertisement> advertisements) {
		this.facilityId = facilityId;
		this.facilityName = facilityName;
		this.facilityValue = facilityValue;
		this.advertisements = advertisements;
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

	public Set<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(Set<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	public int getFacilityValue() {
		return facilityValue;
	}

	public void setFacilityValue(int facilityValue) {
		this.facilityValue = facilityValue;
	}
}
