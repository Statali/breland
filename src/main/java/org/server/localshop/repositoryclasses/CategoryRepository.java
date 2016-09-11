package org.server.localshop.repositoryclasses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.server.localshop.domain.Category;

public interface CategoryRepository  extends JpaRepository<Category,Long>, JpaSpecificationExecutor<Category>{

}
