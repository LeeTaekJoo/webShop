package com.shinhan.model;

import com.shinhan.vo.AdminVO;

public class AdminService {
	
	AdminDAO dao = new AdminDAO();
	
	public AdminVO loginCheck(String emails, String pass) {		
		return dao.loginCheck(emails, pass);
	}

}
