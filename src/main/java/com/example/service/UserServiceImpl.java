package com.example.service;

/*
 * Service Layer: UserService
 */

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.dao.SampleUserDao;
import com.example.model.SampleUser;
import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SampleUserDao sampleUserDao;
	
	public ResponseEntity <List<SampleUser>> getUserList() { 
		List<SampleUser> list = null;
		try {
			log.info("Start db select");
			list = sampleUserDao.selectUserAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("user counts :"+list.size());
		
		return new ResponseEntity<List<SampleUser>> (list, HttpStatus.OK);
	}
	
	public ResponseEntity <SampleUser> getUserById(String userId) { 
		SampleUser re = null;
		try {
			log.info("Start db select");
			re = sampleUserDao.selectUser(userId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<SampleUser> (re, HttpStatus.OK);
	}
	
	public ResponseEntity <String > setUserUpdate(String userId, SampleUser sampleUser) throws Exception {
		log.info("Start db update==>"+userId);

		int re  = sampleUserDao.updateUser(sampleUser);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}
	
	public ResponseEntity <String > setUserInsert(SampleUser sampleUser) throws Exception { 
		log.info("Start db insert");
		int re  = sampleUserDao.insertUser(sampleUser);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);	
	}

	public ResponseEntity <String > setUserDelete(String userId) throws Exception { 
		log.info("Start db insert");
		int re  = sampleUserDao.deleteUser(userId);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}
	
	public ResponseEntity <String> createTestUsers(int startUserId, int userCount) throws Exception { 
		log.info("***** Start creating Test users "+userCount+"명");
		
		ArrayList<SampleUser> list = new ArrayList<SampleUser>();
		SampleUser user = null;
		
		for(int i=0; i < userCount-startUserId + 1; i++) {
			user = new SampleUser();
			
			user.setUserId("user"+String.format("%02d", startUserId+i));
			user.setUserNm("유저"+String.format("%02d", startUserId+i));
			user.setAddr("");
			user.setCellPhone(String.format("%02d", startUserId+i));
			user.setAgreeInform("Yes");
			user.setBirthDt(String.format("%02d", startUserId+i));
			
			list.add(user);
		}
		log.info("Added User object in list==>"+list.size());
		
		sampleUserDao.createTestUsers(list);
		
		log.info("***** End creating Test users "+userCount+"명");
		
		return new ResponseEntity<String> ("1", HttpStatus.OK);
	}
}
