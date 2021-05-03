<div class="card-content">
    <fieldset class="field_set">
        <form method="post" name="event" action="personages/edit">
            <input name="select" type="hidden" value="${-select}">

            <div class="mb-2 pb-3">
                <input type="text"
                       name="name"
                       placeholder="Имя персонажа"
                       value="${selected_personage.getName()}"
                       class="input is-rounded is-medium control">
            </div>

            <div class="columns">
                <div class="column is-one-fifth">
                    <input type="number" name="lvl" placeholder="lvl"
                           min="0" max="250" class="input is-rounded"
                           value="${selected_personage.getLvl()}">
                </div>
                <div class="column">
                    <div class="select is-rounded">
                        <select name="specialisation" id="specialisation">
                            <#list specializations as spec>
                                <option value="${spec.getId()}">${spec.getTitle()}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="column">
                    <label for="M" class="radio">М</label>
                    <input type="radio" name="sex" value="MAN" id="M"
                           class="radio-button">
                    <label for="W" class="radio">Ж</label>
                    <input type="radio" name="sex" value="WOMAN" id="W"
                           class="radio-button">
                </div>
            </div>

            <div class="columns">
                <div class="column">
                    <input type="number" name="date_born" placeholder="Дата рождения"
                           class="input is-rounded" value="${selected_personage.getDate_born()}">
                </div>
                <div class="column">
                    <input type="number" name="date_death" placeholder="Дата смерти"
                           class="input is-rounded" value="${selected_personage.getDate_death()}">
                </div>
            </div>

            <div class="columns">
                <div class="column">
                    <input type="number" name="year_born" placeholder="Год рождения"
                           class="input is-rounded" value="${selected_personage.getYear_born()?c}">
                </div>
                <div class="column">
                    <input type="number" name="year_death" placeholder="Год смерти"
                           class="input is-rounded" value="${selected_personage.getYear_death()?c}">
                </div>
            </div>

            <button type="submit" value="edit" class="button is-rounded">Изменить персонажа</button>
        </form>
    </fieldset>
</div>