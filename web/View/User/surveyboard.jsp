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
            table{
                border: 1px solid black;
                border-collapse: collapse;
                border-color: #A0FF77; 
                width: 100%;
                font-family: sans-serif;
            }
            th, td {
                border: 1px solid black;
                border-collapse: collapse;
                border-color: #A0FF77; 
                font-size: 30;
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
            form {
                display: inline;
            }
            a {
              text-decoration: none;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../Menu.jsp"/>
        <button onclick="window.location.href = 'createSurvey'" style="margin-left: auto; margin-right: auto; display: block">Add new Survey</button>
        <br>
        <c:if test="${not empty exception}">
            <h2>${exception}</h2>
        </c:if>
        <c:if test="${surveys.isEmpty()}">
            <h2>You current don't have any survey</h2>;
        </c:if>
        <c:if test="${!surveys.isEmpty()}">
            <table>
            <tr>
                <th style="color: #ffffff">Name</th>
                <th style="color: #ffffff">Description</th>
                <th style="color: #ffffff">Link</th>
                <th style="color: #ffffff">Status</th>
                <th style="color: #ffffff">Action</th>
            </tr>
            <c:forEach items="${surveys}" var="survey">
                <tr>
                    <th>${survey.getName()}</th>
                    <th>${survey.getDescription()}</th>
                    <th style="font-style: oblique">
                        <c:if test="${not empty survey.getLink()}">
                            <a href="submitters?id=${survey.getId()}" >${survey.getLink()}</a>
                        </c:if>
                        <c:if test="${empty survey.getLink()}">
                            Unavailable
                        </c:if>
                            
                    </th>
                    <th>
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
                    <th>
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
                            <br>
                            <c:if test="${survey.getStatus() == 0}">
                                <a style="font-size: 20; color: blue" href="editSurvey?id=${survey.getId()}">Edit</a>
                            </c:if>
                            <c:if test="${!(survey.getStatus() == 0)}">
                                <a style="pointer-events: none; display: inline-block;" href="#">Edit</a>
                            </c:if>
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
                location.replace("" + id);
            }

            function changeStatus(survey, id) {
                location.replace("surveys/change_status?survey=" + survey + "&status=" + id);
            }
        </script>
    </body>
</html>
