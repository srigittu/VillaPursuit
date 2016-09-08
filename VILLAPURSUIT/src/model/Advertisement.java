package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "advertisement", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Advertisement {

	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id",unique = true, nullable = false)
    private int advertisementId;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private String status;
    
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private User user;
    
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "advertisement")
    private List<Review> reviews = new ArrayList<Review>();
    
    @Column(name = "post_time", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postTime;
    
    @ManyToMany(cascade = {CascadeType.PERSIST})
	@JoinTable(name="ad_facility", 
				joinColumns={@JoinColumn(name=" advertisement_id")}, 
				inverseJoinColumns={@JoinColumn(name="facility_id")})
	private Set<Facility> facilities = new HashSet<Facility>();
    
    public Advertisement(int advertisementId, String title, String status, User user, List<Review> reviews, Date postTime, Set<Facility> facilities) {
		this.advertisementId = advertisementId;
		this.title = title;
		this.status = status;
		this.user = user;
		this.reviews = reviews;
		this.postTime = postTime;
		this.facilities = facilities;
	}
	
	public Set<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}

	public Advertisement() {
		
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

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
}
