package org.server.localshop.services;

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
	
	
	public Response<Category>  createCategory(Category category){
		Response<Category> result = new Response<Category>();
		if (category.getId() != null ) {
			result.getException().add((new IllegalArgumentException("category.already.exist")));
		}
		else{
			if(this.categoryRepository.findByDesignation(category.getDesignation()) != null) {
				result.getException().add((new IllegalArgumentException("category.with.designation.exist")));
			}
			else{
				category.setCreatedDate(this.dateTime.getCurrentDateTime());
				category.setUpdatedDate(this.dateTime.getCurrentDateTime());
				category = this.categoryRepository.save(category);
					result.setObject(category);
			}
		}
		return result;
	}
	
	public Response<Category> updateCategory( Category category){
		Response<Category> result = new Response<Category>();
		if (!this.categoryRepository.exists(category.getId())) {
			result.getException().add((new IllegalArgumentException("category.with.id.noexist")));
		}
		else{
			category.setUpdatedDate(this.dateTime.getCurrentDateTime());			
			category = this.categoryRepository.save(category);
			result.setObject(category);
		}
		return result;
	}
	
}
