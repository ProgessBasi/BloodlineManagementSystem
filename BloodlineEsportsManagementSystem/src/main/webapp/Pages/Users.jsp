<%@page import="model.RegisterModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.database.DBController"%>
<%@page import="utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
DBController controller = new DBController();
ArrayList<RegisterModel> users = controller.getAllUsersInfo();
request.setAttribute("usersLists", users);
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Page</title>
<link rel="stylesheet" href="<%=contextPath%>/StyleSheets/Users.css">
<style>
body {
	margin: 0;
	padding: 0;
}

.user-data h2 {
	color: #fff;
	text-align: center;
	margin-top: 50px; /* Adjust the margin-top as needed */
}

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

		<!-- Displaying user data -->
		<div class="user-data">
			<h2>Users</h2>
			<table>
				<thead>
					<tr>
						<th>Full Name</th>
						<th>Username</th>
						<th>Email</th>
						<th>Phone Number</th>
						<th>Country</th>
						<th>Gender</th>
						<th>Date of Birth</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${usersLists}">
						<tr>
							<td>${user.fullName}</td>
							<td>${user.userName}</td>
							<td>${user.email}</td>
							<td>${user.phoneNumber}</td>
							<td>${user.country}</td>
							<td>${user.gender}</td>
							<td>${user.DOB}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>