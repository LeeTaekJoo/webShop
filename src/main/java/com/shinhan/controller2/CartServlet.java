package com.shinhan.controller2;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 장바구니 담기
@WebServlet("/cart/addCart.do")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("cart.jsp");
		rd.forward(request, response);
	}
		
          
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 필터에서 하고와서 할필요 없음
		// request.setCharacterEncoding("utf-8");
		String product = request.getParameter("product");
		int count = Integer.parseInt(request.getParameter("count"));
		
		HttpSession session = request.getSession(); // 있으면 얻고 없으면 새로만든다.
		Object obj = session.getAttribute("cart");
		HashMap<String, Integer> cart = null;
		if(obj == null) {
			cart = new HashMap<>(); // 장바구니 없으면 만든다
			cart.put(product, count);
			session.setAttribute("cart", cart);	
		}else {
			cart = (HashMap<String, Integer>)obj; // 원래 있는것에 개수 누적
			if(cart.containsKey(product)) {
				int originalCount = cart.get(product);
				cart.put(product, originalCount + count);
			}else {
				cart.put(product, count);
			}		
		}
		
		response.sendRedirect("addCart.do");	
	}

}
