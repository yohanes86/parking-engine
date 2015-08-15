package com.emobile.smis.web.mapper;

import java.util.List;

import com.emobile.smis.web.data.param.MultifinanceOthersParamVO;
import com.emobile.smis.web.entity.MultifinanceOthers;

public interface MultifinanceOthersMapper {
	
	public MultifinanceOthers findLastMultifinanceOthers();
	
	public void createMultifinanceOthers(MultifinanceOthers multifinanceOthers);
	
	public void updateMultifinanceOthers(MultifinanceOthers multifinanceOthers);
	
	public int countMultifinanceOthersByParam(MultifinanceOthersParamVO multifinanceOthersParamVO);
	
	public List<MultifinanceOthers> findMultifinanceOthersByParam(MultifinanceOthersParamVO multifinanceOthersParamVO);
	
	public List<MultifinanceOthers> findMultifinanceOthersByName(String name);
	
	public MultifinanceOthers findMultifinanceOthersById(int id);
}