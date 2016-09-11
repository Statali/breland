package org.server.localshop.services;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.server.localshop.domain.Place;
import org.server.localshop.repositoryclasses.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;

@Service
public class PlacesService {

	final PlaceRepository placeJpa;


	@Autowired
	public PlacesService( final PlaceRepository placeJpa ){
		this.placeJpa = placeJpa;
	}

	public  void createPlace(String jSonParameters){		
		try {
			Place place = Place.fromJson(new JSONObject(jSonParameters));
			SimpleDateFormat  df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			place.setCreatedDate(df.format(new Date()));
			place.setUpdatedDate(df.format(new Date()));
			this.placeJpa.save(place);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}


}
