<%-- 
    Document   : index
    Created on : Oct 28, 2019, 2:19:57 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>JPA Application</h1>
        <h2>Usernames in Database</h2>
        <c:forTokens var="username" delims="," items="${requestScope.namesList}">
            ${username}<br>
        </c:forTokens>
        ${requestScope.message}
            <h2>Add Username</h2>
            <form action="JPAcontroller" method="POST">
                Enter username: <input type="text" name="username"><br>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Add">
            </form>
            <h2>Delete Username</h2>
            <form action="JPAcontroller" method="POST">
                Enter username: <input type="text" name="username"><br>
                <input type="hidden" name="action" value="delete">
                <input type="submit" value="Delete">
            </form>
            <h2>Update Username</h2>
            <form action="JPAcontroller" method="POST">
                Enter username: <input type="text" name="username"><br>
                Update to: <input type="text" name="newUsername"><br>
                <input type="hidden" name="action" value="update">
                <input type="submit" value="Update">
            </form>
                
    </body>
</html>
