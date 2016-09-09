package model;

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
@Table(name = "review", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Review {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id",unique = true, nullable = false)
    private int reviewId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "rating")
    private int rating;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Advertisement advertisement;
    
	public Review(int reviewId, String comment, int rating, User user, Advertisement advertisement) {
		this.reviewId = reviewId;
		this.comment = comment;
		this.rating = rating;
		this.user = user;
		this.advertisement = advertisement;
	}
	
	public Review() {
		
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int advertisementId) {
		this.reviewId = advertisementId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Advertisement getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}
}
