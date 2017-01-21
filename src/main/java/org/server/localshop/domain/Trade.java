package org.server.localshop.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.springframework.data.jpa.domain.AbstractPersistable;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;

@Entity
@Table(name="trade")
public class Trade extends  AbstractPersistable<Long> {

	private String designation;

	private String description;

	@Column(name="po_box")
	private String poBox;

	@Column(name="created_date")
	private String createdDate;

	@Column(name="updated_date")
	private String updatedDate;

	@Column(name="trader_id")
	private int traderId;
	
	@Column(name="image_id")
	private int imageId;
	
	/*@OneToMany(mappedBy="seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Products> productslist;*/

	/*public Long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}*/

	public String getDesignation() {
		return designation;
	}

	/*public Set<Products> getProductslist() {
		return productslist;
	}

	public void setProductslist(Set<Products> productslist) {
		this.productslist = productslist;
	}*/

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

	public int getTraderId() {
		return traderId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	
	public int getImageId() {
		return imageId;
	}

	public void setTraderId(int traderId) {
		this.traderId = traderId;
	}

	public Trade(){

	}

	public Trade(String designation, String description, String poBox, String createdDate, String updatedDate,
			int traderId) {
		super();
		this.designation = designation;
		this.description = description;
		this.poBox = poBox;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.traderId = traderId;
	}

	public static Trade fromJson(JSONObject params){
		try {
			String designation= params.getString("designation");
			final String description = params.getString("description");
			final String poBox = params.getString("poBox");
			final int sellerId = (int) params.getLong("traderId");
			SimpleDateFormat  df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			return new Trade( designation,  description,  poBox,  df.format(new Date()),  df.format(new Date()),sellerId);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

}
