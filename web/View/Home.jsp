<%-- 
    Document   : Home
    Created on : Mar 11, 2019, 6:30:42 PM
    Author     : bactv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"/>
        <h1>hello ${sessionScope.user.getName()}</h1>
    </body>
</html>
