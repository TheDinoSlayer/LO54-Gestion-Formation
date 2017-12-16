<%-- 
    Document   : searchcourses
    Created on : 1 déc. 2017, 17:04:30
    Author     : ag
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recherche de cours</title>
    </head>
    <body>
        <form action="/formation/searchcourses" method="post">
            Formation : <input type="text" name="title" value="${title}"/><br>
            Date : <input type="date" name="date"/><br>
            Lieu : 
            <select name="location">
                <option value=""></option>
                <c:forEach items="${locations}" var="l">
                    <option value="${l.city}">${l.city}</option>
                </c:forEach>
            </select><br>
            Heure début : <input type="time" name="startHour"/><br>
            Heure fin : <input type="time" name="endHour"/><br>
            <input type="submit" value="Rechercher"/><br>
        </form>
        <br>
        <table style="width: 100%" border="1">
            <tr>
                <th>Code</th>
                <th>Formation</th>
                <th>Lieu</th>
                <th>Date de début</th>
                <th>Date de fin</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${courseSessions}" var="cs">
                <tr>
                    <td>${cs.course.code}</td>
                    <td>${cs.course.title}</td>
                    <td>${cs.location.city}</td>
                    <td>${cs.startDate}</td>
                    <td>${cs.endDate}</td>
                    <td>
                        <form action="/formation/registercourses">
                            <button type="submit" value="${cs.id}" name="course">S'inscrire</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
