package com.emobile.smis.web.fincore.mapper;

import java.util.List;

import com.emobile.smis.web.data.param.ReportParamVO;
import com.emobile.smis.web.data.report.InisiasiDealerVO;

public interface InisiasiDealerMapper {
	
	public List<InisiasiDealerVO> findInisiasiDealerByBranchCode(ReportParamVO paramVO);
	
}
