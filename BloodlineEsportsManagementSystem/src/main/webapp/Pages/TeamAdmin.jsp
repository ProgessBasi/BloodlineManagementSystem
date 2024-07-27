<%@page import="model.AddTeamModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.database.DBController"%>
<%@page import="utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
DBController controller = new DBController();
ArrayList<AddTeamModel> players = controller.getAllPlayersInfo();
request.setAttribute("playerLists", players);
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Players Page</title>
<link rel="stylesheet" href="<%=contextPath%>/StyleSheets/TeamAdmin.css">
<style>
/* Table styling */
.user-data table {
	color: white;
	width: 80%;
	margin: 0 auto;
	margin-top: 20px; /* Adjust the margin-top as needed */
	border-collapse: collapse;
}

/* Table header and cell styling */
.user-data th, .user-data td {
	border: 1px solid white;
	padding: 10px;
	text-align: center;
}

/* Alternating row background color */
.user-data tr:nth-child(even) {
	background-color: rgba(255, 255, 255, 0.1);
}

/* Hover effect on table rows */
.user-data tr:hover {
	background-color: rgba(255, 255, 255, 0.2);
}

.user-data a {
	color: white;
}
</style>
</head>
<body>
	<div class="banner">
		<div class="navbar">
			<h1 class="logo" style="color: white;">BLooDL!NE</h1>
			<ul>
				<li><a href="<%=contextPath%>/Pages/AdminHome.jsp">Home</a></li>
				<li><a href="<%=contextPath%>/Pages/Users.jsp">Users</a></li>
				<li><a href="<%=contextPath%>/Pages/TeamAdmin.jsp">Players</a></li>
				<li><a href="<%=contextPath%>/Pages/AdminProfile.jsp">Profile</a></li>
			</ul>
		</div>
		<!-- Displaying player data -->
		<div class="user-data">
			<h2 style="color: white; text-align: center;">Players</h2>
			<button class="btn"
				onclick="window.location.href='<%=contextPath%>/Pages/AddPlayer.jsp'">Add</button>
			<br> <br>
			<table>
				<thead>
					<tr>
						<th>Full Name</th>
						<th>Username</th>
						<th>Country</th>
						<th>Team</th>
						<th>HS(%)</th>
						<th>Role</th>
						<th>PlayerACS</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="player" items="${playerLists}">
						<tr>
							<td>${player.playerName}</td>
							<td>${player.playerUsername}</td>
							<td>${player.country}</td>
							<td>${player.team}</td>
							<td>${player.playerHS}</td>
							<td>${player.playerRole}</td>
							<td>${player.playerACS}</td>
							<td>
								<!-- Update link -->
								<button type="button"
									onclick="redirectToUpdate('${player.playerUsername}')">Update</button>
								<!-- Delete link -->
								<form id="deleteForm-${player.playerUsername}" method="post"
									action="<%=contextPath + StringUtils.SERVLET_URL_MODIFY_USER %>">
									<input type="hidden" name="<%=StringUtils.DELETE_ID %>"
										value="${player.playerUsername}" />
									<button type="button"
										onclick="confirmDelete('${player.playerUsername}')">Delete</button>
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
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<br>
	<br>
</body>
<script>
        function confirmDelete(userName) {
            if (confirm("Are you sure you want to delete this user: " + userName + "?")) {
                document.getElementById("deleteForm-" + userName).submit();
            }
        }
        function redirectToUpdate(userName) {
            window.location.href = '<%=contextPath%>/Pages/UpdatePlayer.jsp?username=' + userName;
        }
</script>
</html>