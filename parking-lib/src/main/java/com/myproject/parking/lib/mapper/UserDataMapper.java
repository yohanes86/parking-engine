package com.emobile.smis.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.emobile.smis.web.data.UserDataVO;
import com.emobile.smis.web.entity.Product;
import com.emobile.smis.web.entity.UserAccess;
import com.emobile.smis.web.entity.UserBranch;
import com.emobile.smis.web.entity.UserData;
import com.emobile.smis.web.entity.UserProduct;

public interface UserDataMapper {

	public void createUserData(UserDataVO userDataVO);
	public int updateUserData(UserData userData);	
	public UserData findUserDataByUserCode(@Param("userCode") String userCode, @Param("userStatus") int userStatus);
	//using like sql
	public List<UserDataVO> findUserDataNotPairingByCode(String userCode);
	
	public UserDataVO findUserDataVOByIdAndStatus(@Param("id") int id, @Param("status") String status);	
	public UserDataVO findUserDataVOByBranchCodeLevelCode(@Param("branchCode") String branchCode, @Param("levelCode") int levelCode);
	public void insertUserProduct(UserProduct userProduct);
	public void deleteUserProductByUserId(int userId);
	public void insertUserAccess(UserAccess userAccess);
	public void deleteUserAccessByUserId(int userId);
	public UserProduct findUserProductByUserId(int userId);
	public List<UserDataVO> findUserDataByParamVO(UserDataVO paramVO);	
	public int countUserData(UserDataVO paramVO);
	public Product findProductByUserId(int id);
	
	public void updateUserDataVO(UserDataVO userDataVO);	
	//relation table from MA and ME
	public void insertUserBranch(UserBranch userBranch);
	public void deleteUserBranchByUserId(int userId);

	
}
