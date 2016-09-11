package org.server.localshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import org.springframework.data.jpa.domain.AbstractPersistable;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;

@Entity
public class Products extends  AbstractPersistable<Long>{

	private String code;

	private String designation;

	private long  unit;

	private long packing;

	private double price;

	private String description;

	@Column(name="unit_quantity")
	private Long unitQuantity;

	@ManyToOne
	@JoinColumn(name="category_id", nullable = false)
	private Category category;

	/*@OneToOne
	@Column(name="image_id")
	private long imageId;*/


	@Column(name="created_date")
	private String createdDate;


	@Column(name="updated_date")
	private String updatedDate;

	public Products (){

	}
	public Products (final String code, final String designation, final Long unit, final Long packing,
			final double price, final String description, final Long quantity_unit, final Category category){
		this.code = code;
		this.designation = designation;
		this.unit = unit;
		this.packing = packing;
		this.price = price;
		this.description = description;
		this.unitQuantity = quantity_unit;
		this.category = category;
	}

	public static Products fromJson(JSONObject params, Category category){

		try {
			String code = params.getString("code");
			final String designation = params.getString("designation");
			final String description = params.getString("description");
			final Long unit = Long.parseLong(params.getString("unit"));
			final Long packing = Long.parseLong(params.getString("packing"));
			final double price = Double.parseDouble(params.getString("price"));
			final Long quantity_unit = Long.parseLong(params.getString("unitQuantity"));
			return new Products( code, designation, unit, packing, price, description,quantity_unit, category);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}






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
