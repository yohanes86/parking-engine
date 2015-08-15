package com.emobile.smis.webservice.logic.visit.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emobile.smis.web.data.UserDataVO;
import com.emobile.smis.web.data.param.ParamQueryVO;
import com.emobile.smis.web.entity.Branch;
import com.emobile.smis.web.mapper.AssignmentBMMapper;
import com.emobile.smis.web.mapper.UserDataMapper;
import com.emobile.smis.web.utils.SmisWebException;
import com.emobile.smis.webservice.logic.SmisBaseQueryLogic;

public class FindUserDataVOByBranchCodeLevelCode implements SmisBaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(FindUserDataVOByBranchCodeLevelCode.class);
	
	@Autowired
	private UserDataMapper userDataMapper;
	@Autowired
	private AssignmentBMMapper assignmentMapper;
		
	private String branchCode;
	
	@Override
	@Transactional(readOnly=true)
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		try {
			ParamQueryVO param = mapper.readValue(data, ParamQueryVO.class);	
			branchCode = param.getParamStr1();
			UserDataVO ud = userDataMapper.findUserDataVOByBranchCodeLevelCode(param.getParamStr1(), param.getParamInt1());
			return mapper.writeValueAsString(ud);
		} catch (MyBatisSystemException me){
			String errType = me.getCause().toString();
			if(errType.startsWith(SmisWebException.MYBATIS_TOO_MANY_RESULT)){
				try{
					Branch branch = assignmentMapper.findBranchByBranchCode(branchCode);
					String errMsg = String.valueOf(SmisWebException.NE_TOO_MANY_RESULT_THIS_BRANCH) +"-"+ branch.getBranchName();
					return mapper.writeValueAsString(errMsg);
				} catch(Exception e1){
					LOG.warn("Unexpected exception while return too many result " + pathInfo, e1);
					return null;
				}
			} else {
				LOG.warn("Unexpected exception when processing " + pathInfo, me);
				return null;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			LOG.warn("Unexpected exception when processing " + pathInfo, e);
			return null;
		}
		
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	
}
