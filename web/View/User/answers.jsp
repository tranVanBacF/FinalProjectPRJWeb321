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
        <title>Answer details</title>
    </head>
    <body>
        <jsp:include page="../Menu.jsp"/>
        <h3 style="text-align: center; color: red">Submit of ${submitter}</h3>
        <br>
        <h1 style="text-align: center; color: red; font-family: sans-serif">${survey.getName()}</h1>
        <br>
        <h2 style="text-align: center; color: yellow; font-family: sans-serif">${survey.getDescription()}</h2>
        <c:if test="${not empty exception}">
            <h2>${exception}</h2>
        </c:if>
        <c:if test="${not empty systemException}">
            <h2>${systemException}</h2>
        </c:if>
        <c:if test="${empty systemException}">
        <table style="width: 80%; margin-left: auto; margin-right: auto; font-family: sans-serif">
             <tr>
                <th>Question</th>
                <th>Answer</th>
                <th>Time</th>
            </tr>
            <c:forEach items="${answers}" var="answer">
            <tr>
                <th>${questions.get(answers.indexOf(answer)).getContent()}</th>
                <th>${answer.getAnswer()}</th>
                <th>${answer.getSubmitDate()}</th>
            </tr>
            </c:forEach>
        </table>
        </c:if>
    </body>
</html>
