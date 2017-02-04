package org.server.localshop.services;

import org.server.localshop.domain.Product;
import org.server.localshop.domain.Response;
import org.server.localshop.domain.Trade;
import org.server.localshop.domain.User;
import org.server.localshop.repositoryclasses.CategoryRepository;
import org.server.localshop.repositoryclasses.ProductPageRepository;
import org.server.localshop.repositoryclasses.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private final ProductRepository productrepository;
	private final ProductPageRepository productPageRepository;
	private final DateTime dateTime;

	@Autowired
	public ProductService(final ProductRepository productrepository, final DateTime dateTime, final ProductPageRepository productPageRepository){
		this.productrepository = productrepository;
		this.productPageRepository = productPageRepository;
		this.dateTime = dateTime;
	}


	public Product  createTrade(Product product){
		
		if (product.getId() != null ) {
			throw new IllegalArgumentException("product.with.already.exist");
		}
		else{
			String code = randomAlphaNumeric(8);
			while(this.productrepository.findByCode(code) != null){
				code = randomAlphaNumeric(8);
			}
			product.setCode(code);
			product.setCreatedDate(this.dateTime.getCurrentDateTime());
			product.setUpdatedDate(this.dateTime.getCurrentDateTime());
			product = this.productrepository.save(product);
			//result.setObject(product);				
		}
		return product;
	} 
	
	public Product updateUser( Product product){
		//Response<Product> result = new Response<Product>();
		if (!this.productrepository.exists(product.getId())) {
			throw new IllegalArgumentException("product.with.id.noexist");
		}
		else{
			product.setUpdatedDate(this.dateTime.getCurrentDateTime());			
			product = this.productrepository.save(product);
			//result.setObject(product);
		}
		return product;
	}
	
	
	private  String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}


	public Page<Product> listAllByPage(Pageable pageable) {
		return this.productPageRepository.findAll(pageable);
	}

}
