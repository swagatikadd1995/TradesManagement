package com.simpragma.management.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpragma.management.dto.TradeDto;
import com.simpragma.management.dto.TradePriceDto;
import com.simpragma.management.dto.UserDto;
import com.simpragma.management.entity.TradeEntity;
import com.simpragma.management.exception.InvalidDataServiceException;
import com.simpragma.management.repository.TradeRepository;
import com.simpragma.management.repository.UserRepository;
import com.simpragma.management.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	private static final Logger log = LoggerFactory.getLogger(StockServiceImpl.class);

	@Autowired
	TradeRepository tradeRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public List<TradeDto> getTradeBySymbolType(String stockSymbol, String type, Timestamp start, Timestamp end) {
		log.info("Entering into TradeService.getTradeBySymbolType()");
		if (!tradeRepository.existsByTradeSymbol(stockSymbol)) {
			throw new InvalidDataServiceException("Invalid stockSymbol");
		}
		TradeDto tradeDto = null;
		UserDto userDto = new UserDto();
		List<TradeDto> tradeDtos = new ArrayList<TradeDto>();
		List<TradeEntity> tradeEntities = tradeRepository.findByTradeSymbolAndTradeType(stockSymbol, type);
		for (TradeEntity obj : tradeEntities) {
			tradeDto = new TradeDto();
			tradeDto.setTradeId(obj.getTradeId());
			tradeDto.setTradePrice(obj.getTradePrice());
			tradeDto.setTradeShares(obj.getTradeShares());
			tradeDto.setTradeSymbol(obj.getTradeSymbol());
			tradeDto.setTradeType(obj.getTradeType());
			tradeDto.setTradeTimestamp(obj.getTradeTimestamp());
			userDto.setUserId(obj.getUserEntity().getUserId());
			userDto.setUserName(obj.getUserEntity().getUserName());
			tradeDto.setUser(userDto);
			tradeDtos.add(tradeDto);

		}

		Collections.sort(tradeDtos);
		log.info("Exiting from TradeService.getTradeBySymbolType()");
		return tradeDtos;

	}

	@Override
	public TradePriceDto getTradePrice(String stockSymbol, Timestamp start, Timestamp end) {
		log.info("Entering into TradeService.getTradePrice()");
		if (!tradeRepository.existsByTradeSymbol(stockSymbol)) {
			throw new InvalidDataServiceException("Invalid stockSymbol");
		}

		List<TradeEntity> tradeEntities = tradeRepository.findByTradeSymbolAndTradeTimestampBetween(stockSymbol, start,
				end);
		TradePriceDto tradePriceDto = new TradePriceDto();
		BigDecimal min = tradeEntities.stream().map(TradeEntity::getTradePrice).min(Comparator.naturalOrder())
				.orElse(BigDecimal.ZERO);
		BigDecimal max = tradeEntities.stream().map(TradeEntity::getTradePrice).max(Comparator.naturalOrder())
				.orElse(BigDecimal.ZERO);

		tradePriceDto.setHighestPrice(max);
		tradePriceDto.setLowestPrice(min);
		tradePriceDto.setSymbol(stockSymbol);
		log.info("Exiting from TradeService.getTradePrice()");
		return tradePriceDto;
	}

}
