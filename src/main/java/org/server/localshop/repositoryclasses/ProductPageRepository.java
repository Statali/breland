package org.server.localshop.repositoryclasses;

import org.server.localshop.domain.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductPageRepository extends PagingAndSortingRepository<Product,Integer> {

}