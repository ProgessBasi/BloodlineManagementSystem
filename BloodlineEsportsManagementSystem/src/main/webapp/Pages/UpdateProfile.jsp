<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="utils.StringUtils"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Profile Page</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/StyleSheets/update.css">
</head>
<body>
    <div class="wrapper">
        <form action="<%=request.getContextPath()%>/modifyUserProfile" method="post">
            <input type="hidden" name="updateId" value="${username}">
            <h1>Update Profile</h1>
            <div class="input-row">
                <div class="input-box">
                    <input type="text" placeholder="Full Name" name="UfullName" value="${username.fullName}" required>
                    <i class='bx bxs-user'></i>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Username" name="Uusername" value="${username.userName}" required>
                    <i class='bx bxs-user'></i>
                </div>
            </div>
            <div class="input-row">
                <div class="input-box">
                    <input type="email" placeholder="Email" name="Uemail" value="${username.email}" required>
                    <i class='bx bxs-envelope'></i>
                </div>
                <div class="input-box">
                    <input type="tel" placeholder="Phone Number" name="UphoneNumber" value="${username.phoneNumber}" required>
                    <i class='bx bxs-phone'></i>
                </div>
            </div>
            <div class="input-row">
                <div class="input-box">
                    <input type="text" placeholder="Country" name="Ucountry" value="${username.country}" required>
                    <i class='bx bxs-globe'></i>
                </div>
                <div class="input-box">
                    <input type="password" placeholder="Password" name="Upassword" value="${username.password}" required>
                    <i class='bx bxs-lock-alt'></i>
                </div>
            </div>
            <button type="submit" class="btn">Update</button>
            <div class="login-link">
                <p><a href="<%=request.getContextPath()%>/Pages/Profile.jsp">Go back to Profile?</a></p>
            </div>
            <% String errMsg = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
            String successMsg = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);

            if (errMsg != null) { %>
            <h2 class="error-msg" style="color: red; font-size: smaller;"><%=errMsg%></h2>
            <% }

            if (successMsg != null) { %>
            <p style="color: red; font-size: smaller;"><%=successMsg%></p>
            <% } %>
        </form>
    </div>
</body>
</html>