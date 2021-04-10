<div class="event">
    <#if select == 0>
        <#include "add_event.ftl">
    <#else>
        <#include "view_event.html">
        <#include "buttons_event.html">
    </#if>
</div>