<#import "parts/shell.ftl" as s>
<#import "parts/modal.ftl" as modal>
<#import "parts/table.ftl" as t>

<@s.page>
<#--Название полей-->
    <#assign main_fields =
    [{
    "title" : "Название расы",
    "name_field" : "nameRace",
    "type" : "text"
    },
    {
    "title" : "Уровень силы",
    "name_field" : "strength",
    "type" : "select",
    "options": [
    {"ru" : "Очень слабое", "constr" : "WEAKEST"},
    {"ru" : "Слабое", "constr" : "WEAK"},
    {"ru" : "Среднее", "constr" : "NORMAL"},
    {"ru" : "Сильное", "constr" : "STRONG"},
    {"ru" : "Очень сильное", "constr" : "STRONGEST"}
    ]
    },
    {
    "title" : "Длинна жизни",
    "name_field" : "lifespan",
    "type" : "text"
    },
    {
    "title" : "Среднее колличество в группе",
    "name_field" : "population",
    "type" : "text"
    },
    {
    "title" : "Ареал обитания",
    "name_field" : "location",
    "type" : "text"
    },
    {
    "title" : "Вид еды",
    "name_field" : "food",
    "type" : "select",
    "options": [
    {"ru" : "Хищный", "constr" : "PREDATOR"},
    {"ru" : "Травоядный", "constr" : "HERBIVORE"},
    {"ru" : "Всеядный", "constr" : "OMNIVORE"}
    ]
    },
    {
    "title" : "Отношенгие к разумным",
    "name_field" : "regardToHumanoid",
    "type" : "select",
    "options": [
    {"ru" : "Дружелюбный", "constr" : "FRIENDLY"},
    {"ru" : "Нейтральный", "constr" : "NEUTRAL"},
    {"ru" : "Враждебный", "constr" : "HOSTILE"}
    ]
    },{
    "title" : "Отношение к остальным",
    "name_field" : "regardToAll",
    "type" : "select",
    "options": [
    {"ru" : "Дружелюбный", "constr" : "FRIENDLY"},
    {"ru" : "Нейтральный", "constr" : "NEUTRAL"},
    {"ru" : "Враждебный", "constr" : "HOSTILE"}
    ]
    }]>

    <#assign file_fields = ["Слабости", "Заметки"]>

    <#--Таблица-->
    <@t.table main_fields races "Добавить новую расу"/>

    <@modal.add main_fields "save"/>
    <@modal.select main_fields file_fields/>

</@s.page>