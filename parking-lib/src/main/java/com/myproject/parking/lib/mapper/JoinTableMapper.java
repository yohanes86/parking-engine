package com.emobile.smis.web.mapper;

import java.util.List;

import com.emobile.smis.web.data.param.DealerShowroomParamVO;
import com.emobile.smis.web.entity.DealerShowroom;
import com.emobile.smis.web.entity.JoinTable;


public interface JoinTableMapper {
	
	public JoinTable findLastJoinTable();

	public void createJoinTable(JoinTable joinTable);
	
	public void updateJoinTable(JoinTable joinTable);

	public void deleteJoinTable(String joinId);

	public List<JoinTable> findDealerShowroomByJoinId(String joinId);

	public JoinTable findDealerShowroomByDealerShowroomId(String dealerShowroomId);

	public List<JoinTable> findDealaerShowroomNotRegister();

	public List<JoinTable> findJoinTableByParam(DealerShowroomParamVO dealerShowroomParamVO);
	
	public List<DealerShowroom> findJoinTableByParamVO(DealerShowroomParamVO dealerShowroomParamVO);
	
}
