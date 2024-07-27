<%@page import="utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<link rel="stylesheet" href="<%=contextPath%>/StyleSheets/login.css">
</head>
<body>
	<div class="wrapper">
		<form action="<%=contextPath%>/LoginPage" method="post">
			<h1>Login</h1>
			<div class="input-box">
				<input type="text" placeholder="Username" name="username" required>
				<i class='bx bxs-user'></i>
			</div>
			<div class="input-box">
				<input type="password" placeholder="Password" name="password"
					required> <i class='bx bxs-lock-alt'></i>
			</div>
			<div class="remember-forgot">
				<a href="<%=contextPath%>/Pages//ForgetPassword.jsp">Forgot
					Password</a>
			</div>
			<button type="submit" class="btn">Login</button>
			<div class="register-link">
				<p>
					Don't have an account? <a
						href="<%=contextPath%>/Pages/register.jsp">Register</a>
				</p>
			</div>
			<%
			String errMsg = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
			String successMsg = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);

			if (errMsg != null) {
				// print
			%>
			<h2 class="error-msg" style="color: red; font-size: smaller;"><%=errMsg%></h2>
			<%
			}

			if (successMsg != null) {
			// print
			%>
			<p style="color: red; font-size: smaller;"><%=successMsg%></p>
			<%
			}
			%>
		</form>
	</div>
</body>
</html>