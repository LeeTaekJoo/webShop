<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/login.css" type="text/css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<script>
	$(function(){
	
		// 중복체크
		// page이동없이 서버에 요청보내고 응답받기 : ajax
		$("#emailDupCheck").on("click", function(){
			$.ajax({
				url:"emailDupCheck.do",
				method:"get",
				data:{"emails":$("#m_emails").val()},
				success:function(responseData){
					//alert(responseData);
					var message = responseData==1?"이미존재":"사용가능";
					$("#message").text(message);
					if(responseData==1){
						$("#m_emails").val("");
						$("#m_emails").focus();
					}
				},
				error: function(){
					alert(message);
				}
			})
		});
	});
</script>

</head>
<body>
	<p>${visitor}번째 방문자입니다.</p>
	<h2>Weekly Coding Challenge #1: Sign in/up Form</h2>
	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form method="post"
				action="<%=request.getContextPath()%>/auth/signup.do">
				<h1>Create Account</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> <a
						href="#" class="social"><i class="fab fa-google-plus-g"></i></a> <a
						href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<span>or use your email for registration</span> <input type="text"
					placeholder="Name" name="manager_name" /> <input type="email"
					placeholder="Email" name="emails" id="m_emails"/> 
					<span id="message">!!!</span>
					<input type="button"
					id="emailDupCheck" value="중복체크" /> <input type="password"
					placeholder="Password" name="pass" />
				<button>Sign Up</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
			<!-- 주소를 호출 -->
			<form action="<%=request.getContextPath()%>/auth/loginCheck.do"
				method="post" enctype="application/x-www-form-urlencoded">
				<h1>Sign in</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> <a
						href="#" class="social"><i class="fab fa-google-plus-g"></i></a> <a
						href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<span>or use your account</span> <input type="email" name="emails"
					placeholder="Email" /> <input type="password" name="pass"
					placeholder="Password" /> <a href="#">Forgot your password?</a>
				<button>Sign In</button>
				<!-- <input type="submit value="Sign In"> -->
				
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>To keep connected with us please login with your personal
						info</p>
					<button class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Hello, Friend!</h1>
					<p>Enter your personal details and start journey with us</p>
					<button class="ghost" id="signUp">Sign Up</button>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/js/login.js"></script>
</body>
</html>