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
<title>Registration Page</title>
<link rel="stylesheet" href="<%=contextPath%>/StyleSheets/register.css">
</head>
<body>
	<div class="wrapper">
		<form action="<%=contextPath%>/RegisterPage" method="post">
			<h1>Registration</h1>
			<h4></h4>
			<div class="input-row">
				<div class="input-box">
					<input type="text" placeholder="Full Name" name="fullName" required>
					<i class='bx bxs-user'></i>
				</div>
				<div class="input-box">
					<input type="text" placeholder="Username" name="username" required>
					<i class='bx bxs-user'></i>
				</div>
			</div>
			<div class="input-row">
				<div class="input-box">
					<input type="email" placeholder="Email" name="email" required>
					<i class='bx bxs-envelope'></i>
				</div>
				<div class="input-box">
					<input type="tel" placeholder="Phone Number" name="phoneNumber"
						required> <i class='bx bxs-phone'></i>
				</div>
			</div>
			<div class="input-row">
				<div class="input-box">
					<input type="text" placeholder="Country" name="country" required>
					<i class='bx bxs-globe'></i>
				</div>
				<div class="input-box">
					<input type="date" placeholder="Date of Birth" value="2023-02-12"
						name="dob" required> <i class='bx bxs-calendar'></i>
				</div>
			</div>
			<div class="input-row">
				<div class="input-box">
					<div class="select-style">
						<select id="role" name="Role" required>
							<option value="" disabled selected>Select Role</option>
							<option value="user">User</option>
							<option value="admin">Admin</option>
						</select>
					</div>
				</div>
				<div class="input-box">
					<div class="select-style">
						<select id="gender" name="gender" required>
							<option value="" disabled selected>Select Gender</option>
							<option value="male">Male</option>
							<option value="female">Female</option>
							<option value="other">Other</option>
						</select>
					</div>
				</div>
			</div>
			<div class="input-row">
				<div class="input-box">
					<input type="password" placeholder="Password" name="password"
						required> <i class='bx bxs-lock-alt'></i>
				</div>
				<div class="input-box">
					<input type="password" placeholder="Retype Password"
						name="retypePassword" required> <i class='bx bxs-lock-alt'></i>
				</div>
			</div>
			<button type="submit" class="btn">Register</button>
			<div class="login-link">
				<p>
					Already have an account? <a
						href="<%=contextPath%>/Pages/login.jsp">Login</a>
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