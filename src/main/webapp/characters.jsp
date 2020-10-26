<%@ page import="jsp.Characters" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html >
<head>
	<title>Персонажи</title>
	<meta charset="UTF-8">
	<style>
		table {
			background-color: #ffb905;
		}

		a {
			text-decoration: none;
		}
	</style>
</head>
<body style="background-color: gray">
<h1> Персонажи </h1>

<table cellspacing="0" border="1px solid black">
	<tr>
		<th>Имя</th>
		<th>Год рождения</th>
		<th>Год смерти</th>
		<th>Уровень</th>
	</tr>
	<%=Characters.out()%>
</table>
<a href="add_characters.jsp">Добавить персонажа</a>
<a href="del_characters.jsp">Удалить персонажа</a>
<div style="position: relative; top: 440px;"><a href="jindekara.html">Назад</a></div>

</body>
</html>