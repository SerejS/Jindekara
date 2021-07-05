<#import "parts/shell.ftl" as s>
<#import "parts/modal.ftl" as modal>
<#import "parts/table.ftl" as t>

<@s.page>
    <#--Название полей-->
    <#assign name_fields = ["Название расы",
    "Уровень силы", "Длинна жизни",
    "Среднее колличество в группе",
    "Ареал обитанрия", "Вид еды",
    "Отношенгие к разумным", "Отношение к остальным"]>

    <#--Таблица-->
    <@t.table name_fields races "Добавить новую расу"/>

    <@modal.add name_fields/>
    <@modal.edit name_fields "NOTHING"/>
    <@modal.select name_fields "NOTHING"/>
</@s.page>