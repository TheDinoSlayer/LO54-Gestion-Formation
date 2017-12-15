<%-- 
    Document   : addokclient
    Created on : 15 déc. 2017, 11:45:35
    Author     : ag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription réussie</title>
    </head>
    <body>
        ${client.firstName} ${client.lastName} a été enregistré dans ce cours :<br>
        ${client.courseSession.course.code}<br>
        ${client.courseSession.course.title}<br>
        ${client.courseSession.location.city}<br>
        ${client.courseSession.startDate}<br>
        ${client.courseSession.endDate}<br>
        <br>
        <a href="/formation/searchcourses">Rechercher un cours</a><br>
        <a href="index.html">Revenir à l'accueil</a>        
    </body>
</html>
