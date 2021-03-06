<%@ page import="jsp.Tales" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="ru">
	<head>
		<title>Сказания</title>
		<meta charset="UTF-8">
		<style>
			@import "styles/tales.css";
		</style>
	</head>
	<body>
	<h1> Сказания на все времена </h1>
	<div>В данном фолианте будут изложены даты, являющиеся реальными и могут не совпадать с восприятием жителей разных островов, так что не удивляйтесь, если многие вас не поймут, услышав ваше восприятие времени. Я, как Библиотекарь не могу искажать факты, поэтому распоряжайтесь данными знаниями осмотрительно. Начинать есть смысл с начала.
		Довожу до вашего сведения, что ваш мир является не первым и явно не последним. Он является одним из бесконечного круга создания и разрушения.<br>
		Предыдущий мир разрушила сила Алдуина. Этот мир создала сила Сераны, но в итоге и он будет разрушен, и это не изменить, однако истории известны случаи, когда разрушение удавалось оттянуть. <br>
		Так вот, создание мира произошло в 0 году. Появилась поверхность Джиндекары, острова, плоские острова, ледниковый барьер и прочее..</div>
	<div>
		<table align="left">
			<tr>
				<td>Год</td> <td>Дата</td> <td>Событие</td>
			</tr>
			<%=Tales.outTable()%>

			<tr>
				<form>
					<td colspan="3"><button type="submit" name="select" value="add"> Добавить новое событие</button></td>
				</form>
			</tr>
		</table>
	</div>
	<div class="event">
		<%=Tales.outEvent(request.getParameter("event"), request.getParameter("select"))%>
		<%=request.getParameter("del") != null ? Tales.del(Integer.parseInt(request.getParameter("event"))) : ""%>
		<%=request.getParameter("edit") != null? Tales.edit(Integer.parseInt(request.getParameter("event")), request.getParameter("nameEvent"), Integer.parseInt(request.getParameter("yearEvent")), Integer.parseInt(request.getParameter("dateEvent")), request.getParameter("descEvent")) : ""%>

		<%=request.getParameter("save") != null ? Tales.add(request.getParameter("nameEvent"), Integer.parseInt(request.getParameter("yearEvent")),Integer.parseInt(request.getParameter("dateEvent")),request.getParameter("descEvent")) : ""%>
	</div>


	<div style="position: relative; top: 440px;"><a href="jindekara.html">Назад</a></div>
	</body>
</html>