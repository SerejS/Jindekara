<div class="card-content">
    <fieldset class="field_set">
        <form method="post" name="personage" action="personages/save">
            <div class="mb-2 pb-3">
                <input type="text" name="name" placeholder="Имя персонажа"
                       class="input is-rounded is-medium control">
            </div>

            <div class="columns">
                <div class="column is-one-fifth">
                    <input type="number" name="lvl" placeholder="lvl"
                           min="0" max="250" class="input is-rounded">
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
                    <label for="W">Ж</label>
                    <input type="radio" name="sex" value="NEUTRAL" id="W"
                           class="radio-button">
                </div>
            </div>

            <div class="columns">
                <div class="column">
                    <input type="number" name="date_born" placeholder="Дата рождения"
                           class="input is-rounded">
                </div>
                <div class="column">
                    <input type="number" name="date_death" placeholder="Дата смерти"
                           class="input is-rounded">
                </div>
            </div>

            <div class="columns">
                <div class="column">
                    <input type="number" name="year_born" placeholder="Год рождения"
                           class="input is-rounded">
                </div>
                <div class="column">
                    <input type="number" name="year_death" placeholder="Год смерти"
                           class="input is-rounded">
                </div>
            </div>

            <br>
            <button type="submit" value="save" class="button is-rounded">Добавить персонажа</button>
        </form>
    </fieldset>
</div>