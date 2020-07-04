package com.simpragma.management.controller;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simpragma.management.dto.TradeDto;
import com.simpragma.management.dto.TradePriceDto;
import com.simpragma.management.exception.InputValidationException;
import com.simpragma.management.service.StockService;
import com.simpragma.management.util.ValidationUtils;

@RestController
@RequestMapping("/stocks")
public class StockController {

	private static final Logger log = LoggerFactory.getLogger(StockController.class);

	@Autowired
	StockService stockService;

	@GetMapping("/{stockSymbol}/trades")
	public ResponseEntity<List<TradeDto>> getTradeBySymbolType(@PathVariable(name = "stockSymbol") String stockSymbol,
			@RequestParam(name = "type") String type, @RequestParam(name = "start") Timestamp start,
			@RequestParam(name = "end") Timestamp end) {
		log.info("Entering into TradeController.getTradeBySymbolType()");
	
		ValidationUtils.validateStockQuery(stockSymbol, type);
		
		return new ResponseEntity<List<TradeDto>>(stockService.getTradeBySymbolType(stockSymbol, type, start, end),
				HttpStatus.OK);
	}

	@GetMapping("/{stockSymbol}/price")
	public ResponseEntity<TradePriceDto> getTradePrice(@PathVariable(name = "stockSymbol") String stockSymbol,
			@RequestParam(name = "start") Timestamp start, @RequestParam(name = "end") Timestamp end) {
		log.info("Entering into TradeController.getTradePrice()");
		
		if(StringUtils.isBlank(stockSymbol)) throw new InputValidationException("The stock symbol can't be blank");
		
		return new ResponseEntity<TradePriceDto>(stockService.getTradePrice(stockSymbol, start, end), HttpStatus.OK);
	}

}
