package com.simpragma.management.service;

import java.util.List;

import com.simpragma.management.dto.TradeDto;

public interface TradeService {

	public List<TradeDto> getAllTrade();

	public TradeDto createTrade(final TradeDto tradeDto);

	public String deleteTrade();

	public List<TradeDto> getTradeByUserId(final int userID);

}
