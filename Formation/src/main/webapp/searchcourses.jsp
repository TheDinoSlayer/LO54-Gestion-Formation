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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form>
            Titre : <input type="text" name="title"/>
            Date : <input type="date" name="date"/>
            Lieu : 
            <select name="location">
                
                <c:forEach items="${locations}" var="l">
                    <option value="${l.id}">${l.city}</option>
                </c:forEach>
            </select>
            Heure début : <input type="time" name="startHour"/>
            Heure fin : <input type="time" name="endHour"/>
        </form>
    </body>
</html>
