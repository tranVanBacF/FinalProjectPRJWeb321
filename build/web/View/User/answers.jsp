<%-- 
    Document   : answers
    Created on : Mar 11, 2019, 11:11:01 AM
    Author     : DxG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="text-align: center">${survey.getName()}</h1>
        <br>
        <h2 style="text-align: center">${survey.getDescription()}</h2>
        
        <table style="width: 40%">
            <c:forEach items="${answers}" var="answer">
            <tr>
                <th>${questions[answer.getQuestion() - 1].getContent()}</th>
                <th>${answer.getAnswer()}</th>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
