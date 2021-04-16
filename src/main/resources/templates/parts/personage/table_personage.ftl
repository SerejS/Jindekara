<table class="table is-bordered is-striped has-background-warning">
  <form method="post">
    <tr class="has-background-warning">
      <td>Персонаж</td> <td>Годы жизни</td> <td>Уровень</td>
    </tr>

    <#list personages as personage>
    <tr class="has-background-warning">
      <td>
        <button type="submit" name="select"
                  class="button is-normal is-warning"
                  value="${personage.id}">${personage.getName()}
        </button>
      </td>
      <td>${personage.getYear_born()}-${personage.getYear_death()}</td>
      <td>${personage.getLvl()}</td>
    </tr>
  </#list>

  <tr class="has-background-warning">
    <td colspan="3">
      <button type="submit" class="button is-warning is-fullwidth" name="select" value="0">
        Добавить нового персонажа
      </button>
    </td>
  </tr>
  </form>
</table>