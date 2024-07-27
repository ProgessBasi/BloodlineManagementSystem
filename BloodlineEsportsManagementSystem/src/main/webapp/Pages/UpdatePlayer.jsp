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
<title>Update Player Page</title>
<link rel="stylesheet"
	href="<%=contextPath%>/StyleSheets/AddPlayer.css">
</head>
<body>
	<div class="wrapper">
		<form action="<%=contextPath%>/modifyUser" method="post">
			<input type="hidden" name="updateId" value=<%=username%>>

			<h1>Update Player</h1>
			<div class="input-row">
				<div class="input-box">
					<input type="text" placeholder="Full Name" name="PfullName"
						value="<%=player.getPlayerName()%>" required>
				</div>
				<div class="input-box">
					<input type="text" placeholder="Username" name="Pusername"
						value="<%=player.getPlayerUsername()%>" required readonly>
				</div>
			</div>
			<div class="input-row">
				<div class="input-box">
					<input type="text" placeholder="Country" name="Pcountry"
						value="<%=player.getCountry()%>" required>
				</div>
				<div class="input-box">
					<input type="text" placeholder="Team" name="Pteam"
						value="<%=player.getTeam()%>" required>
				</div>
			</div>
			<div class="input-row">
				<div class="input-box">
					<select id="role" name="Prole" required>
						<option value="" disabled>Select Role</option>
						<option value="Deulist"
							<%=player.getPlayerRole().equals("Deulist") ? "selected" : ""%>>Deulist</option>
						<option value="Initiator"
							<%=player.getPlayerRole().equals("Initiator") ? "selected" : ""%>>Initiator</option>
						<option value="Sentinal"
							<%=player.getPlayerRole().equals("Sentinal") ? "selected" : ""%>>Sentinal</option>
						<option value="Controller"
							<%=player.getPlayerRole().equals("Controller") ? "selected" : ""%>>Controller</option>
						<option value="Flex"
							<%=player.getPlayerRole().equals("Flex") ? "selected" : ""%>>Flex</option>
					</select>
				</div>
			</div>
			<div class="input-row">
				<div class="input-box">
					<input type="text" placeholder="HS%" name="Phsp"
						value="<%=player.getPlayerHS()%>" required>
				</div>
				<div class="input-box">
					<input type="text" placeholder="ACS" name="Pacs"
						value="<%=player.getPlayerACS()%>" required>
				</div>
			</div>
			<button type="submit" class="btn">Update</button>
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