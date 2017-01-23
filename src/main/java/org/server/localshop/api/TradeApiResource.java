package org.server.localshop.api;

import org.server.localshop.domain.Response;
import org.server.localshop.domain.Trade;
import org.server.localshop.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TradeApiResource {

	private final TradeService tradeService;

	@Autowired
	public TradeApiResource(final TradeService tradeService){
		this.tradeService = tradeService;
	}	
	
		
	@ResponseBody
	@RequestMapping(value = "/trades/", method = RequestMethod.POST)
	public Response<Trade> createTrade(@RequestBody Trade trade){
		return this.tradeService.createTrade(trade);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/trades/", method = RequestMethod.PUT)
    public Response<Trade> updateTrade(@RequestBody Trade trade) {
		return this.tradeService.updateTrade(trade);
	}
}
