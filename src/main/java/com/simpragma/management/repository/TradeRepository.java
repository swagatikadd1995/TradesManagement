package com.simpragma.management.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpragma.management.entity.TradeEntity;


public interface TradeRepository extends JpaRepository<TradeEntity, Integer> {

	List<TradeEntity> findByUserUserId(int userId);
	Boolean  existsByTradeSymbol(String tradeSymbol);
	List<TradeEntity> findByTradeSymbolAndTradeType(String tradeSymbol,String tradeType);
	List<TradeEntity> findByTradeSymbolAndTradeTimestampBetween(String tradeSymbol,Timestamp start, Timestamp end);
	
}
