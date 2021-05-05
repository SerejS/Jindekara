<%@ page import="jsp.User" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <title>Регистрация</title>
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
            <input type='text' id='name' name='name' required="required"> <br>
            <label for="pass">Пароль:</label>
            <input type='password' id='pass' name ='pass' required="required"><br>

            <p><input type="submit"></p>
        </form>
        <%= User.register(request) %>
        <a href='home.jsp'>Вход</a><br>
    </body>
</html>