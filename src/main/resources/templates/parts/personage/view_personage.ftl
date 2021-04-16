<div class="card-header">
    <h1 class="title is-3">${selected_personage.getName()}</h1>
</div>

<div class="card-content">
    <b>Годы жизни</b>: ${selected_personage.getDateYearOfLife()}<br>
    <b>Уровень</b>: ${selected_personage.getLvl()}<br>
    <b>Пол</b>: ${selected_personage.getSex()}<br>
    <b>Специализация</b>: ${selected_personage.getSpecialisation()}
</div>

<form method="post" class="card-footer-item p-0">
    <div class="card-footer-item p-0">
        <button type="submit" name="select" value="${-selected_personage.getId()}"
                class="button is-warning is-middle is-half">
            Изменить
        </button>
    </div>
    <div class="card-footer-item p-0">
        <button formaction="personages/delete" type="submit" name="select" value="${selected_personage.getId()}"
                class="button is-warning is-middle is-half">
            Удалить
        </button>
    </div>
</form>