<fieldset class="field_set">
<form method="post" name="event" action="edit">
    <input name="select" type="hidden" value="${-select}">
    <ul>
         <li>
             <input type="text"
                    name="nameEvent"
                    placeholder="Название события"
                    value="${selected_event.getNameEvent()}">
         </li>
         <li>
             <input type="number"
                    name="dateStart"
                    placeholder="Дата начала события"
                    value="${selected_event.getDateStart()}">
         </li>
         <li>
             <input type="number"
                    name="dateEnd"
                    placeholder="Дата конца события"
                    value="${selected_event.getDateEnd()}">
         </li>
         <li>
             <input type="number"
                    name="yearStart"
                    placeholder="Год начала события"
                    value="${selected_event.getYearStart()?c}">
         </li>
         <li>
             <input type="number"
                    name="yearEnd"
                    placeholder="Год конца события"
                    value="${selected_event.getYearEnd()?c}">
         </li>
         <li>
             <label for="affect"> Кто оказал влияние: </label>
             <select name="affect" id="affect">
                 <option value="DEFAULT">Логос</option>
                 <option value="FARKS">Фаркс</option>
                 <option value="SERANA">Серана</option>
                 <option value="ALDUIN">Алдуин</option>
                 <option value="DEMONS">Демоны</option>
                 <option value="ARCHITECTOR">Архитектор</option>
                 <option value="SPIRITS">Духи</option>
                 <option value="HEROES">Герои</option>
            </select>
        </li>
        <li>
            <button type="submit" value="edit" class="butBar">Изменить событие</button>
        </li>
    </ul>
</form>
</fieldset>