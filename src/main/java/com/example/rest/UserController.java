package com.example.rest;

/*
 * Presentation Layer: UserController
 */

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.HelloVO;
import com.example.model.SampleUser;
import com.example.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/*
 * springdoc-openapi
 * https://springdoc.org/#migrating-from-springfox
 */

@Tag(name="Springboot sample API", description="Spring boot sample API 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
	private String msgTemplate = "%s 님 반갑습니다.";
	private final AtomicLong vistorCounter = new AtomicLong();
	
	@Autowired
	private final UserService userService;
	
	@Operation(summary="Hello API", description="Hello API 입니다.")
	@Parameters({
		@Parameter(name="name", in=ParameterIn.QUERY, description="", required=true, allowEmptyValue=true) 
	})
	
	@GetMapping("/hello")
	public HelloVO getHelloMsg(@RequestParam(value = "name") String name) {
		return new HelloVO(vistorCounter.incrementAndGet(), String.format(msgTemplate, name));
	}
	
	@GetMapping(value="/users", produces = "application/json")	
	@Operation(operationId="users", summary="사용자 정보 가져오기", description="사용자 정보를 제공합니다.")
	public ResponseEntity <List<SampleUser>> getUserList() { 
		return userService.getUserList();
	}
	
	@GetMapping("/users/{userId}")
	@Operation(summary="아이디로 사용자 정보 가져오기 ")
	@Parameters({
		@Parameter(name="userId", in=ParameterIn.PATH, description="", required=true, allowEmptyValue=false) 
	})
	public ResponseEntity <SampleUser> getUserById(
				@PathVariable (name="userId", required = true) String userId
			) { 
		return userService.getUserById(userId);
	}
	
	@PutMapping("/users/{userId}")
	@Operation(summary="사용자 정보 변경하기 ")	
	public ResponseEntity <String > setUserUpdate(
			@PathVariable(name="userId",required = true ) String userId, 
			@RequestBody SampleUser sampleUser
		) throws Exception { 
		
		return userService.setUserUpdate(userId, sampleUser);
	}
	
	@PostMapping("/users")
	@Operation(summary="사용자 정보 등록하기 ")
	public ResponseEntity <String > setUserInsert(
			@RequestBody SampleUser sampleUser
		) throws Exception { 
		
		return userService.setUserInsert(sampleUser);
	}
	
	@DeleteMapping("/users/{userId}")
	@Operation(summary="사용자 정보 삭제하기 ")
	public ResponseEntity <String > setUserDelete(
			@PathVariable(name="userId",required = true ) String userId
		) throws Exception { 
		
		return userService.setUserDelete(userId);
	}
	
	@GetMapping("/createtestusers/{startUserId}/{userCount}")
	@Operation(summary="테스트 사용자를 userCount명 등록하기 ")
	@Parameters({
		@Parameter(name="startUserId", description="시작번호(예:1)", in=ParameterIn.PATH, required=true, allowEmptyValue=false),
		@Parameter(name="userCount", description="생성유저수(예:10)", in=ParameterIn.PATH, required=true, allowEmptyValue=false) 
	})
	public ResponseEntity <String > createTestUsers(
			@PathVariable (name="startUserId", required = true) int startUserId,
			@PathVariable (name="userCount", required = true) int userCount
		) throws Exception { 
		
		return userService.createTestUsers(startUserId, userCount);
	}
	
}