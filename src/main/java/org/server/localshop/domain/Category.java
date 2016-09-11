package org.server.localshop.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Category extends  AbstractPersistable<Long>{

	private String designation;
	
	/*@OneToMany
	@Column(name="category_id")
	private Long categoryId;*/
	
	@OneToMany(mappedBy="category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Products> productslist;
	
	@Column(name="created_date")
	private String createdDate;

    
	@Column(name="updated_date")
	private String updatedDate;


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
