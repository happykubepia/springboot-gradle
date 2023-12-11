package com.example.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SampleUser {
	private String userId ;
	private String userNm ;
	private String addr ;
	private String cellPhone ;
	private String agreeInform;
	private String birthDt ;

}
