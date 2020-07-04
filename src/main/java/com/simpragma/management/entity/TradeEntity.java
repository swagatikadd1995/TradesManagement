package com.simpragma.management.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "trade")
public class TradeEntity implements Serializable {

	private static final long serialVersionUID = 5249441971311300744L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trade_id")
	private int tradeId;
	
	@Column(name="trade_type")
	private String tradeType;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnore
	private UserEntity user;
	
	@Column(name="trade_symbol")
	private String tradeSymbol;
	
	@Column(name="trade_shares")
	private int tradeShares;
	
	@Column(name="trade_price" )
	private BigDecimal tradePrice;
	
	@Column(name="trade_timestamp")
	private Timestamp tradeTimestamp;

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public UserEntity getUserEntity() {
		return user;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.user = userEntity;
	}

	public String getTradeSymbol() {
		return tradeSymbol;
	}

	public void setTradeSymbol(String tradeSymbol) {
		this.tradeSymbol = tradeSymbol;
	}

	public int getTradeShares() {
		return tradeShares;
	}

	public void setTradeShares(int tradeShares) {
		this.tradeShares = tradeShares;
	}

	public BigDecimal getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(BigDecimal tradePrice) {
		this.tradePrice = tradePrice;
	}

	public Timestamp getTradeTimestamp() {
		return tradeTimestamp;
	}

	public void setTradeTimestamp(Timestamp tradeTimestamp) {
		this.tradeTimestamp = tradeTimestamp;
	}

}
