<%-- 
    Document   : Login
    Created on : Mar 11, 2019, 4:32:33 PM
    Author     : bactv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
         <jsp:include page="Menu.jsp"/>
         <h1 style="color: red">${sessionScope.loginError}</h1>
         <form action="/14_ProjectFinalPRJ321/LoginController" method="post">
             UserName<input type="text" name="userName" required value="${sessionScope.userName}">
             <br>
             <br>
             PassWord<input type="password" name="passWord" required>
             <br>
             <br>
             <input type="submit" value="Login">
         </form>
    </body>
</html>
