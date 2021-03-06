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


        <div class="container-contact100" >

            <div class="wrap-contact100">
                <h1>${emptyMessage}</h1>
                <h1>${messageErrorAnswer}</h1>
                <center><h1 style="color: brown"> Welcome to our Survey</h1></center>
                <br>
                <c:if test="${not empty survey}">
                    <center><h1> ${survey.getName()}</h1></center>
                    </c:if>
                    <c:if test="${not empty survey}">
                    <center><h2> ${survey.getDescription()}</h2></center>
                    </c:if>
                <br>
                <h3 style="color: background"> Please answer all question before submit</h3>

                <form class="contact100-form validate-form" action="/SaveForm" method="post">
                    <c:if test="${not empty survey}">
 <!--                    <h2> ${survey.getDescription()}</h2>-->
                        <input type="hidden" name="id"  value="${survey.getId()}">
                    </c:if>
                    <br>

                    <c:if test="${currentPage == 1}">
                        <h5 >  Submitter</h5>
                        <input type="text" name="submiter" placeholder="submitter" value="${submiter}" required>
                        <br>
                        <h5 >  Registration Date</h5>

                        <input type="date" id="day" name="registrationDate" value="${registrationDate}" readonly>
                    </c:if>


                    <table border='1'>
                        <c:forEach items="${listQuestion}" var="list">

                            Question  ${list.getOrderDisplay()}:    ${list.getContent()}



                            <br>
                            Anwser
                            <!--<textarea rows="4" cols="100" style="border:dotted 2px orange; font-size: 20px " name="${list.getId()}" value="${list.getTemporaryAnswer()}" required="required"></textarea>-->
                            <input type="text" name="${list.getId()}" value="${list.getTemporaryAnswer()}" required="required" value="${survey.getId()}">

                            <br>
                            <br>
                        </c:forEach>
                    </table>
                    <c:if test="${listQuestion.size() == 0}">
                        <h4> there is no more question , you can submit</h4>

                    </c:if>
                    <h4>Page ${currentPage} </h4>
                    <c:if test="${currentPage   >1 }">
                        <input style="display: inline-block; width:60px"   type="submit" name="decrease" value="<<<">
                    </c:if>
                    <input type="hidden" name="currentPage"  value="${currentPage}">
                    <input style="display: inline-block; width: 60px"  type="submit" name="pageSubmit"  value="1">
                    <input style="display: inline-block; width:60px"  type="submit" name="pageSubmit" value="2">
                    <input style="display: inline-block; width:60px"   type="submit" name="pageSubmit" value="3">
                    <c:if test="${currentPage  < 3}">
                        <input style="display: inline-block; width:60px"   type="submit" name="increase" value=">>>">
                    </c:if>
                    <c:if test="${currentPage == 3}">
                        <input style="display: inline-block" type="submit" name="Submit" value="Submit">
                    </c:if>
                </form>
            </div>
        </div>

        <script>
            function a(date) {
                var today = new Date();
                var dd = today.getDate();
                var mm = today.getMonth() + 1; //January is 0!

                var yyyy = today.getFullYear();
                if (dd < 10) {
                    dd = '0' + dd;
                }
                if (mm < 10) {
                    mm = '0' + mm;
                }
                var today = yyyy + '-' + mm + '-' + dd;
                console.log(today)
                document.getElementById(date).value = today;
            }
            a("day");
        </script>


    </body>
</html>
