package com.myproject.parking.lib.mapper;

import java.util.List;

import com.myproject.parking.lib.entity.Mall;
import com.myproject.parking.lib.entity.MallSlotAvailable;

public interface MallMapper {
	
	public List<Mall> findAllMall();
	
	public List<MallSlotAvailable> findSlotAvailablePerMall();
}
