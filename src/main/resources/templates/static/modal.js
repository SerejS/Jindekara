// Модальное окно
var modal = document.getElementById("addWindow");

// Кнопка открытия
var btn = document.getElementById("addBtn");

// Кнопка закрытия
var span = document.getElementsByClassName("delete")[0];

// When the user clicks on the button, open the modal
btn.onclick = function() {
    modal.classList.add("is-active");
}

span.onclick = function() {
    modal.classList.remove("is-active");
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
