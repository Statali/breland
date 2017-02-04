package org.server.localshop.services;

import java.util.List;

import org.server.localshop.domain.Category;
import org.server.localshop.domain.Response;
import org.server.localshop.repositoryclasses.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServices {

	private final CategoryRepository categoryRepository;
	private final DateTime dateTime;

	@Autowired
	public CategoryServices( final CategoryRepository categoryRepository,  final DateTime dateTime){
		this.categoryRepository = categoryRepository;
		this.dateTime = dateTime;
	}	
	
	
	public Category  createCategory(Category category){
				if (category.getId() != null ) {
			throw new IllegalArgumentException("category.already.exist");
		}
		else{
			if(this.categoryRepository.findByDesignation(category.getDesignation()) != null) {
				throw new IllegalArgumentException("category.with.designation.exist");
			}
			else{
				category.setCreatedDate(this.dateTime.getCurrentDateTime());
				category.setUpdatedDate(this.dateTime.getCurrentDateTime());
				category = this.categoryRepository.save(category);
			}
		}
		return category;
	}
	
	public Category updateCategory( Category category){
		
		if (!this.categoryRepository.exists(category.getId())) {
			throw new  IllegalArgumentException("category.with.id.noexist");
		}
		else{
			category.setUpdatedDate(this.dateTime.getCurrentDateTime());			
			category = this.categoryRepository.save(category);
					}
		return category;
	}
	
	public List<Category> getAll(){
		return this.categoryRepository.findAll();
	}
	
}
