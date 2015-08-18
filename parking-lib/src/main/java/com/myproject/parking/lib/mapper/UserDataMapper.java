package com.myproject.parking.lib.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.myproject.parking.lib.entity.UserData;

public interface UserDataMapper {
	public void createUserData(UserData userData);
	public UserData findUserDataByEmailAndPhoneNo(@Param("email") String email, 
			@Param("phoneNo") String phoneNo);
	public UserData findUserByEmailAndPhoneNoAndActKey(@Param("email") String email, 
			@Param("phoneNo") String phoneNo,@Param("actKey") String actKey);
	public void updateStatusUser(@Param("email") String email, @Param("status") int status ,@Param("updatedOn") Date updatedOn );
}
