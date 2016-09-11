package org.server.localshop.repositoryclasses;

import org.server.localshop.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long>{

}
