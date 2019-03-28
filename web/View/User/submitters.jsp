<%-- 
    Document   : submitters
    Created on : Mar 10, 2019, 11:06:48 PM
    Author     : DxG
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submitters of survey</title>
        <style>
            table{
                font-family: sans-serif;
                width: 80%;
            }
            th, td {
                
                font-size: 30;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../Menu.jsp"/>
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
        <c:if test="${submitters.isEmpty()}">
            <h2>Your survey don't have any submit</h2>;
        </c:if>
        <c:if test="${empty systemException}">
            <c:if test="${!submitters.isEmpty()}">
            <table>
                <tr>
                    <th><h3>Submitter</h3></th>
                    <th></th>
                    
                </tr>
                <c:forEach items="${submitters}" var="submitter">
                <tr>
                    <th><span style="text-decoration: orangered">${submitter}</span></th>
                    <th><a href="answers?survey=${survey.getId()}&submitter=${submitter}">Show!</a></th>
                </tr>
                </c:forEach>
            </table>
            </c:if>
        </c:if>
    </body>
</html>
