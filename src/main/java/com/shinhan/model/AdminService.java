package com.shinhan.model;

import com.shinhan.vo.AdminVO;

public class AdminService {
	
	AdminDAO dao = new AdminDAO();
	
	public AdminVO loginCheck(String emails, String pass) {		
		return dao.loginCheck(emails, pass);
	}
	
	// 회원가입
	public int registerAdmin(AdminVO admin) {
		return dao.registerAdmin(admin);
	}
	
	// 이메일 중복체크
	public int dupCheck(String emails) {
		return dao.dupCheck(emails);
	}

}
