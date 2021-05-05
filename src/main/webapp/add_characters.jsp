<%@ page import="jsp.Characters" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>

<html>
<head>
    <title>Добавление нового персонажа</title>
    <style>
        body {
            background-color: gray;
        }
        label {
            width: 100px;
            display: inline-block;
        }
        input {
            background-color: #eec861;
            width: 100px;
        }
    </style>
</head>
<body>
    <form method='post' >
        <label for="name">Имя:</label>
        <input type='text' id='name' name='name'> <br>

        <label for="birth">Год рождения:</label>
        <input type='number' id='birth' name="birth"> <br>

        <label for="death">Год cмерти:</label>
        <input type='number' id='death' name="death"><br>

        <label for="lvl">Уровень:</label>
        <input type="number" id="lvl" name="lvl"><br>

        <input type="submit">
    </form>

    <%=Characters.add(request)%>

    <div style="position: relative; top: 440px;"><a href="characters.jsp">Назад</a></div>
</body>
</html>
