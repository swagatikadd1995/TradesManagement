package com.simpragma.management.util;

import java.math.BigDecimal;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import com.simpragma.management.dto.TradeDto;
import com.simpragma.management.exception.InputValidationException;

public class ValidationUtils {
	
	private static final String TYPE_BUY = "buy";
	private static final String TYPE_SELL = "sell";
	
	private static final BigDecimal MIN_PRICE = new BigDecimal("130.42");
	private static final BigDecimal MAX_PRICE = new BigDecimal("195.65");
	
	public static void validate(TradeDto tradeDto) {
		
		if(ObjectUtils.isEmpty(tradeDto)) throw new InputValidationException("Request body is missing");
		
		validateStockType(tradeDto.getTradeType());
		
		if(tradeDto.getTradeShares() < 10 && tradeDto.getTradeShares() > 30)
			throw new InputValidationException("The traded shares value is between 10 and 30 shares, inclusive.");
		
		if(!((MIN_PRICE.compareTo(tradeDto.getTradePrice()) == 0 || MIN_PRICE.compareTo(tradeDto.getTradePrice()) == 1)
				&& (MAX_PRICE.compareTo(tradeDto.getTradePrice()) == 0 || MAX_PRICE.compareTo(tradeDto.getTradePrice()) == -1)))
			throw new InputValidationException("The stock price is between 130.42 and 195.65 inclusive.");
		
		if(tradeDto.getUser() == null) throw new InputValidationException("User Id and name must required.");
		
		if(tradeDto.getUser().getUserId() < 1 || StringUtils.isNotBlank(tradeDto.getUser().getUserName()))
			throw new InputValidationException("User Id or name can't be empty");
			
	}
	

	public static void validateStockQuery(String stockSymbol, String type) {
		if(StringUtils.isBlank(stockSymbol)) throw new InputValidationException("The stock symbol can't be blank");
		
		validateStockType(type);
	}
	
	//Validating the stock type either be buy or sell
	private static void validateStockType(String type) {
		if (!(type.equalsIgnoreCase(TYPE_BUY) || type.equalsIgnoreCase(TYPE_SELL)))
			throw new InputValidationException("The trade type, either buy or sell.");
	}

}
