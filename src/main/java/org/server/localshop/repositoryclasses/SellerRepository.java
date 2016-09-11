package org.server.localshop.repositoryclasses;

import org.server.localshop.domain.Place;
import org.server.localshop.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long>{

}
