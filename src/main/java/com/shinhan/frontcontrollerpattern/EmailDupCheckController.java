package com.shinhan.frontcontrollerpattern;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.shinhan.model.AdminService;

public class EmailDupCheckController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {

		HttpServletRequest request = (HttpServletRequest)data.get("request");
		
		String emails = request.getParameter("emails");
		System.out.println(emails);
		AdminService service = new AdminService();
		int result = service.dupCheck(emails);
				
		return "responseBody:" + result;
	}

}
