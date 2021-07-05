<#macro table fields_name entities name_add>
    <table class="table is-bordered is-striped has-background-warning">
        <tr class="has-background-warning">
            <#list fields_name as field>
                <td>${field}</td>
            </#list>
        </tr>


        <#list entities as entity>
            <tr class="has-background-warning" id="${entity.getId()}">
                <#list entity.getFields()! as field>
                    <td>
                        <#if field?counter == 1>
                            <button class="button is-warning is-fullwidth" onclick="openInfo(${entity.getId()})">
                                ${field}
                            </button>
                        <#else>
                            ${field}
                        </#if>
                    </td>
                </#list>
            </tr>
        </#list>


        <tr class="has-background-warning">
            <td colspan="${fields_name?size}">
                <button class="button is-warning is-fullwidth" id="addBtn">
                    ${name_add}
                </button>
            </td>
        </tr>
    </table>
</#macro>