<%-- 
    Document   : Home
    Created on : Mar 15, 2019, 11:30:52 AM
    Author     : bactv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta charset="UTF-8">
        <title>Home</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">


        <link rel="stylesheet" href="css/style.css">


    </head>

    <body>
         <p>
            <a href="/View/Home.jsp">Home</a>
            <a href="/View/User/Other.jsp">Manage Survey</a>
            <c:if test="${empty sessionScope.user}">
                <a href="/View/Login/Login.jsp">Login</a>
                <a href="/View/Register/Register.jsp">Register</a>
            </c:if>
            <c:if test="${not empty sessionScope.user}">
                Welcome ${sessionScope.user.username} <a href="/RemoveSession">(Logout)</a>
            </c:if>
        </p>
        <nav role='navigation' id="mainnav">
            <ul>
                <li><a href="#?">Home</a></li>
                <li><a href="#?">About</a></li>
                <li><a href="#?">Clients</a></li>
                <li><a href="#?">Contact Us</a></li>
            </ul>
        </nav>  

        <div class="hamb">
            <a href="#"><i class="fa fa-bars"></i></a>
        </div>

        <div class="hero">
            <h1>Canvas navigation</h1>
        </div>

        <canvas id="bubble"></canvas>


        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>



        <script  src="js/index.js"></script>




    </body>

</html>
