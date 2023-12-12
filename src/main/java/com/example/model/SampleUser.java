package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
