package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.model.AdminService;
import com.shinhan.vo.AdminVO;

@WebServlet("/auth/loginCheck.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext app = request.getServletContext();
		Object obj = app.getAttribute("visitor");
		int count=1;
		if(obj != null) {
			count = (Integer)obj;
			count++;
		}
		app.setAttribute("visitor", count);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	
          
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// input태그의 name 과 같아야한다
		String emails = request.getParameter("emails");
		String pass = request.getParameter("pass");
		AdminService service = new AdminService();
		AdminVO admin = service.loginCheck(emails, pass);
		System.out.println(admin==null?"로그인실패" : admin);
		
		
		// 응답문서 만들기 header + ResponseBody에 문자열을 출력하기
		// <meta charset="UTF-8">
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(admin==null) {
			// 응답문서에 header부분을 작성해서 내려간다. 아래부분코드는 3초후 재요청한다는 의미이다.
			response.setHeader("refresh", "3; loginCheck.do");
			out.print("<h1 style='background-color:orange;'>Login Fail</h1>");
			return ;
		}
		
		// 로그인한 사람의 정보를 저장하기
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", admin);
//		ServletContext app = request.getServletContext();
//		app.setAttribute("loginUser", admin);
		
		
		// 응답문서에 주소창을 바꾼다.(sendRedirect이용)
		// http://localhost:9090/
		String path = request.getContextPath();
		String encodeName = URLEncoder.encode(admin.getManager_name(),"utf-8");
		response.sendRedirect(path + "/emp/emplist.do?myname=" + encodeName);
		
		// response.sendRedirect(path+"/emp/emplist.do");
		
		// 재요청. 응답문서에 주소창을 바꾼다 (응답문서에 javascript를 가져간다)
//		out.print("<script>"
//				+ "alert('로그인성공 ... 업무화면으로 이동합니다');"
//				+ "location.href='"
//				+ path
//				+ "/emp/emplist.do';"
//				+ "</script>");
		
	}


}
