package org.server.localshop.api;

import org.server.localshop.domain.Product;
import org.server.localshop.domain.Response;
import org.server.localshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class ProductsApiResource {

	private final ProductService productService;

	@Autowired
	public ProductsApiResource(final ProductService productService){
		this.productService = productService;
	}	
	
	
	@ResponseBody
	@RequestMapping(value = "/products/", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product){
		return this.productService.createTrade(product);
	}
	
	@ResponseBody
	@RequestMapping(value = "/products/", method = RequestMethod.PUT)
    public Product updateUser(@RequestBody Product product) {
		return this.productService.updateUser(product);
	}
	
	@ResponseBody
	@RequestMapping(value = "/products/", method = RequestMethod.GET)
	public Page<Product> list( Pageable pageable){
		Page<Product> products = productService.listAllByPage(pageable);
		return products;
	} 
}
