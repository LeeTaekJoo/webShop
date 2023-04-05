package com.shinhan.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
// DTO, VO, JavaBeans : data를 저장해서 전송하기위해
public class AdminVO {
	private String emails;
	private String manager_name;
	private String pass;

} // AdminVO
