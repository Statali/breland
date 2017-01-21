package org.server.localshop.repositoryclasses;

import org.server.localshop.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;



public interface TradeRepository extends JpaRepository<Trade,Long>, JpaSpecificationExecutor<Trade>{
	
	

}
