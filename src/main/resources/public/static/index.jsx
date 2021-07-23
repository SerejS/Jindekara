import React from "react";
import ReactDOM from "react-dom";

import Table from "./table";
import Modal from "./modal";

let section = window.location.pathname.substring(1)
const url = "/api/" + section + "/";


class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],

            isActive: false,
            isForm: true,
            selected: null
        }

        this.openInfo = this.openInfo.bind(this);
        this.openForm = this.openForm.bind(this);
        this.closeModal = this.closeModal.bind(this);


        this.addItem = this.addItem.bind(this);
        this.deleteItem = this.deleteItem.bind(this);
    }

    componentDidMount() {
        fetch(url + "all", {method: 'POST'})
            .then(response => response.json())
            .then(data => {
                this.setState({
                    items: data
                })
            })
    }

    openInfo(id) {
        let item = this.state.items.find(item => item.id === id);

        fetch(url + "info/" + id, {method: 'GET'})
            .then(response => response.json())
            .then(data => {
                let textFields = this.props.fields.filter(item => item.type === 'textarea');
                for (let i = 0; i < textFields.length; i++) {
                    if (data[i] !== "") item[textFields[i].name_field] = data[i];
                }

                this.setState({
                    isActive: true,
                    isForm: false,
                    selected: item
                });
            });


    }

    openForm() {
        this.setState({isActive: true, isForm: true});
    }

    closeModal() {
        this.setState(() => ({
            isActive: false,
            selected: null
        }))
    }

    addItem() {
        let form = new FormData(document.getElementById("model"));

        let newItem = {}

        this.props.fields.forEach(field => {
            if (field.type === "select") {
                newItem[field.name_field] =
                    field.options.find(item => item.constr === form.get(field.name_field))['ru'];

            } else if (form.get(field.name_field) !== "") {
                newItem[field.name_field] = form.get(field.name_field);
            }
        })

        console.log(newItem)

        if (this.state.selected !== null) {
            form.set('id', this.state.selected.id)
            newItem.id = this.state.selected.id
            fetch(url + "save", {method: 'POST', body: form})
                .then(() => {
                    this.setState({
                        items: this.state.items.filter(item => item.id !== this.state.selected.id).concat(newItem)
                    })
                })
                .finally(() => this.closeModal());
            return
        }

        fetch(url + "save", {method: 'POST', body: form})
            .then(resp => resp.text())
            .then(data => {
                newItem.id = data;
                this.setState({
                    items: this.state.items.concat(newItem)
                })
            })
            .finally(() => this.closeModal());
    }

    deleteItem(id) {
        fetch(url + "delete/" + id, {method: 'DELETE'})
            .then(() => {
                this.setState({
                    items: this.state.items.filter(item => item.id !== id)
                });
            })
            .catch((error) => {
                console.error("Ошибка удаления:", error);
            })
        this.closeModal();
    }

    render() {
        return (
            <>
                <Table
                    fields={this.props.fields.filter(item => item.type !== 'textarea')}
                    items={this.state.items}
                    info={this.openInfo}
                    form={this.openForm}
                    footerName="Добавить"
                />

                {this.state.isActive
                    ? <Modal
                        chosen={this.state.selected}
                        isForm={this.state.isForm}

                        openForm={this.openForm}
                        close={this.closeModal}

                        add={this.addItem}
                        delete={this.deleteItem}>

                        {this.props.fields}
                    </Modal> : <></>}
            </>
        );
    }
}

ReactDOM.render(
    <App fields={(require("./entities.json"))[section]}/>,
    document.getElementById('root')
)