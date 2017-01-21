package org.server.localshop.services;


import org.server.localshop.domain.Trade;
import org.server.localshop.exception.BonwaysNotFoundException;
import org.server.localshop.repositoryclasses.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class TradeService {

	private final TradeRepository sellerRepository;
	private final PlacesService placeService;

	@Autowired
	public TradeService( final TradeRepository sellerRepository, final PlacesService placeService){
		this.sellerRepository = sellerRepository;
		this.placeService =  placeService;
	}	


	public int createSeller (String jSonParameters){
		Trade seller;
		try {
			seller = Trade.fromJson(new JSONObject(jSonParameters));
			seller = this.sellerRepository.save(seller);
			this.placeService.createPlace(jSonParameters);
			return seller.getTraderId();
		} catch (JSONException e) {
			e.printStackTrace();
			return -1;
		}

	}

	public String getSellerById(Long idSeller){
		String result = null;
		Gson gson = new Gson();		
		Trade seller = this.sellerRepository.findOne(idSeller);
		if(seller != null){
			result  = gson.toJson(seller,Trade.class);
		}
		else{
			//throw new BonwaysNotFoundException("seller", idSeller);
		}
		return result;
	}




}
