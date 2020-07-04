package com.simpragma.management.util;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.simpragma.management.dto.TradeDto;
import com.simpragma.management.dto.UserDto;
import com.simpragma.management.entity.TradeEntity;
import com.simpragma.management.entity.UserEntity;

@Component
public class TradeCoreUtil {
	
	
	public static Timestamp getCurrentTimeInUtc() {
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		return Timestamp.valueOf(zonedDateTime.toLocalDateTime());
	}
	
	public List<TradeDto> copyTradeEntityToDto(final List<TradeEntity> tradeEntityList){
		
		List<TradeDto> tradeDtoList = new ArrayList<>();
		TradeDto tradeDto = null;
		UserDto userDto = null;
		
		for (TradeEntity tradeEntity : tradeEntityList) {
			tradeDto = new TradeDto();
			
			tradeDto.setTradeId(tradeEntity.getTradeId());
			tradeDto.setTradePrice(tradeEntity.getTradePrice());
			tradeDto.setTradeShares(tradeEntity.getTradeShares());
			tradeDto.setTradeSymbol(tradeEntity.getTradeSymbol());
			tradeDto.setTradeType(tradeEntity.getTradeType());
			tradeDto.setTradeTimestamp(tradeEntity.getTradeTimestamp());
			if(tradeEntity.getUserEntity() != null) {
				userDto = new UserDto();
				userDto.setUserId(tradeEntity.getUserEntity().getUserId());
				userDto.setUserName(tradeEntity.getUserEntity().getUserName());
				tradeDto.setUser(userDto);
			}
			
			tradeDtoList.add(tradeDto);
		}
		return tradeDtoList;
	} 
	
	
	public TradeEntity copyTradeEntityToDto(final TradeDto tradeDto) {
		
		TradeEntity tradeEntity = new TradeEntity();
		UserEntity userEntity = new UserEntity();
		
		if (tradeDto.getUser() != null) {
			userEntity.setUserId(tradeDto.getUser().getUserId());
			userEntity.setUserName(tradeDto.getUser().getUserName());
		}
		
		tradeEntity.setTradeId(tradeDto.getTradeId());
		tradeEntity.setTradePrice(tradeDto.getTradePrice());
		tradeEntity.setTradeShares(tradeDto.getTradeShares());
		tradeEntity.setTradeSymbol(tradeDto.getTradeSymbol());
		tradeEntity.setTradeType(tradeDto.getTradeType());
		tradeEntity.setUserEntity(userEntity);
		tradeEntity.setTradeTimestamp(TradeCoreUtil.getCurrentTimeInUtc());
		
		return tradeEntity;

	}
}
