package org.server.localshop.services;


import org.server.localshop.domain.Response;
import org.server.localshop.domain.Trade;
import org.server.localshop.repositoryclasses.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService {

	private final TradeRepository tradeRepository;
	private final DateTime dateTime;

	@Autowired
	public TradeService( final TradeRepository tradeRepository,  final DateTime dateTime){
		this.tradeRepository = tradeRepository;
		this.dateTime = dateTime;
	}	
	
	public Response<Trade>  createTrade(Trade trade){
		Response<Trade> result = new Response<Trade>();
		if (trade.getId() != null ) {
			result.getException().add((new IllegalArgumentException("trade.with.already.exist")));
		}
		else{
			if(this.tradeRepository.findByDesignation(trade.getNearestShopName()) != null) {
				result.getException().add((new IllegalArgumentException("trade.with.designation.exist")));
			}
			else{
				if(this.tradeRepository.findOnPosition(trade.getLatitude(), trade.getLongitude()) != null) {
					result.getException().add((new IllegalArgumentException("trade.exist.with.same.position")));
				}
				else{
					trade.setCreatedDate(this.dateTime.getCurrentDateTime());
					trade.setUpdatedDate(this.dateTime.getCurrentDateTime());
					trade = this.tradeRepository.save(trade);
					result.setObject(trade);
				}
			}
		}
		return result;
	}
	
	public Response<Trade> updateTrade( Trade trade){
		Response<Trade> result = new Response<Trade>();
		if (!this.tradeRepository.exists(trade.getId())) {
			result.getException().add((new IllegalArgumentException("trade.with.id.noexist")));
		}
		else{
			trade.setUpdatedDate(this.dateTime.getCurrentDateTime());			
			trade = this.tradeRepository.save(trade);
			result.setObject(trade);
		}
		return result;
	}

	



}
