package com.emobile.smis.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.emobile.smis.web.data.AccountInfoVO;
import com.emobile.smis.web.data.param.ParamQueryVO;
import com.emobile.smis.web.entity.AccountInfo;

public interface AccountInfoMapper {

	public void createAccountInfo(AccountInfo accountInfo);
	public void updateAccountInfo(AccountInfo accountInfo);
	public void deleteAccountInfo(AccountInfo accountInfo);
	public List<AccountInfo> findListAccountInfoByPicId(int picId);
	public int countNotifAccInfo(ParamQueryVO params);
	public List<AccountInfoVO> findNotifAccInfo(ParamQueryVO params);
	public void authoriseAccInfo(AccountInfoVO accountInfo);
	public int countAccInfoWithRekening(ParamQueryVO params);
}
