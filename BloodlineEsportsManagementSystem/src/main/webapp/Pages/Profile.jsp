<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="utils.StringUtils"%>
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
<title>Profile Page</title>
<link rel="stylesheet" href="<%=contextPath%>/StyleSheets/Profile.css">
</head>
<style>

.button-group {
    display: flex; /* Make button-group a flex container */
    justify-content: center; /* Center align the buttons */
    margin-top: 20px;
}

.button-group button {
    width: 200px;
    padding: 15px 0;
    text-align: center;
    margin: 20px 10px;
    border-radius: 25px;
    font-weight: bold;
    border: 2px solid #009688;
    background: #fff;
    color: #000;
    cursor: pointer;
    position: relative;
    overflow: hidden;
}

.button-group button:hover {
    color: #fff;
    background: black;
}

</style>

<body>
    <div class="banner">
        <div class="navbar">
            <h1 class="logo" style="color: white;">BLooDL!NE</h1>
            <ul>
                <li><a href="<%=contextPath%>/Pages/AdminHome.jsp">Home</a></li>
                <li><a href="<%=contextPath%>/Pages/PlayerUser.jsp">Player</a></li>
                <li><a href="<%=contextPath%>/Pages/Profile.jsp">Profile</a></li>
            </ul>
        </div>
        <div class="content">
            <h1>Profile Details</h1>
            <div class="profile-details">
                <p><strong>Full Name: ${username.fullName}</strong></p>
                <br>
                <p><strong>Username: ${username.userName}</strong></p>
                <br>
                <p><strong>Email: ${username.email}</strong></p>
                <br>
                <p><strong>Country: ${username.country}</strong></p>
                <br>
                <p><strong>Phone Number: ${username.phoneNumber}</strong></p>
                <br>
                <p><strong>Date Of Birth: ${username.DOB}</strong></p>
            </div>
            <br>
            <div class="button-group">
                <button onclick="location.href='<%=contextPath%>/Pages/UpdateProfile.jsp'">Update</button>
                <form id="deleteForm-${username.userName}" method="post"
                    action="<%=contextPath + StringUtils.SERVLET_URL_MODIFY_USER_PROFILE %>">
                    <input type="hidden" name="<%=StringUtils.DELETE_ID %>" value="${username.userName}" />
                    <button type="button" onclick="confirmDelete('${username.userName}')">Delete</button>
                </form>
                <form id="logoutForm" action="<%=contextPath + "/Logout"%>" method="post">
                <button type="submit">Logout</button>
            </form>
        </div>
            </div>
    </div>
</body>
<script>
    function confirmDelete(userName) {
        if (confirm("Are you sure you want to delete your account: " + "?")) {
            document.getElementById("deleteForm-" + userName).submit();
        }
    }
</script>
</html>