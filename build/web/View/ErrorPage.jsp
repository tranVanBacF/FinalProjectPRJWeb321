<%-- 
    Document   : ErrorPage
    Created on : Mar 11, 2019, 10:46:48 PM
    Author     : bactv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"/>
        <h1> ${sessionScope.errorPage}</h1>
    </body>
</html>
