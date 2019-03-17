<%-- 
    Document   : Home
    Created on : Mar 15, 2019, 11:30:52 AM
    Author     : bactv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <a href="/14_ProjectFinalPRJ321/View/Home.jsp">Home</a>
            <a href="/14_ProjectFinalPRJ321/View/User/Other.jsp">Manage Survey</a>
            <c:if test="${empty sessionScope.user}">
                <a href="/14_ProjectFinalPRJ321/View/Login/Login.jsp">Login</a>
                <a href="/14_ProjectFinalPRJ321/View/Register/Register.jsp">Register</a>
            </c:if>
            <c:if test="${not empty sessionScope.user}">
                Welcome ${sessionScope.user.username} <a href="/14_ProjectFinalPRJ321/RemoveSession">(Logout)</a>
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
