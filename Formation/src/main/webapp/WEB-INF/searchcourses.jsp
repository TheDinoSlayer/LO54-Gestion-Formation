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
        <form>
            Titre : <input type="text" name="title"/><br>
            Date : <input type="date" name="date"/><br>
            Lieu : 
            <select name="location">
                <option value=""></option>
                <c:forEach items="${locations}" var="l">
                    <option value="${l.id}">${l.city}</option>
                </c:forEach>
            </select><br>
            Heure début : <input type="time" name="startHour"/><br>
            Heure fin : <input type="time" name="endHour"/><br>
            <input type="submit" value="Rechercher"/><br>
        </form>
        <br>
        <table style="width: 100%">
            <tr>
                <th>Code</th>
                <th>Formation</th>
                <th>Lieu</th>
                <th>Date de début</th>
                <th>Date de fin</th>
            </tr>
        </table>
    </body>
</html>
