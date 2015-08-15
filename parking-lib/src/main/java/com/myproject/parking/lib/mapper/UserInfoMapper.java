package com.emobile.smis.web.mapper;

import java.util.List;

import com.emobile.smis.web.data.param.ParamQueryVO;
import com.emobile.smis.web.entity.Branch;
import com.emobile.smis.web.entity.Position;
import com.emobile.smis.web.entity.Product;
import com.emobile.smis.web.entity.Region;
import com.emobile.smis.web.entity.UserData;
import com.emobile.smis.web.entity.UserRole;

public interface UserInfoMapper {

	
	public List<UserRole> findUserRole();
	
	public List<Position> findAllPosition();
	
	public Position findPositionById(int id);
	
	public List<Region> findAllRegion();
	
	public List<Branch> findBranchByRegionId(int regionId);
	
	public List<Branch> findBranchByUserId(int userId);
	
	public List<Branch> findBranchByUserIdNotPairing(int userIdNotPairing);
	
	public List<Branch> findBranchByListId(ParamQueryVO params);
	
	public List<Product> findAllProduct();
	
	public Region findRegionByBranchId(int branchId);
	
	//nyari semua MO dengan product id 1
	public List<UserData> findAllMo();
	
	public List<UserData> findAllMoByUserBranch(int userId);
	
	public List<Branch> findAllBranch();
}
