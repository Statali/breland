package org.server.localshop.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="user")
public class User extends  AbstractPersistable<Long> {

	@Column(name="date_of_birth", length = 20, nullable = true)
	private String dob;

	@Column(unique = true)
	private String email;

	@Column(length = 50, nullable = true)
	private String firstname;

	@Column(length = 50, nullable = true)
	private String lastname;

	@Column(unique = true)
	private String  phone;

	
	@Column(name="user_token", unique = true, length = 255)
	private String userToken;

	@Column(name="is_trader")
	private boolean isTrader;

	@Column(name="trader_type", nullable = true)
	private String traderType;

	@Column(name="display_name")
	private String displayName;

	@Column(name="created_date")
	private String createdDate;

	@Column(name="updated_date")
	private String updatedDate;

	@Column(name="image_url",length = 255)
	private String imageUrl;
	
	@Column(name="is_logged")
	private boolean isLogged;
	


	public User() {
	}	

	public String  getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUserToken() {
		return userToken;
	}


	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}


	public boolean getIsTrader() {
		return isTrader;
	}


	public void setIsTrader(boolean isTrader) {
		this.isTrader = isTrader;
	}


	public String getTraderType() {
		return traderType;
	}

	public void setTraderType(String traderType) {
		this.traderType = traderType;
	}

	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

		


	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public void setTrader(boolean isTrader) {
		this.isTrader = isTrader;
	}

	/*public static User fromJson(String jsonInString ){		
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		try {
			user = mapper.readValue(jsonInString , User.class);
		} catch (JsonGenerationException  | JsonMappingException | JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  user;	
	}*/

}