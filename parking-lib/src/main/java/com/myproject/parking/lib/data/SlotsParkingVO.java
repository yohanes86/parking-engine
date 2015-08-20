package com.myproject.parking.lib.data;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.myproject.parking.lib.entity.Mall;
import com.myproject.parking.lib.entity.MallSlots;

public class SlotsParkingVO extends LoginData implements Serializable {
	private static final long serialVersionUID = 1L;

	private Mall mall;
	private MallSlots mallSlots;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public Mall getMall() {
		return mall;
	}

	public void setMall(Mall mall) {
		this.mall = mall;
	}

	public MallSlots getMallSlots() {
		return mallSlots;
	}

	public void setMallSlots(MallSlots mallSlots) {
		this.mallSlots = mallSlots;
	}

	
}
