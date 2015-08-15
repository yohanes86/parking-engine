package com.emobile.smis.web.mapper;

import com.emobile.smis.web.entity.ChangePassHistory;

public interface ChangePassHistoryMapper {

	public ChangePassHistory findPassHistoryByUserId(int userId);
	
	public void insertPassHistory(ChangePassHistory passHistory);
	
	public void updatePassHistory(ChangePassHistory passHistory);
}
