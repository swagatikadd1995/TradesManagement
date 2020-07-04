package com.simpragma.management.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TradeDto implements Comparable<TradeDto>, Serializable {

	private static final long serialVersionUID = 292370007640317080L;

	private int tradeId;
	private String tradeType;
	private UserDto user;
	private String tradeSymbol;
	private int tradeShares;
	private BigDecimal tradePrice;
	private Timestamp tradeTimestamp;

	@JsonProperty("id")
	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	@JsonProperty("type")
	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	@JsonProperty("user")
	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	@JsonProperty("symbol")
	public String getTradeSymbol() {
		return tradeSymbol;
	}

	public void setTradeSymbol(String tradeSymbol) {
		this.tradeSymbol = tradeSymbol;
	}

	@JsonProperty("shares")
	public int getTradeShares() {
		return tradeShares;
	}

	public void setTradeShares(int tradeShares) {
		this.tradeShares = tradeShares;
	}

	@JsonProperty("price")
	public BigDecimal getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(BigDecimal tradePrice) {
		this.tradePrice = tradePrice;
	}

	@JsonProperty("timestamp")
	public Timestamp getTradeTimestamp() {
		return tradeTimestamp;
	}

	public void setTradeTimestamp(Timestamp tradeTimestamp) {
		this.tradeTimestamp = tradeTimestamp;
	}

	@Override
	public int compareTo(TradeDto o) {
		if (this.tradeId < o.tradeId) {
			return -1;
		} else if (this.tradeId > o.tradeId) {
			return 1;
		} else {
			return 0;
		}

	}

}
