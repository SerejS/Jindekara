<div class="card-header">
    <h1 class="title is-3">${selected_event.getNameEvent()}</h1>
</div>

<div class="card-content">
    <b>Даты события:</b> ${selected_event.getDateYearOfEvent()} <br>

    <b>Ключевое влияние на событие:</b> ${selected_event.getAffect().getName()}<br>

    ${description}
</div>

<form method="post" class="card-footer">
    <div class="card-footer-item p-0">
        <button type="submit" name="select" value="${-selected_event.getId()}"
                class="button is-warning is-middle is-half">Изменить</button>
    </div>

    <div class="card-footer-item p-0">
        <button formaction="tales/delete" type="submit" name="select" value="${selected_event.getId()}"
                class="button is-warning is-middle is-half">Удалить</button>
    </div>
</form>
