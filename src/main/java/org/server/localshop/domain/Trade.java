package org.server.localshop.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="trade")
public class Trade extends  AbstractPersistable<Long> {

	@Column(nullable = false)
	private String designation;

	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private double latitude;

	@Column(nullable = false)
	private double longitude;
	
	@Column(nullable = false)
	private String  phone;

	@Column(name="po_box", length = 10,nullable = true)
	private String poBox;

	@Column(name="created_date",nullable = false)
	private String createdDate;

	@Column(name="updated_date", nullable = false)
	private String updatedDate;

	@OneToOne
	private User user;
	
	@Column(name="logo_url",nullable = false)
	private String logoUrl;
	
	@OneToMany(mappedBy="trade", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Product> productslist;
	
	
	
	
	
	public Trade(){

	}
	

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPoBox() {
		return poBox;
	}

	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getLogoUrl() {
		return logoUrl;
	}


	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	

}
