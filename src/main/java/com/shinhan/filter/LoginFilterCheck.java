package com.shinhan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.vo.AdminVO;


@WebFilter("*.do")
public class LoginFilterCheck extends HttpFilter implements Filter {
       
    
    public LoginFilterCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	// 로그인을 안하면 emplist를 못보게하고싶다!!
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rep = (HttpServletResponse)response;
		System.out.println("req.getRequestURI():" + req.getServletPath());
		
		if(req.getServletPath().equals("/auth/loginCheck.do")||
			req.getServletPath().equals("/auth/signup.do")|| 
			req.getServletPath().equals("/auth/emailDupCheck.do")
			){	
		}else {
			HttpSession browser = req.getSession();
			
			AdminVO user = (AdminVO)browser.getAttribute("loginUser");
			if(user == null) {
				rep.sendRedirect(req.getContextPath()+ "/auth/loginCheck.do");
				return;
			}	
			System.out.println("user=" + user);
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
