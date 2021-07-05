<#macro add fields>
    <@layout "addWindow" "Добавить">
        <#list fields as field>
            <div class="field">
                <label class="label">${field}</label>
                <div class="control">
                    <input class="input" type="text">
                </div>
            </div>
            <br>
        </#list>
    </@layout>
</#macro>

<#macro edit fields info>
    <@layout "editWindow" "Изменить">
        Изменение какого-то содержания.
    </@layout>
</#macro>

<#macro select fields info>
    <@layout "infoWindow" "Просмотр">
        <#list fields as field>
            <label class="label">${field}:</label>
            <p class="description"> Содержание </p>
            <br>
        </#list>
    </@layout>
</#macro>

<#macro layout type title>
    <div id="${type}" class="modal is-warning">
        <div class="modal-background"></div>
        <div class="modal-card">
            <header class="modal-card-head">
                <p class="modal-card-title">${title}</p>
                <button class="delete" aria-label="close"></button>
            </header>
            <section class="modal-card-body">
                <#nested>
            </section>
            <footer class="modal-card-foot">
                <button class="button is-warning">Ок</button>
            </footer>
        </div>
    </div>
</#macro>
