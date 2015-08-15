package com.emobile.smis.web.mapper;

import java.util.List;

import com.emobile.smis.web.data.ModuleVO;
import com.emobile.smis.web.data.RootModuleVO;
import com.emobile.smis.web.data.param.UserRoleParamVO;
import com.emobile.smis.web.entity.Module;
import com.emobile.smis.web.entity.RoleModule;
import com.emobile.smis.web.entity.UserRole;

public interface UserRoleMapper {
	public void createUserRole(UserRole userRole);
	public int updateUserRole(UserRole userRole);

	public List<UserRole> findUserRoleByUserId(int id);
	public List<UserRole> findUserRoleByParam(UserRoleParamVO paramVO);
	public UserRole findUserRoleById(int userRoleId);
	public UserRole findUserRoleByName(String userRoleName);
	
	public int deleteRoleModule(int userRoleId);
	public int createRoleModule(RoleModule roleModule);
	
	public List<Module> findModuleByUserCode(String userCode);
	public List<Module> findModuleAll();
	public List<ModuleVO> findModuleByUserRoleId(int userRoleId);
	
	public List<RootModuleVO> findModuleLeaf();
}
