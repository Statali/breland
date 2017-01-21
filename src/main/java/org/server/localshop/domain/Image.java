package org.server.localshop.domain;


import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Date;


/**
 * The persistent class for the image database table.
 * 
 */
@Entity
public class Image  extends  AbstractPersistable<Long> {
	//private static final long serialVersionUID = 1L;


   

	@Column(name="image_path")
	private String imagePath;

	@Column(name="created_date")
	private String createdDate;

	


	@Column(name="updated_date")
	private String updatedDate;

    public Image() {
    }

	

	public String  getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(String  createdDate) {
		this.createdDate = createdDate;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String  getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

}