<%@page import="model.AddTeamModel"%>
<%@page import="controller.database.DBController"%>
<%@page import="utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
DBController controller = new DBController();
String username = request.getParameter("username");
AddTeamModel player = controller.getPlayerByUsername(username);
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Forgot Password</title>
<link rel="stylesheet" href="<%=contextPath%>/StyleSheets/register.css">
</head>
<body>
	<div class="wrapper">
		<form action="<%=contextPath%>/forgetPassword" method="post">
			<input type="hidden" name="updateId" value=<%=username%>>
			<h1>Forgot Password</h1>
			<div class="input-box">
				<input type="text" placeholder="Username" name="FPusername" required>
				<i class='bx bxs-user'></i>
			</div>
			<div class="input-box">
				<input type="password" placeholder="New Password"
					name="FPnewPassword" required> <i class='bx bxs-lock-alt'></i>
			</div>
			<div class="input-box">
				<input type="password" placeholder="Retype New Password"
					name="FPretypeNewPassword" required> <i
					class='bx bxs-lock-alt'></i>
			</div>
			<button type="submit" class="btn">Reset Password</button>
			<div class="login-link">
				<p>
					Remembered your password? <a
						href="<%=contextPath%>/Pages/login.jsp">Login</a>
				</p>
			</div>
			<%
			String errMsg = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
			String successMsg = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);

			if (errMsg != null) {
				// print error message
			%>
			<h2 class="error-msg"><%=errMsg%></h2>
			<%
			}

			if (successMsg != null) {
			// print success message
			%>
			<h2 class="success-msg"><%=successMsg%></h2>
			<%
			}
			%>
		</form>
	</div>
</body>
</html>