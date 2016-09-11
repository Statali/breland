package org.server.localshop.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.server.localshop.api.resources.ProductsApiResource;
import org.server.localshop.api.resources.SellerApiResource;
import org.springframework.stereotype.Component;

@Component
	public class JerseyConfig extends ResourceConfig {
	    public JerseyConfig() {
	        packages("org.server.localshop.api.resources");

	    }

	}