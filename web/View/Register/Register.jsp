<%-- 
    Document   : Register
    Created on : Mar 15, 2019, 10:45:38 AM
    Author     : bactv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
Author: Colorlib
Author URL: https://colorlib.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
    <head>
        <title>Register Form</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Custom Theme files -->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <!-- //Custom Theme files -->
        <!-- web font -->
        <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
        <!-- //web font -->
        <script>
            function checkInfo() {

                var checkUser = document.getElementById("checkUser").textContent;


                if (checkUser.trim() != "") {
                    return false;
                }
                var password = document.myForm.password.value;
                var RePassword = document.myForm.rePassword.value;
                if (password === RePassword) {
                    return true;
                } else {
                    alert(" pass word retype is not match")
                    document.getElementById("RetypePass").innerHTML = "pass word retype is not match";
                    return false;
                }
            }

        </script>

    </head>
    <body>
        <jsp:include page="../Menu.jsp"/>

        <!-- main -->
        <div class="main-w3layouts wrapper">
            <h1 style="color: red">${emptyMessage}</h1>
            <h1 style="color: red">${sessionScope.MyException}</h1>
            <h1 style="color: red">${sessionScope.responseRegister}</h1>

            <h1>Register Form</h1>
            <div class="main-agileinfo">
                <div class="agileits-top">
                    <form action="/14_ProjectFinalPRJ321/RegisterUserController" method="post" onsubmit=" return checkInfo()" name="myForm">
                        <input class="text" type="text" name="name" placeholder="name" value="${name}" required="">
                        <input class="text email" type="email" name="email" placeholder="Email" value="${email}" required="">
                        <h5 style="color: white"> Birthday:</h5>
                        <input  type="date" name="birthday" placeholder="birthday" value="${birthday}"  required>
                        <br>
                        <br>

                        <h5 style="color: white">  Registration Date</h5>

                        <input type="date" id="day" name="registrationDate" value="${registrationDate}" readonly>
                        <br>
                        <br>
                        <input type="text" name="username" placeholder="user name" onkeyup="checkUser()" value="${username}" required><p style="display: inline ; color: red"  id="checkUser"> </p>
                        <br>
                        <br>
                        <input class="text" type="password" name="password" placeholder="Password" required="">
                        <input class="text w3lpass" type="password" name="rePassword" placeholder="Confirm Password" required=""><p style="display: inline ; color: red"  id="RetypePass"> </p>
                        <!--                        <div class="wthree-text">
                                                    <label class="anim">
                                                        <input type="checkbox" class="checkbox" required="">
                                                        <span>I Agree To The Terms & Conditions</span>
                                                    </label>
                                                    <div class="clear"> </div>
                                                </div>-->
                        <input type="submit" value="Register">
                    </form>
                    <!--<p>Don't have an Account? <a href="#"> Login Now!</a></p>-->
                </div>
            </div>
            <!-- copyright -->
            <div class="colorlibcopy-agile">
                <!--<p>© 2018 Colorlib Signup Form. All rights reserved | Design by <a href="https://colorlib.com/" target="_blank">Colorlib</a></p>-->
            </div>
            <!-- //copyright -->
            <ul class="colorlib-bubbles">
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </div>
        <!-- //main -->
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