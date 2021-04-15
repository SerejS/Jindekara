<div class="card-header">
    <h1 class="title is-3">${selected_event.getNameEvent()}</h1>
</div>

<div class="card-content">
    <b>Даты события:</b> ${dates_of_event} <br>

    <b>Ключевое влияние на событие:</b> ${selected_event.getAffect().getName()}<br>

    ${description}
</div>
