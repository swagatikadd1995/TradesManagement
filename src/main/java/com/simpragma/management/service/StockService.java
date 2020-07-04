package com.simpragma.management.service;

import java.sql.Timestamp;
import java.util.List;

import com.simpragma.management.dto.TradeDto;
import com.simpragma.management.dto.TradePriceDto;

public interface StockService {

	public List<TradeDto> getTradeBySymbolType(String stockSymbol, String type, Timestamp start, Timestamp end);

	public TradePriceDto getTradePrice(String stockSymbol, Timestamp start, Timestamp end);

}
