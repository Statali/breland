package org.server.localshop.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import org.springframework.data.jpa.domain.AbstractPersistable;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;

@Entity
@Table(name="seller")
public class Seller extends  AbstractPersistable<Long> {



	private String designation;

	private String description;

	@Column(name="po_box")
	private String poBox;

	@Column(name="created_date")
	private String createdDate;

	@Column(name="updated_date")
	private String updatedDate;

	@Column(name="seller_id")
	private int sellerId;

	/*public Long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}*/

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

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public Seller(){

	}

	public Seller(String designation, String description, String poBox, String createdDate, String updatedDate,
			int sellerId) {
		super();
		this.designation = designation;
		this.description = description;
		this.poBox = poBox;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.sellerId = sellerId;
	}

	public static Seller fromJson(JSONObject params){
		try {
			String designation= params.getString("designation");
			final String description = params.getString("description");
			final String poBox = params.getString("poBox");
			final int sellerId = (int) params.getLong("sellerId");
			SimpleDateFormat  df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			return new Seller( designation,  description,  poBox,  df.format(new Date()),  df.format(new Date()),sellerId);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}


	}

}
