package org.server.localshop.repositoryclasses;

import org.server.localshop.domain.Product;
import org.server.localshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public User findByCode(@Param("code") String code);
}
