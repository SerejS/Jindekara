// Модальное окно добавления
const addModal = document.getElementById("addWindow");
const addOpenBtn = document.getElementById("addBtn");
const addCloseBtn = document.getElementsByClassName("delete")[0];

//Откытие модального окна добавления
addOpenBtn.onclick = function() {
    addModal.classList.add("is-active");
}

//Закрытие модального окна добавления
addCloseBtn.onclick = function() {
    addModal.classList.remove("is-active");
}


// Модальное окно изменения
const editModal = document.getElementById("editWindow");
//const editOpenBtn =
const editCloseBtn = document.getElementsByClassName("delete")[1];


// Модальное окно информации
const infoModal = document.getElementById("infoWindow");
const infoCloseBtn = document.getElementsByClassName("delete")[2];

function openInfo(id) {
    const elements = infoModal.getElementsByClassName("description");
    const tds = document.getElementById(id).getElementsByTagName("td");
    for (i = 0; i < elements.length; i++) {
        elements[i].textContent = tds[i].textContent;
    }
    infoModal.classList.add("is-active");
}

infoCloseBtn.onclick = function () {
    infoModal.classList.remove("is-active");
}

