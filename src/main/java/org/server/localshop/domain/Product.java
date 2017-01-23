package org.server.localshop.domain;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;

@Entity
@Table(name="product")
public class Product extends  AbstractPersistable<Long>{

	private String code;

	private String designation;

	private long  unit;

	private long packing;

	private double price;
	
	private double discount;

	private String description;
	
	@Column(name="unit_quantity")
	private Long unitQuantity;

	@Column(name="image_url")
	private String imageUrl;


	@Column(name="created_date")
	private String createdDate;


	@Column(name="updated_date")
	private String updatedDate;
	
	@ManyToOne
	@JoinColumn(name="category_id", nullable = false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="trade_id", nullable = false)
	private Trade trade;
	
	@OneToMany
    private Collection<Trade> trades ;
	
	
	
	

	public Product (){

	}
	


	public double getDiscount() {
		return discount;
	}



	public void setDiscount(double discount) {
		this.discount = discount;
	}



	public Long getUnitQuantity() {
		return unitQuantity;
	}



	public void setUnitQuantity(Long unitQuantity) {
		this.unitQuantity = unitQuantity;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public void setUnit(long unit) {
		this.unit = unit;
	}



	public void setPacking(long packing) {
		this.packing = packing;
	}



	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public Long getUnit() {
		return unit;
	}


	public void setUnit(Long unit) {
		this.unit = unit;
	}


	public long getPacking() {
		return packing;
	}


	public void setPacking(Long packing) {
		this.packing = packing;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Long getunitQuantity() {
		return this.unitQuantity;
	}


	public void setunitQuantity(Long quantity_unit) {
		this.unitQuantity = quantity_unit;
	}

}
