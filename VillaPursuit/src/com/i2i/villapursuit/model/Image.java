/**
 * @author Team #3
 *
 * @created 10/09/16 
 */
package com.i2i.villapursuit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "images", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Image {
	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id",unique = true, nullable = false)
    private int imageId;

    @Column(name = "image_path")
    private String imagePath;

    @ManyToOne
    private Advertisement advertisement;

	public Image(int imageId, String imagePath, Advertisement advertisement) {
		this.imageId = imageId;
		this.imagePath = imagePath;
		this.advertisement = null;
	}

	public Image() {
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Advertisement getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}
		
}
