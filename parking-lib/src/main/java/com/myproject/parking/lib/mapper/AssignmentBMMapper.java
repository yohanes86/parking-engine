package com.emobile.smis.web.mapper;

import java.util.List;

import com.emobile.smis.web.data.AssignmentVO;
import com.emobile.smis.web.data.param.AssignmentParamVO;
import com.emobile.smis.web.entity.Assignment;
import com.emobile.smis.web.entity.Branch;
import com.emobile.smis.web.entity.DealerShowroom;
import com.emobile.smis.web.entity.UserData;

public interface AssignmentBMMapper {
	public List<DealerShowroom> findDealerByBranchCode(String branchCode);
	
	public void createAssignment(Assignment assignment);
	
	public void updateAssignment(Assignment assignment);
	
	public Branch findBranchByBranchCode(String branchCode);
	
	public Branch findBranchById(int branchId);
	
	public List<UserData> findAssignedUserBMByBranchId(int branchId);
	
	public List<Assignment> checkDatePeriodAssignment(Assignment assignment);
	
	public int countAssignmentBM(AssignmentParamVO assignmentBMParamVO);
	
	public List<AssignmentVO> findAssignmentBMByParamVO(AssignmentParamVO assignmentBMParamVO);
	
	public Assignment findAssignmentById(int assignmentId);
	
	public Assignment findAssignmentByDatetimeAndAssignTo(AssignmentParamVO assignmentParamVO);
	
	/**
	 *  list notification assignment visit
	 */
	public int countNotifAssignmentVisit(AssignmentParamVO assignmentBMParamVO);
	
	public List<AssignmentVO> findListNotifAssignmentVisit(AssignmentParamVO assignmentBMParamVO);
	
	public int countNotifAssignmentVisitExpired(AssignmentParamVO assignmentBMParamVO);
	
	public List<AssignmentVO> findListNotifAssignmentVisitExpired(AssignmentParamVO assignmentBMParamVO);
}
