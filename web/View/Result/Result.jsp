<%-- 
    Document   : AnswerQuestion
    Created on : Mar 19, 2019, 10:31:36 PM
    Author     : bactv
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Contact V4</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->

        <!--===============================================================================================-->
        <!--===============================================================================================-->
        <!--===============================================================================================-->

        <!--===============================================================================================-->
        <!--===============================================================================================-->
        <!--===============================================================================================-->
        <!--===============================================================================================-->
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
        <style>
            input[type="text"], input[type="email"], input[type="password"], input[type="date"] {
                font-size:1em;

                font-weight: 100;
                width: 94.5%;
                display: block;
                border: none;
                padding: 0.8em;
                border: solid 1px rgba(255, 255, 255, 0.37);
                -webkit-transition: all 0.3s cubic-bezier(0.64, 0.09, 0.08, 1);
                transition: all 0.3s cubic-bezier(0.64, 0.09, 0.08, 1);
                background: -webkit-linear-gradient(top, rgba(255, 255, 255, 0) 96%, #fff 4%);
                background: linear-gradient(to bottom, rgba(255, 255, 255, 0) 96%, #fff 4%);
                background-position: -800px 0;
                background-size: 100%;
                background-repeat: no-repeat;
                color: blue;
                font-family: 'Roboto', sans-serif;
                border: 1px solid #d66
            }
        </style>
    </head>
    <body>


        <div class="container-contact100">
            <!--<h1 style="color: brown">  ${resultMessage}</h1>-->

            <div class="wrap-contact100">
                <h1 style="color: brown"> ${resultMessage}</h1>

                <h3 style="color: background"> Please answer all question before submit</h3>
            </div>
        </div>




    </body>
</html>
