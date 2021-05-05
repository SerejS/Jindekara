<%@ page import="jsp.Characters" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <title>Удаление персонажа</title>
    <style>
        body {
            background-color: gray;
        }
        label {
            display: inline-block;
        }
        input {
            background-color: #eec861;
            width: 100px;
        }
    </style>
</head>
<body>
<form method='post'>
    <label for="name">Введите имя удаляемого персонажа:</label>
    <input type='text' id='name' name='name'> <br>
    <input type="submit">
</form>

<%= Characters.del(request)%>

<div style="position: relative; top: 440px;"><a href="characters.jsp">Назад</a></div>
</body>
</html>
