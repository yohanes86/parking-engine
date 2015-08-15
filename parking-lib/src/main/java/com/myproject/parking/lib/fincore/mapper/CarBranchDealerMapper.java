package com.emobile.smis.web.fincore.mapper;

import java.util.List;

import com.emobile.smis.web.data.param.DealerShowroomParamVO;
import com.emobile.smis.web.entity.CarBranchDealer;
import com.emobile.smis.web.entity.DealerShowroom;

public interface CarBranchDealerMapper {

	int countDealerShowroomByParamForJoin(DealerShowroomParamVO dealerShowroomParamVO);

	List<CarBranchDealer> findDealerShowroomByParamForJoin(DealerShowroomParamVO dealerShowroomParamVO);
	
	int countDealerShowroomByParamForInput(DealerShowroomParamVO dealerShowroomParamVO);
	
	List<CarBranchDealer> findDealerShowroomByParamForInput(DealerShowroomParamVO dealerShowroomParamVO);

	DealerShowroom getDealerShowroomByParamForJoin(DealerShowroomParamVO dealerShowroomParamVO);

	DealerShowroom findDealerShowroomByIdForJoin(String dealerId);
	
}
