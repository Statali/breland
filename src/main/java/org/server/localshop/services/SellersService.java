package org.server.localshop.services;


import org.server.localshop.domain.Seller;
import org.server.localshop.repositoryclasses.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;

@Service
public class SellersService {

	private final SellerRepository sellerRepository;
	private final PlacesService placeService;

	@Autowired
	public SellersService( final SellerRepository sellerRepository, final PlacesService placeService){
		this.sellerRepository = sellerRepository;
		this.placeService =  placeService;
	}	


	public int createSeller (String jSonParameters){
		Seller seller;
		try {
			seller = Seller.fromJson(new JSONObject(jSonParameters));
			seller = this.sellerRepository.save(seller);
			this.placeService.createPlace(jSonParameters);
			return seller.getSellerId();
		} catch (JSONException e) {
			e.printStackTrace();
			return -1;
		}

	}




}
