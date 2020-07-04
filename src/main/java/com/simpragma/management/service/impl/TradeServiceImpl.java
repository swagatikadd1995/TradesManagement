package com.simpragma.management.service.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpragma.management.dto.TradeDto;
import com.simpragma.management.entity.TradeEntity;
import com.simpragma.management.entity.UserEntity;
import com.simpragma.management.exception.DataServiceException;
import com.simpragma.management.exception.InvalidDataServiceException;
import com.simpragma.management.repository.TradeRepository;
import com.simpragma.management.repository.UserRepository;
import com.simpragma.management.service.TradeService;
import com.simpragma.management.util.TradeCoreUtil;

@Service
public class TradeServiceImpl implements TradeService {

	private static final Logger log = LoggerFactory.getLogger(TradeService.class);

	@Autowired
	TradeRepository tradeRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TradeCoreUtil tradeCoreUtil;

	@Override
	public List<TradeDto> getAllTrade() {
		log.info("Entering into TradeService.getAllTrade() ");
		try {
			List<TradeEntity> tradeEntityList = tradeRepository.findAll();
			List<TradeDto> tradeDtos = tradeCoreUtil.copyTradeEntityToDto(tradeEntityList);
			Collections.sort(tradeDtos);
			return tradeDtos;
		} catch (Exception e) {
			e.printStackTrace(); // TODO : For Development log.
			log.error("Failed to get all record from trade data base");
			throw new DataServiceException("Unable to get trade records from DB");
		}

	}

	@Override
	public TradeDto createTrade(TradeDto tradeDto) {
		log.info("Entering into TradeService.createTrade() ");
		UserEntity userEntity = null;
		if (tradeDto.getUser() != null) {
			userEntity = userRepository.findByUserIdAndUserName(tradeDto.getUser().getUserId(),
					tradeDto.getUser().getUserName());
			if (userEntity == null)
				throw new InvalidDataServiceException("Invalid Data ");

		}

		TradeEntity tradeEntity = tradeCoreUtil.copyTradeEntityToDto(tradeDto);
		tradeRepository.save(tradeEntity);
		log.info("Exiting into TradeService.createTrade() ");

		return tradeDto;

	}

	@Override
	public String deleteTrade() {
		log.info("Entering into TradeService.deleteTrade() ");
		try {
			tradeRepository.deleteAll();
			log.info("Exiting into TradeService.deleteTrade() ");
			return "Sucessfully Deleted";

		} catch (Exception e) {
			log.error("Failed to Delete trade records " + e.getMessage());
			throw new DataServiceException("Trade Deletion Failed");
		}
	}

	@Override
	public List<TradeDto> getTradeByUserId(int userID) {
		log.info("Entering into TradeService.getTradeByUserId() ");

		if (!userRepository.existsById(userID)) {
			throw new InvalidDataServiceException("Invalid User ID ");
		}

		List<TradeEntity> tradeEntity = tradeRepository.findByUserUserId(userID);

		List<TradeDto> tradeDtos = tradeCoreUtil.copyTradeEntityToDto(tradeEntity);

		Collections.sort(tradeDtos);

		return tradeDtos;
	}

}
