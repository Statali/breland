package org.server.localshop.services;

import org.server.localshop.domain.Category;
import org.server.localshop.domain.Products;
import org.server.localshop.repositoryclasses.CategoryRepository;
import org.server.localshop.repositoryclasses.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;

@Service
public class ProductsService {

	private final ProductsRepository productrepository;
	private final CategoryRepository categoryRepository;

	@Autowired
	public ProductsService(final ProductsRepository productJPA, final CategoryRepository categoryRepository){
		this.productrepository = productJPA;
		this.categoryRepository = categoryRepository;
	}

	public  void createProduct(JSONObject jSonParameters){	
		try {
			Category category = this.categoryRepository.findOne(jSonParameters.getLong("categoryId"));
			Products product = Products.fromJson(jSonParameters, category);
			this.productrepository.save(product);	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

}
