<#import "parts/shell.ftl" as s>

<@s.page>
<h1> Jindekara </h1>

<table>
	<form method="post">
		<tr><td><button formaction="/tales">Сказания на все времена</button></td></tr>
		<tr><td><button formaction="/personages">Персонажи</button></td></tr>
		<tr><td><button formaction="/bestiary">Бестиарий</button></td></tr>
		<tr><td><button formaction="/maps">Карты</button></td></tr>
	</form>
</table>
</@s.page>