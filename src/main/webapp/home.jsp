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
        <h1>Авторизуйся!</h1>
        <form method="POST">
            <label for="name">Имя:</label>
            <input type='text' id='name' name='name' required="required"> <br>
            <label for="pass">Пароль:</label>
            <input type='password' id='pass' name ='pass' required="required"><br>

            <p><input type="submit" value="Вход"></p>
        </form>

        <% if (User.login(request)) {
            response.sendRedirect("jindekara.html");
        } %>
        <a href='reg.jsp'>Регистрация</a><br>
    </body>
</html>
