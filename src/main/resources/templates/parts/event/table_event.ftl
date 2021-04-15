<table class="table is-bordered is-striped has-background-warning">
    <form method="post">
        <tr><td>Год</td> <td>Дата</td> <td>Событие</td></tr>

        <#list events as event>
            <tr class="has-background-warning">
                <td>${event.yearStart}</td>
                <td>${event.dateStart}</td>
                <td>
                    <button type="submit" class="button is-normal is-warning" name="select" value="${event.id}">
                        ${event.nameEvent}
                    </button>
                </td>
            </tr>
        </#list>

        <tr class="has-background-warning">
            <td colspan="3">
                <button type="submit" class="button is-warning" name="select" value="0">
                    Добавить новое событие
                </button>
            </td>
        </tr>
    </form>
</table>