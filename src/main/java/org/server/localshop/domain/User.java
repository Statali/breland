package org.server.localshop.domain;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
public class User extends  AbstractPersistable<Long> {

	private String dob;

	@Column(unique = true)
	private String email;

	private String firstname;

	private String lastname;

	@Column(unique = true)
	private String  phone;

	@Column(name="user_token", unique = true)
	private String userToken;

	@Column(name="is_trader")
	private boolean isTrader;

	@Column(name="trader_type")
	private String traderType;

	@Column(name="display_name")
	private String displayName;

	@Column(name="created_date")
	private String createdDate;


	@Column(name="updated_date")
	private Date updatedDate;

	@Column(name="image_id")
	private Long imageId;
	
	@Column(name="is_login")
	private boolean isLogin;
	


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

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
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

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}	
	
	
	


	public boolean  getIsLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
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