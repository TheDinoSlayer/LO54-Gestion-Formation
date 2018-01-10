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
        <link type="text/css" rel="stylesheet" href="bootstrap.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recherche de cours</title>
    </head>
    <body>
        <div class="container">
            <form action="/formation/searchcourses" method="post">
               Formation :<input type="text" name="title" value="${title}"/><br>
               Date :</td> <td align="right"><input type="date" name="date"/><br>
               Lieu : </td> <td align="right">
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
            <table class="table table-striped" style="width: 100%" border="1">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Formation</th>
                        <th>Lieu</th>
                        <th>Date de début</th>
                        <th>Date de fin</th>
                    </tr> 
                </thead>

                <c:forEach items="${courseSessions}" var="cs">
                    <tbody>
                    <tr>
                        <td>${cs.course.code}</td>
                        <td>${cs.course.title}</td>
                        <td>${cs.location.city}</td>
                        <td>${cs.startDate}</td>
                        <td>${cs.endDate}</td>
                        <td>
                            <form action="/formation/registercourses">
                                <button type="submit" value="${cs.id}" name="course" class="btn btn-success"><i class="icon-plus icon-white"></i>S'inscrire</button>
                            </form>
                        </td>
                    </tr>
                    </tbody>>
                </c:forEach>
            </table>
            <script src="bootstrap.js"></script>
        </div>
    </body>
</html>
