<%-- 
    Document   : insertQuestion
    Created on : Mar 11, 2019, 10:33:05 PM
    Author     : TranViet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Create Question</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
    </style>
    <body class="w3-light-grey">
         <jsp:include page="../Menu.jsp"/>
        <header class="w3-display-container w3-content" style="max-width:3000px;">
            <img class="w3-image" src="./View/Image/hotel.jpg" alt="The Hotel" style="min-width:1000px" width="1500" height="800">
            <div class="w3-display-left w3-padding w3-col 30 m12">
                <div class="w3-container w3-red">
                    <h2><i class="fa w3-margin-right"></i>NEW QUESTION</h2>
                </div>
                <div class="w3-container w3-white w3-padding-16">
                    <form action="insertQuestion" method="POST">
                        <div class="w3-row-padding" style="margin:16px -16px;">
                            <div class="w3-margin-bottom">
                                <label><i class="fa fa-male"></i> Content</label>
                                <input class="w3-input w3-border" type="text" placeholder="Write content..." name="content">
                            </div>
                        </div>
                        <div class="w3-row-padding" style="margin:0 -16px;">
                            <div class="w3-half w3-margin-bottom">
                                <label><i class="fa fa-calendar-o"></i>Time</label>
                                <input class="w3-input w3-border" type="text" placeholder="YYYY MM DD" name="date" id="day" readonly>
                            </div>
                        </div>
                        <button class="w3-button w3-dark-grey" type="submit"><i class="fa fa-search w3-margin-right"></i> Submit</button>
                    </form>
                </div>
            </div>
        </header>
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
                console.log(today);
                document.getElementById(date).value = today;
            }
            a("day");
        </script>
    </body>
</html>


