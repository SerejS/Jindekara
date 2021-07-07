// Модальное окно добавления
const addModal = document.getElementById("addWindow");
const addOpenBtn = document.getElementById("addBtn");
const addCloseBtn = document.getElementsByClassName("delete")[0];

//Откытие модального окна добавления
addOpenBtn.onclick = function () {
    addModal.classList.add("is-active");
}

//Закрытие модального окна добавления
addCloseBtn.onclick = function () {
    addModal.classList.remove("is-active");
}


//Добавление нового элемента
document.getElementById("sendButton").onclick = async function () {
    let response = await fetch(document.URL + '/save', {
        method: 'POST',
        body: new FormData(document.getElementById('formRace'))
    });
}

// Модальное окно изменения
const editModal = document.getElementById("editWindow");
//const editOpenBtn =
const editCloseBtn = document.getElementsByClassName("delete")[1];


// Модальное окно информации
const infoModal = document.getElementById("infoWindow");
const infoCloseBtn = document.getElementsByClassName("delete")[1];

async function openInfo(id) {
    let elements = infoModal.getElementsByClassName("description");
    const tds = document.getElementById(id).getElementsByTagName("td");
    for (let i = 0; i < elements.length; i++) {
        elements[i].textContent = tds[i].textContent;
    }

    elements = infoModal.getElementsByClassName("file_description");
    let resp = await fetch(document.URL + "/info?id=" + id, {method: 'POST'});
    let data = await resp.json();

    for (let i = 0; i < elements.length; i++) {
        if (data[i] === "") elements[i].innerHTML = "Информация отсутсвует.";
        else elements[i].innerHTML = data[i];
    }

    infoModal.classList.add("is-active");
}

infoCloseBtn.onclick = function () {
    infoModal.classList.remove("is-active");
}

