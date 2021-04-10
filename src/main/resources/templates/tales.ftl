<#import "parts/shell.ftl" as s>

<@s.page>
	<h1> Сказания на все времена </h1>

	<div>
		<table align="left">
		<form method="post">
			<tr>
				<td>Год</td> <td>Дата</td> <td>Событие</td>
			</tr>

			<#list events as event>
			<tr>
				<td>${event.yearStart}</td>
				<td>${event.dateStart}</td>
				<td><button type="submit" name="select" value="${event.id}">${event.nameEvent}</button></td>
			</tr>
			</#list>

			<tr>
				<td colspan="3"><button type="submit" name="select" value="0"> Добавить новое событие</button></td>
			</tr>
		</form>
		</table>
	</div>
	<#include "parts/event/about_event.ftl">
</@s.page>