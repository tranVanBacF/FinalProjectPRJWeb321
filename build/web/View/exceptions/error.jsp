<%-- 
    Document   : error
    Created on : Mar 4, 2019, 12:50:21 PM
    Author     : TranViet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ErrorPage:</title>
    </head>
    <body>
        <h1>ErrorPage:</h1>
        <h2>Error Code: ${error.errorCode} </h2>
        <h2>Error Message: ${error.message} </h2>
    </body>
</html>

