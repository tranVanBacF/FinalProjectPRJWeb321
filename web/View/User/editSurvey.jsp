
<%-- 
    Document   : addQuestion
    Created on : Mar 11, 2019, 9:46:41 PM
    Author     : TranViet
--%>

<%@page import="Entity.Question"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
    <title>Edit Survey</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <body class="w3-content" style="max-width:1300px">
         <jsp:include page="../Menu.jsp"/>
        <!-- Second Grid: Work & Resume -->
        <div class="w3-row">
            <div class="w3-indigo w3-container" style="min-height:800px">
                <div class="w3-padding-64 w3-center">
                    <h2>Question</h2>
                    <a href="insertQuestion"> <h2 style="text-align:left;">Create Question</h2></a>
                    <p>All Question Of Survey</p>
                    <div class="w3-container w3-responsive">
                        <table class="w3-table">
                            <tr>
                                <th>Question</th>
                                <th>Time</th>
                                <th>Action</th>
                            </tr>
                            <c:forEach items="${questions}" var="list">
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                <tr class="w3-white">
                                    <td>${list.getContent()}</td>
                                    <td>${list.getCraetedDate()}</td>
                                    <td>
                                        <button type="button" onclick="edit(${list.getId()})">Edit</button>
                                    </td>
                                </tr>
                            </c:forEach>
                            <script>
                                function edit(id) {
                                    window.location.href = "editQuestion?id=" + id;
                                }
                            </script>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <h1>${error}</h1>
        <!-- Footer -->
        <footer class="w3-container w3-black w3-padding-16">
            <p>Powered by Tran Viet</p>
        </footer>

    </body>
</html>