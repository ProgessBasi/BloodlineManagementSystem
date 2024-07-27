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
/* Box styling */
.player-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
}

.player-box {
    background-color: #333;
    color: white;
    border-radius: 10px;
    padding: 20px;
    margin-bottom: 20px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 300px;
    transition: all 0.3s ease; /* Add transition for smooth hover effect */
}

.player-box:hover {
    transform: translateY(-5px); /* Move the box up slightly on hover */
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* Add a stronger shadow on hover */
}

/* Table styling */
.user-data table {
    display: none; /* Hide the table when using box layout */
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

/* Search bar styling */
.search-bar {
    margin-bottom: 20px;
    text-align: center;
}

.search-input {
    width: 300px;
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ccc;
    font-size: 16px;
}

.search-button {
    padding: 10px 20px;
    border: none;
    background-color: #4CAF50;
    color: white;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
}
</style>
</head>
<body>
    <div class="banner">
        <div class="navbar">
            <h1 class="logo" style="color: white;">BLooDL!NE</h1>
            <ul>
                <li><a href="<%=contextPath%>/Index.jsp">Home</a></li>
                <li><a href="<%=contextPath%>/Pages/UnloginPlayer.jsp">Players</a></li>
            </ul>
        </div>
        <!-- Search bar -->
        <div class="search-bar">
            <input type="text" id="searchInput" class="search-input" placeholder="Search...">
            <button id="searchButton" class="search-button">Search</button>
        </div>
        <!-- Displaying player data -->
        <div class="user-data">
            <h2 style="color: white; text-align: center;">Top Players in the World</h2>
            <br>
            <br>
            <br>
            <div class="player-container">
                <c:forEach var="player" items="${playerLists}">
                    <div class="player-box">
                        <p><strong>Full Name:</strong> ${player.playerName}</p>
                        <p><strong>Username:</strong> ${player.playerUsername}</p>
                        <p><strong>Country:</strong> ${player.country}</p>
                        <p><strong>Team:</strong> ${player.team}</p>
                        <p><strong>HS(%):</strong> ${player.playerHS}</p>
                        <p><strong>Role:</strong> ${player.playerRole}</p>
                        <p><strong>PlayerACS:</strong> ${player.playerACS}</p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <!-- JavaScript for search functionality -->
    <script>
    document.getElementById("searchButton").addEventListener("click", function() {
        var input, filter, container, playerBoxes, playerUsername, i;
        input = document.getElementById("searchInput");
        filter = input.value.toUpperCase();
        container = document.querySelector(".user-data");
        playerBoxes = container.querySelectorAll(".player-box");

        for (i = 0; i < playerBoxes.length; i++) {
            playerUsername = playerBoxes[i].querySelectorAll("p")[1]; // Second <p> element contains username
            if (playerUsername.innerText.toUpperCase().indexOf(filter) > -1) {
                playerBoxes[i].style.display = "";
            } else {
                playerBoxes[i].style.display = "none";
            }
        }
    });
</script>
</body>
</html>