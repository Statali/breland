package org.server.localshop.services;

import org.server.localshop.repositoryclasses.CategoryRepository;
import org.server.localshop.repositoryclasses.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	private final ProductRepository productrepository;
	private final CategoryRepository categoryRepository;

	@Autowired
	public ProductService(final ProductRepository productrepository, final CategoryRepository categoryRepository){
		this.productrepository = productrepository;
		this.categoryRepository = categoryRepository;
	}	

}
