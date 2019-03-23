<%-- 
    Document   : newSurveyForm
    Created on : Mar 11, 2019, 2:19:20 PM
    Author     : TranViet
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DAO.ConvertStringToDateDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <title>Create Survey</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <body class="w3-content" style="max-width:1300px">
         <jsp:include page="../Menu.jsp"/>
        <div class="w3-row" id="contact">
            <div class="w3-dark-grey w3-container" style="height:700px">
                <div class="w3-padding-64 w3-padding-large">
                    <h1>Create Survey</h1>
                    <form class="w3-container w3-card w3-padding-32 w3-white" action="createSurvey" method="POST">
                        <div class="w3-section">
                            <label>Name</label>
                            <input class="w3-input" style="width:100%;" type="text" name="name">
                        </div>
                        <div class="w3-section">
                            <label>Description</label>
                            <input class="w3-input" style="width:100%;" type="text" name="description">
                        </div>
                        <div class="w3-section">
                            <label>Date</label>
                            <input class="w3-input" style="width:100%;" type="text" name="date" id="day" readonly>
                        </div>
                        <c:if test="${ not empty sessionScope.user}">
                            <input type="hidden" name="user" value=${sessionScope.user.getUsername()}>

                        </c:if>
                        <c:if test="${  empty sessionScope.user}">
                            <input type="hidden" name="user" >
                        </c:if>
                        <input type="hidden" name="link" value="">
                        <button type="submit" class="w3-button w3-teal w3-right">Send</button>
                    </form>
                </div>
            </div>
        </div>


        <h1>${error}</h1>
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
        <!-- Footer -->
        <footer class="w3-container w3-black w3-padding-16">
        </footer>

    </body>
</html>