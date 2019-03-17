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
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="text-align: center">${survey.getName()}</h1>
        <br>
        <h2 style="text-align: center">${survey.getDescription()}</h2>
        <c:if test="${submitters.isEmpty()}">
            <h2>Your survey don't have any submit</h2>;
        </c:if>
        <c:if test="${!submitters.isEmpty()}">
            <table style="width: 40%">
                <c:forEach items="${submitters}" var="submitter">
                <tr>
                    <th><span style="text-decoration: orangered">${submitter}</span></th>
                    <th><a href="answers?survey=${survey.getId()}&submitter=${submitter}">Show</a></th>
                </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
