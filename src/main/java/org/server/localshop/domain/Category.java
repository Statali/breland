package org.server.localshop.domain;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="category")
public class Category extends  AbstractPersistable<Long>{

	private String designation;
	
	@OneToMany
	Collection<Category> Categories;
		
	
	
	@OneToMany(mappedBy="category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Product> productslist;
	
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

	public Collection<Category> getCategories() {
		return Categories;
	}

	public void setCategories(Collection<Category> categories) {
		Categories = categories;
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

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
}
