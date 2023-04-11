package com.shinhan.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/url/test") --> 이름이 일치하는 URL parttern
// @WebServlet("/url/test/*")
@WebServlet("*.go") // 확장자 URL partter인 경우 폴더와 같이 사용안됨
public class URLPartternTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// getContextPath:/webShop
		System.out.println("getContextPath:"+ request.getContextPath());
		// getRequestURI:/webShop/url/test
		System.out.println("getRequestURI:"+request.getRequestURI());
		// getRequestURL:http://localhost:9090/webShop/url/test
		System.out.println("getRequestURL:"+request.getRequestURL());
		// getMethod:GET
		System.out.println("getMethod:"+request.getMethod());
		// getRemoteAddr:0:0:0:0:0:0:0:1 서버에 접속한
		System.out.println("getRemoteAddr:"+request.getRemoteAddr());
		// getServletPath:/url/test
		System.out.println("getServletPath:"+request.getServletPath());
		// getPathInfo:null -- > url/test/* 요청한 URL이름뒷부분의 url
		System.out.println("getPathInfo:"+request.getPathInfo());
		
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
