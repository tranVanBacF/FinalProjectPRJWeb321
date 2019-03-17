<%-- 
    Document   : Register
    Created on : Mar 11, 2019, 10:56:54 PM
    Author     : bactv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <script>
            var checkValidate = false;
            function checkUser() {
                var xHttp;
                var username = document.myForm.username.value;
                //  alert(username)
                if (username === "") {
                    return;
                }
                var url = "/14_ProjectFinalPRJ321/CheckUserController?username=" + username;

                if (window.XMLHttpRequest) {
                    //    alert("window")
                    xHttp = new XMLHttpRequest();
                } else {
                    //  alert("not window")
                    xHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xHttp.onreadystatechange = function () {
                    //alert("state")

                    if (xHttp.readyState == 4) {
                        // alert("re 4")
                        var data = xHttp.responseText;
                        //  alert(data)
//                        if (data == "") {
//                            checkValidate = false;
//                        } else {
//                            checkValidate = true;
//                        }
                        document.getElementById("checkUser").innerHTML = data;
                    }
                }
                xHttp.open("post", url, true);
                xHttp.send();
            }
            function checkInfo() {
                checkUser()
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
        <jsp:include page="Menu.jsp"/>
        <h1>${responseRegister}</h1>
        <h1 style="color: blue"> Register</h1>
        <form action="/14_ProjectFinalPRJ321/RegisterUserController" method="post" onsubmit=" return checkInfo()" name="myForm">
            Name<input type="text" name="name" required>
            <br>
            <br>
            Email<input type="email" name="email" required>
            <br>
            <br>
            Birthday <input type="date" name="birthday" required>
            <br>
            <br>
            Registration Date <input type="date" id="day" name="registrationDate" readonly>
            <br>
            <br>
            username<input type="text" name="username" onkeyup="checkUser()" required><p style="display: inline ; color: red"  id="checkUser"> </p>
            <br>
            <br>
            password <input type="password" name="password" required>
            <br>
            <br>
            retype password<input type="password" name="rePassword" required> <p style="display: inline ; color: red"  id="RetypePass"> </p>
            <br>
            <br>
            <input type="submit" value="Register">

        </form>
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
                var today = yyyy + '-' + mm + '-' + dd ;
                console.log(today)
                document.getElementById(date).value = today;
            }
            a("day");
        </script>
    </body>
</html>
