<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index Page</title>
    <link rel="stylesheet" href="StyleSheets/Index.css">
</head>
<body>
	<div class="banner">
		<div class="navbar">
			<h1 class="logo" style="color: white;"> BLooDL!NE </h1>
			<ul>
				<li><a href="<%=contextPath%>/Index.jsp">Home</a></li>
				<li><a href="<%=contextPath%>/Pages/UnloginPlayer.jsp">Players</a></li>
			</ul>
		</div>
			<div class="content"> 
				<h1>THE BLOODLINE</h1>
				<br>
				<p>GET TO KNOW ABOUT THE BEST PLAYERS OF THE WORLD</p>
				<div >
				<button type="button" onclick="window.location.href='Pages/login.jsp'"><span></span> Login </button>
				<button type="button" onclick="window.location.href='Pages/register.jsp'"><span></span> Register </button>
				</div>
			</div>
	</div>
</body>
</html>