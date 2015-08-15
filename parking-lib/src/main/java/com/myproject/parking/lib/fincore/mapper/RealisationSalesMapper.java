package com.emobile.smis.web.fincore.mapper;

import java.util.List;
import com.emobile.smis.web.data.report.ReportSalesPotentionVO;

public interface RealisationSalesMapper {

	public List<ReportSalesPotentionVO> findAllRealisationSales();
	
	public List<ReportSalesPotentionVO> findRealisationSalesByBranchCode(String branchCode);
	
}
