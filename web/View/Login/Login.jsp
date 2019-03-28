<%-- 
    Document   : Login
    Created on : Mar 15, 2019, 11:22:28 AM
    Author     : bactv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta charset="UTF-8">
        <title> Login form</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">


        <link rel="stylesheet" href="css/style.css">


    </head>

    <body>
        <jsp:include page="../Menu.jsp"/>
        <div class="login-container">
            <div class="login-header">
                <h1 style="color: red">${sessionScope.loginError}</h1>
                <h1 style="color: red">${sessionScope.MyException}</h1>

                <h1 title="login">Login</h1>
                <p title="close">x</p>
            </div>
            <div class="login-form">
                <form action="/LoginController" method="post">
                    <input type="text" placeholder="Username"  name="userName" required value="${sessionScope.userName}"/>
                    <br /><br />
                    <input type="password" placeholder="Passowrd"  name="passWord"/>
                    <br /><br />
                    <input title="login" type="submit" value="Login" />
                    <br /><br />
                    <a title="sign up">Sign up</a>
                </form>
            </div>
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>



        <script  src="js/index.js"></script>




    </body>

</html>
