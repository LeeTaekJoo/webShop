package com.shinhan.controller2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.vo.AdminVO;

// 장바구니 비우기
@WebServlet("/auth/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println();
		request.getSession(false).invalidate();
		// 세션을 지우기, Browser접속을 해제하고
		
		ServletContext app = getServletContext();
		HttpSession session = request.getSession();
		
		Object obj = app.getAttribute("userList");
		AdminVO admin = (AdminVO)session.getAttribute("loginUser");
		List<AdminVO> userList = null;
		
			if(obj==null) {
				userList = new ArrayList<>();
				userList.remove(admin);
				app.setAttribute("userList", userList);
			}		
		
	}
}
