<%-- 
    Document   : registercourse
    Created on : 6 déc. 2017, 17:20:51
    Author     : ag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription au cours</title>
    </head>
    <body>
        <form>
            Formation : <input type="text" name="formation" value="${courseSession.course.title}" readonly/><br>
            Nom : <input type="text" name="lastname" required/><br>
            Prénom : <input type="text" name="forename" required/><br>
            Adresse : <input type="text" name="address" required/><br>
            Téléphone : <input type="tel" name="phone" required pattern="[0-9]{10}"/><br>
            E-mail : <input type="email" name="email"/><br>
            <input type="submit" value="Inscription"/><br>
        </form>
    </body>
</html>
