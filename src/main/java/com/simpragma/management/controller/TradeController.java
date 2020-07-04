package com.simpragma.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpragma.management.dto.TradeDto;
import com.simpragma.management.exception.InputValidationException;
import com.simpragma.management.service.TradeService;
import com.simpragma.management.util.ValidationUtils;

@RestController
@RequestMapping("/trade")
public class TradeController {
	
	private static final Logger log = LoggerFactory.getLogger(TradeService.class);
	
	@Autowired
	TradeService tradeservice;
	
	
	@GetMapping
	public ResponseEntity<List<TradeDto>> getAllTrade() {
		log.info("Entering into TradeController.getAllTrade() ");
		return new ResponseEntity<List<TradeDto>>(tradeservice.getAllTrade(), HttpStatus.OK);
	}

	@GetMapping("/users/{userID}")
	public ResponseEntity<List<TradeDto>> getTradeByUserId(@PathVariable("userID") int userID) {
		log.info("Entering into TradeController.getTradeById() ");
		
		if(userID < 1) throw new InputValidationException("User ID can't be -ve number");
		
		return new ResponseEntity<List<TradeDto>>(tradeservice.getTradeByUserId(userID), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TradeDto> createTrade(@RequestBody TradeDto tradeDto) {
		log.info("Entering into TradeController.createTrade() ");
		
		ValidationUtils.validate(tradeDto);
		
		return new ResponseEntity<TradeDto>(tradeservice.createTrade(tradeDto), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteTrade() {
		log.info("Entering into TradeController.deleteTrade() ");
		return new ResponseEntity<String>(tradeservice.deleteTrade(), HttpStatus.OK);
	}



}
