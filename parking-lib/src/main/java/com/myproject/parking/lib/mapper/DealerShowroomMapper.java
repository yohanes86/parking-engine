package com.emobile.smis.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.emobile.smis.web.data.NotifDealerShowroomVO;
import com.emobile.smis.web.data.param.DealerShowroomParamVO;
import com.emobile.smis.web.entity.Branch;
import com.emobile.smis.web.entity.DealerShowroom;
import com.emobile.smis.web.entity.DealerShowroomNotRegister;
import com.emobile.smis.web.entity.TesSigma;
import com.emobile.smis.web.entity.Visit;

public interface DealerShowroomMapper {
	public void createDealerShowroom(DealerShowroom dealerShowroom);
	public void updateDealerShowroom(DealerShowroom dealerShowroom);

	public List<TesSigma> findAllDealaerShowroom();
	public DealerShowroom getDealerShowroomById(@Param("dealerShowroomId") int dealerShowroomId, @Param("status") int status);
	public DealerShowroom getDealerShowroomByJoinId(String joinId);
	public List<DealerShowroom> findDealerShowroomByName(String name);
	public List<DealerShowroom> findDealerShowroomByParam(Visit visit);
	public int countDealerShowroomByName(String name);
	public int countDealerShowroomByParam(Visit visit);
	public void insertDealerShowroomNotRegister(DealerShowroomNotRegister data);
	public List<DealerShowroom> findDealerShowroomRegisterByParam(DealerShowroomParamVO dealerShowroomParamVO);
	
	public List<DealerShowroom> findDealerByBranchCode(String branchCode);
	
	public List<DealerShowroom> findDealerByIdUserLogin(int userDataId);
	public Branch sortingListCardBranchDealerByBranchCode(DealerShowroomParamVO dealerShowroomParamVO);
	public DealerShowroom checkProductIdDealerShowroom(DealerShowroomParamVO dealerShowroomParamVO);
	
	public int countNotifDealerShowroomNeedUpdated(DealerShowroomParamVO params);
	public List<NotifDealerShowroomVO> findListDealerShowroomNeedUpdated(DealerShowroomParamVO params);
}
