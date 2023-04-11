package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.AdminService;


@WebServlet("/auth/emailDupCheck.do")
public class EmailDupCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emails = request.getParameter("emails");
		System.out.println(emails);
		AdminService service = new AdminService();
		int result = service.dupCheck(emails);
		
		// response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// 0 or 1 출력 최대한 간결하게
		out.print(result);
	}

}
