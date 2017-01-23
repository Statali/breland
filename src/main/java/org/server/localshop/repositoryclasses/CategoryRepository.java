package org.server.localshop.repositoryclasses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.server.localshop.domain.Category;
import org.server.localshop.domain.Trade;

public interface CategoryRepository  extends JpaRepository<Category,Long>, JpaSpecificationExecutor<Category>{

	public Category  findByDesignation(@Param("designation") String designation);
}
