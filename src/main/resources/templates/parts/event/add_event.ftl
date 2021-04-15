<div class="card-content">
    <fieldset>
        <form method="post" name="event" action="save">
            <div class="mb-2 pb-3">
                <input type="text" name="nameEvent" placeholder="Название события" class="input is-rounded is-medium control">
            </div>


            <div class="columns">
                <div class="column">
                    <input type="number" name="yearStart" placeholder="Год начала события" class="input is-rounded">
                </div>
                <div class="column">
                    <input type="number" name="yearEnd" placeholder="Год конца события" class="input is-rounded">
                </div>
            </div>
            <div class="columns">
                <div class="column">
                    <input type="number" name="dateStart" placeholder="Дата начала события" class="input is-rounded">
                </div>
                <div class="column">
                    <input type="number" name="dateEnd" placeholder="Дата конца события" class="input is-rounded">
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
            <button type="submit" value="save" class="button is-rounded">Добавить</button>
        </form>

    </fieldset>
</div>