package com.emobile.smis.web.mapper;

import java.util.List;

import com.emobile.smis.web.data.AssignmentVO;
import com.emobile.smis.web.data.param.AssignmentParamVO;
import com.emobile.smis.web.entity.DealerShowroom;
import com.emobile.smis.web.entity.PersonInCharge;
import com.emobile.smis.web.entity.UserData;

public interface AssignmentCMOMapper {
	public List<UserData> findUserCMOByUserId(int userId);
	
	public List<DealerShowroom> findDealerByIdUserLogin(int userId);
	
	public List<PersonInCharge> findPersonInChargeByDealerId(int dealerId);
	
	public int countAssignmentCMO(AssignmentParamVO assignmentBMParamVO);
	
	public List<AssignmentVO> findAssignmentCMOByParamVO(AssignmentParamVO assignmentBMParamVO);
}
