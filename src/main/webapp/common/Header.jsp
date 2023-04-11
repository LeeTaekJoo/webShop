<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<div>로그인한 사용자: ${loginUser.manager_name}</div>
<div>세션에서 로그인사용자읽기(EL): ${sessionScope.loginUser}</div>
<div>세션에서 로그인사용자읽기(ScriptLet): <%=session.getAttribute("loginUser")%></div>

<button id="btnLogout">로그아웃</button>
<img src="../images/umbrella.jpg" width="200" height="150">

	
