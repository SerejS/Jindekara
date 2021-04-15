<#import "parts/shell.ftl" as s>

<@s.page>
	<div class="columns">
		<div class="column ">
			<#include "parts/event/table_event.ftl">
		</div>

		<#include "parts/event/about_event.ftl">
	</div>
</@s.page>