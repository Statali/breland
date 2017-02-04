package org.server.localshop.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="trade")
public class Trade extends  AbstractPersistable<Long> {

	@Column(name="nearest_shops_name",nullable = false)
	private String nearestShopName;

    private String address;

    private double latitude;

    private double longitude;

    private String  phone;

    private String poBox;

    private String email;

    private String website;

    @Column(name="representer_name",nullable = false)
    private String representerName;
    
    @Column(name="created_date")
	private String createdDate;

	@Column(name="updated_date")
	private String updatedDate;

	@OneToOne
	private User user;
	
	@Column(name="logo_url",nullable = false)
	private String logoUrl;
	
	@OneToMany(mappedBy="trade", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Product> productslist;
	
	
	
	
	
	public Trade(){

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



	public String getNearestShopName() {
		return nearestShopName;
	}



	public void setNearestShopName(String nearestShopName) {
		this.nearestShopName = nearestShopName;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPoBox() {
		return poBox;
	}



	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getWebsite() {
		return website;
	}



	public void setWebsite(String website) {
		this.website = website;
	}



	public String getRepresenterName() {
		return representerName;
	}



	public void setRepresenterName(String representerName) {
		this.representerName = representerName;
	}



	public Set<Product> getProductslist() {
		return productslist;
	}



	public void setProductslist(Set<Product> productslist) {
		this.productslist = productslist;
	}



	public String getCreatedDate() {
		return createdDate;
	}
	
	

	

}
