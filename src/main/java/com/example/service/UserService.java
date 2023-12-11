package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.model.SampleUser;

public interface UserService {
	public ResponseEntity <List<SampleUser>> getUserList();
	
	public ResponseEntity <SampleUser> getUserById(String userId);
	
	public ResponseEntity <String > setUserUpdate(String userId, SampleUser sampleUser) throws Exception;
	
	public ResponseEntity <String > setUserInsert(SampleUser sampleUser) throws Exception;
	
	public ResponseEntity <String > setUserDelete(String userId) throws Exception;
	
	public ResponseEntity <String> createTestUsers(int startUserId, int userCount)  throws Exception;
}
