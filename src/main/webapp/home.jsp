<%@ page import="jsp.User" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
    <head>
        <title>Вход</title>
        <style>
            body {
                background-color: grey;
            }
            input {
                background-color: #eec861;
            }
            label {
                width : 60px;
                display: inline-block;
            }
        </style>
    </head>

    <body>
        <form method='post'>
            <label for="name">Имя:</label>
            <input type='text' id='name' name='name'> <br>
            <label for="pass">Пароль:</label>
            <input type='password' id='pass' name ='pass'><br>

            <p><input type="submit"></p>
        </form>

        <% if (User.login(request)) {%>
            <a href='jindekara.html'>Вход.</a><br>
        <%} else %> Введите имя и пароль пользователя. <br>
        <a href='reg.jsp'>Регистрация</a><br>
    </body>
</html>
