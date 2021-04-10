<div class="event">
    <#if select gt 0>
        <#include "view_event.ftl">
        <#include "buttons_event.ftl">
    <#elseif select == 0>
        <#include "add_event.ftl">
    <#elseif select lt 0>
        <#include "edit_event.ftl">
    <#else>
    </#if>
</div>