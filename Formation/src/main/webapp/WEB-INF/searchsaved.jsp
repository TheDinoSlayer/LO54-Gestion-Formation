<%-- 
    Document   : searchsaved
    Created on : 4 janv. 2018, 15:33:28
    Author     : ag
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="bootstrap.css"/>
        <title>Search Log</title>
    </head>
    <body>
        <div class="container">
    <h1><center>Liste des recherches effectués</center></h1><br>
    <table style="width: 100%" border="1">
        <tr>
            <th>ID</th>
            <th>Mots clés</th>
            <th>Location</th>
            <th>Date</th>
            <th>Heure de début</th>
            <th>Heure de fin</th>
        </tr>
        <c:forEach items="${searches}" var="s">
            <tr>
                <td>${s.searchID}</td>
                <td>${s.keyWordFormation}</td>
                <td>${s.location}</td>
                <td>${s.date}</td>
                <td>${s.startTime}</td>
                <td>${s.endTime}</td>
            </tr>            
        </c:forEach>
    </table>
    <script src="bootstrap.js"></script>
    </div>
</body>
</html>
