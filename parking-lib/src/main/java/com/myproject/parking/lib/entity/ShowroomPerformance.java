package com.emobile.smis.web.entity;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.emobile.smis.web.data.SalesPerformanceVO;

public class ShowroomPerformance extends Visit implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private int visitId; //dealer showroom id/CMO
	private int initiateStock;
	private int lastStock;
	private double buy;
	private double realPotensial;
	
	private String initiateStockStr;
	private String lastStockStr;
	private String buyStr;
	private String realPotensialStr;
	
	private List<SalesPerformanceVO> listSalesPerformanceVO;
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public int getVisitId() {
		return visitId;
	}
	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}
	public int getInitiateStock() {
		return initiateStock;
	}
	public void setInitiateStock(int initiateStock) {
		this.initiateStock = initiateStock;
	}
	public int getLastStock() {
		return lastStock;
	}
	public void setLastStock(int lastStock) {
		this.lastStock = lastStock;
	}
	public double getBuy() {
		return buy;
	}
	public void setBuy(double buy) {
		this.buy = buy;
	}
	public double getRealPotensial() {
		return realPotensial;
	}
	public void setRealPotensial(double realPotensial) {
		this.realPotensial = realPotensial;
	}

	
	public String getRealPotensialStr() {
		if(!StringUtils.isEmpty(realPotensialStr)){
			setRealPotensial(Double.parseDouble(realPotensialStr));
		}
		return realPotensialStr;
	}

	public void setRealPotensialStr(String realPotensialStr) {
		this.realPotensialStr = realPotensialStr;
	}

	public String getInitiateStockStr() {
		if(!StringUtils.isEmpty(initiateStockStr)){
			setInitiateStock(Integer.parseInt(initiateStockStr));
		}
		return initiateStockStr;
	}

	public void setInitiateStockStr(String initiateStockStr) {
		this.initiateStockStr = initiateStockStr;
	}

	public String getLastStockStr() {
		if(!StringUtils.isEmpty(lastStockStr)){
			setLastStock(Integer.parseInt(lastStockStr));
		}
		return lastStockStr;
	}

	public void setLastStockStr(String lastStockStr) {
		this.lastStockStr = lastStockStr;
	}

	public String getBuyStr() {
		if(!StringUtils.isEmpty(buyStr)){
			setBuy(Double.parseDouble(buyStr));
		}
		return buyStr;
	}

	public void setBuyStr(String buyStr) {
		this.buyStr = buyStr;
	}

	public List<SalesPerformanceVO> getListSalesPerformanceVO() {
		return listSalesPerformanceVO;
	}

	public void setListSalesPerformanceVO(
			List<SalesPerformanceVO> listSalesPerformanceVO) {
		this.listSalesPerformanceVO = listSalesPerformanceVO;
	}

	
}
