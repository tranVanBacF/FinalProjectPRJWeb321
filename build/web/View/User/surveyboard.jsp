<%-- 
    Document   : surveyboard
    Created on : Mar 10, 2019, 5:46:53 PM
    Author     : DxG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Survey Board</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            button {
                background-color: #4CAF50;
                border: none;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <button onclick="window.location.href = 'link to open'" style="margin-left: auto; margin-right: auto; display: block">Add new Survey</button>
        <c:if test="${surveys.isEmpty()}">
            <h2>You current don't have any survey</h2>;
        </c:if>
        <c:if test="${!surveys.isEmpty()}">
            <table style="width: 100%">
                <tr>
                <th style="font-style: oblique">Name</th>
                <th style="font-style: oblique">Description</th>
                <th style="font-style: oblique">Link</th>
                <th style="font-style: oblique">Status</th>
                <th style="font-style: oblique">Action</th>
            </tr>
            <c:forEach items="${surveys}" var="survey">
                <tr>
                    <th style="font-style: oblique">${survey.getName()}</th>
                    <th style="font-style: oblique">${survey.getDescription()}</th>
                    <th style="font-style: oblique">
                        <a href="submitters?id=${survey.getId()}" >${survey.getLink()}</a>
                    </th>
                    <th style="font-style: oblique">
                        <c:if test="${survey.getStatus() == 0}">
                            <span style="color: orange">Created</span>
                        </c:if>
                        <c:if test="${survey.getStatus() == 1}">
                            <span style="color: green">Running</span>
                        </c:if>
                        <c:if test="${survey.getStatus() == 2}">
                            <span style="color: red">Stopped</span>
                        </c:if>
                    </th>
                    <th style="font-style: oblique">
                        <form action="change_status" method="POST">
                            <input name="survey" value="${survey.getId()}" hidden/>
                            <c:if test="${survey.getStatus() == 0}">
                                <input name="status" value="1" hidden/>
                                <input type="submit" value="Run"/>
                            </c:if>
                            <c:if test="${survey.getStatus() > 0}">
                                <input type="submit" value="Run" disabled/>
                            </c:if>
                        </form>
                        <form action="change_status" method="POST">
                            <input name="survey" value="${survey.getId()}" hidden/>
                            <c:if test="${survey.getStatus() == 2}">
                                <input type="submit" value="Stop" disabled/>
                            </c:if>
                            <c:if test="${survey.getStatus() < 2}">
                                <input name="status" value="2" hidden/>
                                <input type="submit" value="Stop"/>
                            </c:if>
                        </form>
                            <a style="font-size: 20" href="">Edit</a>
                    </th>
                </tr>

            </c:forEach>
            </table>
        </c:if>
        <script>
            function deleteprd(id) {
                var txt;
                var r = confirm("Are you sure to delete!");
                if (r == true) {
                    location.replace("delete?id=" + id);
                } else {
                    location.replace("home");
                }
            }

            function edit(id) {
                location.replace("edit?id=" + id);
            }

            function changeStatus(survey, id) {
                location.replace("surveys/change_status?survey=" + survey + "&status=" + id);
            }
        </script>
    </body>
</html>
