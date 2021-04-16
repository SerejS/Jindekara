<section class="section">
    <div class="container">
        <div class="card has-background-warning">
            <#if select gt 0>
                <#include "view_personage.ftl">
            <#elseif select == 0>
                <#include "add_personage.ftl">
            <#elseif select lt 0>
                <#include "edit_personage.ftl">
            <#else>
            </#if>
        </div>
    </div>
</section>