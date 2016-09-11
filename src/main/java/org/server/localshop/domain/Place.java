package org.server.localshop.domain;



import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import org.springframework.data.jpa.domain.AbstractPersistable;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;


/**
 * The persistent class for the place database table.
 * 
 */
@Entity
public class Place extends  AbstractPersistable<Long> {
	/*private static final long serialVersionUID = 1L;*/

	@Column(name="id")
	private long id;

	private String adress;

	private String contact;


	@Column(name="created_date")
	private String createdDate;

	private String longitude;

	private String latitude;


	@Column(name="updated_date")
	private String updatedDate;

	//bi-directional many-to-many association to Commerce
	@ManyToMany
	@JoinTable(
			name="seller_has_place"
			, joinColumns={
					@JoinColumn(name="place_id")
			}
			, inverseJoinColumns={
					@JoinColumn(name="seller_id")
			}
			)
	private Set<Seller> sellers;

	public Place() {
	}

	private Place (final String latitude, final String longitude, final String adress, final String contact ){
		this.latitude = latitude;
		this.longitude = longitude;
		this.adress = adress;
		this.contact = contact;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getINTitude() {
		return this.longitude;
	}

	public void setINTitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Set<Seller> getSellers() {
		return this.sellers;
	}

	public void setSellers(Set<Seller> sellers) {
		this.sellers = sellers;
	}



	public static Place fromJson(JSONObject fromClient){
		try {
			String latitude = fromClient.getString("latitude");
			final String longitude = fromClient.getString("longitude");
			final String adress = fromClient.getString("adress");
			final String contact = fromClient.getString("contact");	
			return new Place(latitude, longitude, adress, contact);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}

	}

}