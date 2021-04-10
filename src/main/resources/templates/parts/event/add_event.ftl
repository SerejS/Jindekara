<fieldset class="field_set">
    <form method="post" name="event" action="save">
        <ul>
            <li><input type="text"   name="nameEvent" placeholder="Название события"></li>
            <li><input type="number" name="dateStart" placeholder="Дата начала события"></li>
            <li><input type="number" name="dateEnd" placeholder="Дата конца события"></li>
            <li><input type="number" name="yearStart" placeholder="Год начала события"></li>
            <li><input type="number" name="yearEnd" placeholder="Год конца события"></li>
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
                <button type="submit" value="save" class="butBar">Добавить</button>
            </li>
        </ul>
    </form>
</fieldset>