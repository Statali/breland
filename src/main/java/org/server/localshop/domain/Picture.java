package org.server.localshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Picture extends  AbstractPersistable<Long>{

	@Column(name="id")
	private long id;

	private String image_path;

	@Column(name="created_date")
	private String createdDate;

	@Column(name="updated_date")
	private String updatedDate;
	
	/* @OneToOne
	 private long Products_id;
	 
	 @OneToMany
		@JoinTable(
			name="products_has_package"
			, joinColumns={
				@JoinColumn(name="products_id")
				}
			, inverseJoinColumns={
				@JoinColumn(name="categorie_id")
				}
			)*/
	 
	 public Picture() {
	 }
	 
	 public Picture(String path) {
		 this.image_path = path;
	 }

	 public String getImage_path() {
		 return image_path;
	 }

	 public void setImage_path(final String image_path) {
		 this.image_path = image_path;
	 }
	
}
