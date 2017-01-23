package org.server.localshop.api;

import org.server.localshop.domain.Category;
import org.server.localshop.domain.Response;
import org.server.localshop.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoriesApiResource {

	private final CategoryServices categoryServices;

	@Autowired
	public CategoriesApiResource(final CategoryServices categoryServices){
		this.categoryServices = categoryServices;
	}	
	
		
	@ResponseBody
	@RequestMapping(value = "/categories/", method = RequestMethod.POST)
	public Response<Category> createCategory(@RequestBody Category category){
		return this.categoryServices.createCategory(category);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/categories/", method = RequestMethod.PUT)
    public Response<Category> updateTrade(@RequestBody Category category) {
		return this.categoryServices.updateCategory(category);
	}
}
