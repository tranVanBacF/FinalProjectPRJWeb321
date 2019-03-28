<%-- 
    Document   : menu
    Created on : Mar 11, 2019, 6:59:11 PM
    Author     : bactv
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Page</title>
        <style>
            body {    width: 100%;
                      min-height: 600px;
                      margin: 0;
                      /* background-color: #1abc9c; */
                      background-image: linear-gradient(to bottom, #c8d9f4, #c8d9f4);}

            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
                position: fixed;
                top: 0;
                width: 100%;
            }

            li {
                float: left;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover:not(.active) {
                background-color: #111;
            }

            .active {
                background-color: #4CAF50;
            }
            
        </style>
    </head>
    <body>
        <ul>
            <li><a  href="/surveys">Manage Survey</a></li>
                <c:if test="${empty sessionScope.user}">
                <li><a href="/View/Login/Login.jsp">Login</a></li>
                <li> <a href="/View/Register/Register.jsp">Register</a></li>

            </c:if>
            <c:if test="${not empty sessionScope.user}">
                <li><a style="color: red; font-size: 100%">Welcome ${sessionScope.user.username}</a></li>
                <li>     <a href="/RemoveSession">(Logout)</a></li>

            </c:if>
            <!--<li><a href="#contact">Contact</a></li>-->
            <!--<li><a href="#about">About</a></li>-->
        </ul>
        <p style="margin-top: 3% ">
            
            
        </p>
      
    </body>
</html>
