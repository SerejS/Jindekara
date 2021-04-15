<form method="post">
  <div class="footer-to-bottom">
      <footer class="card-footer" >
          <div class="card-footer-item p-0">
              <button type="submit" name="select" value="${-selected_event.getId()}"
                      class="button is-warning is-middle is-half">Изменить</button>
          </div>

          <div class="card-footer-item p-0">
              <button formaction="delete" type="submit" name="select" value="${selected_event.getId()}"
                      class="button is-warning is-middle is-half">Удалить</button>
          </div>
      </footer>
  </div>
</form>
