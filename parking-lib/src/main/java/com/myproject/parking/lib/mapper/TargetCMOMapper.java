package com.emobile.smis.web.mapper;

import java.util.List;

import com.emobile.smis.web.data.TargetCMODataVO;
import com.emobile.smis.web.data.param.TargetCMOParamVO;
import com.emobile.smis.web.entity.TargetCMODetail;
import com.emobile.smis.web.entity.TargetCMOHeader;
import com.emobile.smis.web.entity.UserData;

public interface TargetCMOMapper {
	public TargetCMODataVO getJoinIdAndDealerShowroomIdByJoinId(String joinId);
	
	public void createTargetCMOHeader(TargetCMOHeader targetCMOHeader);
	public void createTargetCMODetail(TargetCMODetail targetCMODetail);
	
	public void updateTargetCMOHeader(TargetCMOHeader targetCMOHeader);
	
	public void deleteTargetCMODetail(int headerId);
	
	public int countTargetCMO(TargetCMOParamVO targetCMOParamVO);
	public List<TargetCMODataVO> findListTargetCMOByParamVO(TargetCMOParamVO targetCMOParamVO);
	
	public TargetCMOHeader findTargetCMOHeaderById(int id);
	
	public TargetCMOHeader checkDuplicateTargetCMOByCMOIdAndDealerId(TargetCMOParamVO targetCMOParamVO);
	
	public List<UserData> findUserCMOByBranchCode(String branchCode);
}
