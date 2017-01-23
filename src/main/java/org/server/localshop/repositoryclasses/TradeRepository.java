package org.server.localshop.repositoryclasses;

import org.server.localshop.domain.Trade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface TradeRepository extends JpaRepository<Trade,Long>, JpaSpecificationExecutor<Trade>{
	
	public Trade  findByDesignation(@Param("designation") String designation);
	
	@Query("select t from Trade t where t.latitude = :latitude AND t.longitude = :longitude")
	public Trade findOnPosition (@Param("latitude") double latitude, @Param("longitude") double longitude);

}
