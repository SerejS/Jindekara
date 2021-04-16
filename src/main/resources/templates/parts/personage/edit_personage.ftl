<div class="card-content">
    <fieldset class="field_set">
        <form method="post" name="event" action="personages/edit">
            <input name="select" type="hidden" value="${-select}">

            <div class="mb-2 pb-3">
                <input type="text"
                       name="nameEvent"
                       placeholder="Название события"
                       value="${selected_event.getNameEvent()}">
            </div>

            <div class="columns">
                <div class="column">
                    <input type="number"
                           name="dateStart"
                           placeholder="Дата начала события"
                           value="${selected_event.getDateStart()}">
                </div>

                <div class="column">
                    <input type="number"
                           name="dateEnd"
                           placeholder="Дата конца события"
                           value="${selected_event.getDateEnd()}">
                </div>
            </div>

            <div class="columns">
                <div class="column">
                    <input type="number"
                           name="yearStart"
                           placeholder="Год начала события"
                           value="${selected_event.getYearStart()?c}">
                </div>

                <div class="column">
                    <input type="number"
                           name="yearEnd"
                           placeholder="Год конца события"
                           value="${selected_event.getYearEnd()?c}">
                </div>
            </div>

            <button type="submit" value="edit">Изменить персонажа</button>
        </form>
    </fieldset>
</div>