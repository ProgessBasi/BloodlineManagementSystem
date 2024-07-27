<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String contextPath = request.getContextPath();
HttpSession ses = request.getSession();
ses.getAttribute("username");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>
<link rel="stylesheet" href="<%=contextPath%>/StyleSheets/Home.css">
</head>
<body>
	<div class="banner">
		<div class="navbar">
			<h1 class="logo" style="color: white;">BLooDL!NE</h1>
			<ul>
				<li><a href="<%=contextPath%>/Pages/Home.jsp">Home</a></li>
				<li><a href="<%=contextPath%>/Pages/PlayerUser.jsp">Player</a></li>
				<li><a href="<%=contextPath%>/Pages/Profile.jsp">Profile</a></li>
			</ul>
		</div>
		<div class="content">
			<h1>Welcome Back ${username.userName}</h1>
		</div>
	</div>
</body>
</html>