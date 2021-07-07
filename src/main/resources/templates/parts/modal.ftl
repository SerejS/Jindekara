<#macro add fields action>
    <@layout "addWindow" "Добавить">
        <fieldset>
            <form method="post" name="race" action="${action}" id="formRace">
                <#list fields as field>
                    <div class="field">
                        <label class="label">${field.title}</label>

                        <#switch field.type>
                            <#case "text">
                                <div class="control">
                                    <input class="input" type="${field.type}" name="${field.name_field}">
                                </div>
                                <#break>

                            <#case "select">
                                <div class="select is-fullwidth">
                                    <select name="${field.name_field}">
                                        <#list field.options as opt>
                                            <option value="${opt.constr}">${opt.ru}</option>
                                        </#list>
                                    </select>
                                </div>
                        </#switch>
                    </div>
                    <br>
                </#list>
            </form>
        </fieldset>

    </@layout>
</#macro>

<#macro select main_fields info_fields>
    <@layout "infoWindow" "Просмотр">
        <#list main_fields as field>
            <label class="label">${field.title}:</label>
            <p class="description">  </p>
            <br>
        </#list>

        <#list info_fields as field>
            <label class="label">${field}:</label>
            <p class="file_description">  </p>
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
                <button class="button is-warning" id="sendButton">Ок</button>
            </footer>
        </div>
    </div>
</#macro>
