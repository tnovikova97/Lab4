<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 18.12.2019
  Time: 7:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show All Earrings</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div style="display: flex;
                flex-direction: column;
                justify-items: center;
                justify-content: center;">

<%--        <%request.getParameter("item");%>--%>

        <div style="display: flex;
                    flex-direction: row;
                    justify-content: space-around">

            <div>
                <p><a href="EarringsServlet?action=new">
                    <span style="color: blue">Добавить новые серьги</span>
                </a> </p>
            </div>
            <div>
                <p><a href="EarringsServlet?action=listEarrings">
                    <span style="color: blue">Показать все серьги</span>
                </a> </p>
            </div>
        </div>

<div align="center">
        <table class="table" border="1">
                <thead class="thead-dark">
                <tr>
                    <td>Название</td>
                    <td>Стиль</td>
                    <td>Дизайнер</td>
                    <td>Камень</td>
                    <td>Метал</td>
                    <td>Цена</td>
                    <td colspan="2" align="center">Действия</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ear}" var="ear">
                    <tr>
                        <td><c:out value="${ear.title}"/></td>
                        <td><c:out value="${ear.style}"/></td>
                        <td><c:out value="${ear.designer}"/></td>
                        <td><c:out value="${ear.stone}"/></td>
                        <td><c:out value="${ear.metal}"/></td>
                        <td><c:out value="${ear.price}" /> руб.</td>
                        <td><a href="EarringsServlet?action=update&id=<c:out value="${ear.id}"/>">
                            <span class="btn btn-warning">Обновить</span></a> </td>
                        <td><a href="EarringsServlet?action=delete&id=<c:out value="${ear.id}"/>">
                            <span class="btn btn-danger">Удалить</span></a> </td>
                    </tr>
                </c:forEach>
                </tbody>
        </table>
</div>

    </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

</body>
</html>
