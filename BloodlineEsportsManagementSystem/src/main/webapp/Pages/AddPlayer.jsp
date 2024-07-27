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
<title>Add Player Page</title>
<link rel="stylesheet"
	href="<%=contextPath%>/StyleSheets/AddPlayer.css">
</head>
<body>
	<!-- Second Form -->
	<div class="wrapper">
		<form action="<%=contextPath%>/AddPlayer" method="post">
			<h1>Add Player</h1>
			<h4></h4>
			<div class="input-row">
				<div class="input-box">
					<input type="text" placeholder="Full Name" name="PfullName"
						required> <i class='bx bxs-user'></i>
				</div>
				<div class="input-box">
					<input type="text" placeholder="Username" name="Pusername" required>
					<i class='bx bxs-user'></i>
				</div>
			</div>
			<div class="input-row">
				<div class="input-box">
					<input type="text" placeholder="Country" name="Pcountry" required>
					<i class='bx bxs-globe'></i>
				</div>
				<div class="input-box">
					<input type="text" placeholder="Team" name="Pteam" required>
					<i class='bx bxs-team'></i>
				</div>
			</div>
			<div class="input-row">
				<div class="input-box">
					<div class="select-style">
						<select id="role" name="Prole" required>
							<option value="" disabled selected>Select Role</option>
							<option value="Deulist">Deulist</option>
							<option value="Initiator">Initiator</option>
							<option value="Sentinal">Sentinal</option>
							<option value="Controller">Controller</option>
							<option value="Flex">Flex</option>
						</select>
					</div>
				</div>
			</div>
			<div class="input-row">
				<div class="input-box">
					<input type="text" placeholder="HS%" name="Phsp" required>
					<i class='bx bxs-percentage'></i>
				</div>
				<div class="input-box">
					<input type="text" placeholder="ACS" name="Pacs" required>
					<i class='bx bxs-check-circle'></i>
				</div>
			</div>
			<button type="submit" class="btn">Add</button>
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