package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.model.SampleUser;

@Mapper
@Repository
public interface SampleUserDao {

	 List<SampleUser> selectUserAll() throws Exception ;
	 
	 SampleUser selectUser(String userId) throws Exception;
	 
	 int insertUser(SampleUser user) throws Exception;
	 
	 int updateUser(SampleUser user) throws Exception;
	 
	 int deleteUser(String userId) throws Exception;
	 
	 int createTestUsers(ArrayList<SampleUser> users) throws Exception;	
}
