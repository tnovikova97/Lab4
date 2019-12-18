<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 18.12.2019
  Time: 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
</head>
<body>

<div class="container">

    <center>
        <h1 style="text-transform: uppercase;
            font-weight: bold;
            size: 20px">Управление продукцией</h1>
    </center>

    <div style="display: flex;
                flex-direction: row;
                justify-content: space-around;">

        <div>
            <p class="btn btn-primary"><a href="EarringsServlet?action=new">
                <span>
                    Добавить новое кольцо
                </span>
            </a> </p>
        </div>
        <div>
            <p class="btn btn-primary"><a href="EarringsServlet?action=listEarrings">
                <span>
                    Посмотреть все серьги
                </span>
            </a> </p>
        </div>

       <div>
       </div>
    </div>
            <div align="center">

                <c:if test='${ear != null}'>
                    <form action="EarringsServlet?action=update" method="post" class="form-group row">
                </c:if>
                        <c:if test='${ear == null}'>
                            <form action="EarringsServlet?action=new" method="post" class="form-group row">
                        </c:if>
                                <table border="1" cellpadding="6">
                                    <c:if test="${ear != null}">
                                        <input type="hidden" name="id" value="<c:out value='${ear.id}' />"/>
                                    </c:if>

                                    <tr>
                                        <th>Название</th>
                                        <td>
                                            <input type="text" name="title" size="45" class="form-control"
                                                   value="<c:out value='${ear.title}'/>" required />
                                        </td>
                                    </tr>

                                    <tr>
                                        <th>Стиль:</th>
                                        <td>
                                            <select name="style" required>
                                                <option>Геометрия</option>
                                                <option>Дорожки</option>
                                                <option>Классика</option>
                                                <option>Фауна</option>
                                                <option>Флора</option>
                                                <option>Этнический</option>
                                            </select>
                                        </td>
                                    </tr>

                                    <tr>
                                        <th>Дизайнер:</th>
                                        <td>
                                            <select name="designer" required>
                                                <option>Van Kempen</option>
                                                <option>Sajen</option>
                                                <option>Cristina Sabatini</option>
                                                <option>Honora</option>
                                                <option>Zoccai 925</option>
                                                <option>Enternity Gold</option>
                                            </select>
                                        </td>
                                    </tr>

                                    <tr>
                                        <th>Камень:</th>
                                        <td>
                                            <select name="stone" required>
                                                <option>Фионит</option>
                                                <option>Агат</option>
                                                <option>Бриллиант</option>
                                                <option>Изумруд</option>
                                                <option>Аквамарин</option>
                                                <option>Александрит</option>
                                                <option>Гранат</option>
                                                <option>Жемчуг</option>
                                                <option>Лунный камень</option>
                                                <option>нет</option>
                                            </select>
                                        </td>
                                    </tr>

                                    <tr>
                                        <th>Метал</th>
                                        <td>
                                            <select name="metal" required>
                                                <option>Бронза</option>
                                                <option>Серебро</option>
                                                <option>Золото</option>
                                                <option>Платина</option>
                                            </select>
                                        </td>
                                    </tr>

                                    <tr>
                                        <th>Цена:</th>
                                        <td>
                                            <input type="number" name="price" size="15" required class="form-control"
                                                    value="<c:out value='${ear.price}'/>"
                                            />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td colspan="2" align="center">
                                            <input type="submit" class="btn btn-success" value="Сохранить"/>
                                        </td>
                                    </tr>

                                </table>
                    </form>
                    </form>

            </div>

        </div>

</body>
</html>
