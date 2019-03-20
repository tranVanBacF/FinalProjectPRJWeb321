<%-- 
    Document   : newSurveyForm
    Created on : Mar 11, 2019, 2:19:20 PM
    Author     : TranViet
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DAO.ConvertStringToDateDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <title>Edit Question</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <body class="w3-content" style="max-width:1300px">
        <!-- Third Grid: Swing By & Contact -->
        <div class="w3-row" id="contact">
            <div class="w3-dark-grey w3-container" style="height:700px">
                <div class="w3-padding-64 w3-padding-large">
                    <h1>Edit Question</h1>
                    <!--<p class="w3-opacity">GET IN TOUCH</p>-->
                    <form class="w3-container w3-card w3-padding-32 w3-white" action="editQuestion" method="POST">
                        <c:if test="${not empty questions}">
                        <div class="w3-section">
                        <label>Description</label>
                                <input class="w3-input" style="width:100%;" type="text" placeholder="Write Content ..." name="description" value=${questions.getContent()} />
                        </div>
                        </c:if>
                                <!--<c:if test="${empty questions}">-->
                                <!--<input class="w3-input" style="width:100%;" type="text" placeholder="Write Content ..." name="description"  >-->
                            <!--</c:if>-->
                        <div class="w3-section">
                            <label>Date</label>
                            <input class="w3-input" style="width:100%;" type="text" name="date" id="day" readonly>
                        </div>
                        <input type="hidden" name="id" value=${id} readonly>
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