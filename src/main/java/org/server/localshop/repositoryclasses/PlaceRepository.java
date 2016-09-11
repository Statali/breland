package org.server.localshop.repositoryclasses;

import org.server.localshop.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PlaceRepository extends JpaRepository<Place, Long>{

}
