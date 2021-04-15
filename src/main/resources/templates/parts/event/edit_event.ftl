<fieldset class="field_set">
<form method="post" name="event" action="edit">
    <input name="select" type="hidden" value="${-select}">

    <div class="mb-2 pb-3">
        <input type="text" name="nameEvent" placeholder="Название события" value="${selected_event.getNameEvent()}"
               class="input is-rounded is-medium control">
    </div>

    <div class="columns">
        <div class="column">
            <input type="number" name="dateStart" placeholder="Дата начала события"
                   class="input is-rounded" value="${selected_event.getDateStart()}">
        </div>
        <div class="column">
            <input type="number" name="dateEnd" placeholder="Дата конца события"
                   class="input is-rounded" value="${selected_event.getDateEnd()}">
        </div>
    </div>

    <div class="columns">
        <div class="column">
            <input type="number" name="yearStart"  placeholder="Год начала события"
                   class="input is-rounded" value="${selected_event.getYearStart()?c}">
        </div>
        <div class="column">
            <input type="number" name="yearEnd" placeholder="Год конца события"
                   class="input is-rounded" value="${selected_event.getYearEnd()?c}">
        </div>
    </div>

    <div class="select is-rounded mb-3">
        <select name="affect">
            <option value="DEFAULT">Логос</option>
            <option value="FARKS">Фаркс</option>
            <option value="SERANA">Серана</option>
            <option value="ALDUIN">Алдуин</option>
            <option value="DEMONS">Демоны</option>
            <option value="ARCHITECTOR">Архитектор</option>
            <option value="SPIRITS">Духи</option>
            <option value="HEROES">Герои</option>
        </select>
    </div>
    <br>
    <button type="submit" value="edit" class="button is-rounded">Изменить событие</button>
</form>
</fieldset>