<%@ page import="jsp.Characters" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<title>Персонажи</title>
	<meta charset="UTF-8">
	<style>
		<%@include file="styles/characters.css"%>
	</style>
</head>
<body>
<h1> Персонажи </h1>

<table align="left">
	<tr>
		<th>Имя</th>
		<th>Год рождения</th>
		<th>Год смерти</th>
		<th>Уровень</th>
	</tr>
	<%=Characters.outTable()%>
	<tr><form>
		<td colspan="4"><button type="submit" class="butTable" name="select" value="add">Добавить персонажа</button></td>
	</form></tr>
</table>
<div class="screen">
	<jsp:include page="WEB-INF/subPages/character.jsp" />
</div>

<div style="position: relative; top: 240px;"><a href="jindekara.html">Назад</a></div>

</body>
</html>