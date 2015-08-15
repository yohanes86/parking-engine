package com.emobile.smis.web.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.emobile.smis.web.data.VisitCMODataVO;
import com.emobile.smis.web.entity.DataCompetitor;
import com.emobile.smis.web.entity.ExtVisitRM;
import com.emobile.smis.web.entity.PersonInCharge;
import com.emobile.smis.web.entity.SalesPerformance;
import com.emobile.smis.web.entity.ShowroomPerformance;
import com.emobile.smis.web.entity.Visit;
import com.emobile.smis.web.entity.VisitBmDataCompetitor;
import com.emobile.smis.web.entity.VisitBmMeetPic;
import com.emobile.smis.web.entity.VisitBmReportAdviceSales;
import com.emobile.smis.web.entity.VisitBmVehicleStock;


public interface VisitMapper {
	
	public Visit findLastVisitDealerShowroom();	
	public void insertVisitCommons(Visit visit);
	public void updateVisitCommons(Visit visit);
	public PersonInCharge insertMetPicVisit(@Param("visitId") int visitId, @Param("picId") int picId);
	public void insertVisitExtRM(ExtVisitRM extVisitRm);
	public void updateVisitExtRM(ExtVisitRM extVisitRm);
	public void insertVisitCMOShowroomPerformance(ShowroomPerformance showroomPerformance);
	public void insertVisitCMOSalesPerformance(SalesPerformance salesPerformance);
	public void insertVisitCMODataCompetitor(DataCompetitor dataCompetitor);
	public void insertVisitBMDataCompetitor(VisitBmDataCompetitor visitBmDataCompetitor);
	public void insertVisitBmPersonInCharge(VisitBmMeetPic visitBmMeetPic);
	public void insertVisitBmReportAdviceSales(VisitBmReportAdviceSales visitBmReportAdviceSales);
	public void insertVisitBmVehicleStock(VisitBmVehicleStock visitBmVehicleStock);
	public void insertVisitBmVehicleStockLife(VisitBmVehicleStock visitBmVehicleStock);
	public void insertVisitBmVehicleStockMerk(VisitBmVehicleStock visitBmVehicleStock);
	public void insertVisitBmVehicleStockOtr(VisitBmVehicleStock visitBmVehicleStock);
	
	
	public List<ExtVisitRM> findVisitRmByParam(ExtVisitRM param);
	public ExtVisitRM findVisitRmById(int visitId);
	public int countFindVisitRmByParam(ExtVisitRM param);
	
	public List<VisitCMODataVO> findVisitCMOByparam(Visit visit);
	public int countFindVisitCMOByParam(Visit visit);
	
	public ShowroomPerformance findShowroomByVisitId(int visitId);
	
	public void updateVisitCMOShowroomPerformance(ShowroomPerformance showroomPerformance);
	public void deleteVisitCMOSalesPerformance(int visitCMOId);
	public void deleteVisitCMODataCompetitor(int salesPerformanceId);
	
	public List<ExtVisitRM> findVisitBmByParam(ExtVisitRM param);
	public ExtVisitRM findVisitBmById(int visitId);
	public int countVisitBmByParam(ExtVisitRM param);
	
	public List<VisitBmDataCompetitor> findVisitBmDataCompetitorByVisitId(int visitId);
	public List<VisitBmMeetPic> findVisitBmMeetPicByVisitId(int visitId);
	public VisitBmVehicleStock findVisitBmVehicleStockTotalByVisitId(int visitId);
	public List<VisitBmVehicleStock> findVisitBmVehicleStockOtrByVisitId(int visitId);
	public List<VisitBmVehicleStock> findVisitBmVehicleStockAgeByVisitId(int visitId);
	public List<VisitBmVehicleStock> findVisitBmVehicleStockMerkByVisitId(int visitId);
	public VisitBmReportAdviceSales findVisitBmReportAdviceSalesByVisitId(int visitId);
}
