import React from "react";

function Header(props) {
    return (
        <header className="modal-card-head">
            <p className="modal-card-title"> {props.name} </p>
            <button className="delete" onClick={props.close}/>
        </header>
    )
}

function Field(props) {
    let input;

    switch (props.type) {
        case 'select':
            input =
                <div className={"select is-fullwidth"}>
                    <select name={props.name}>
                        {props.options.map(({constr, ru}) =>
                            <option value={constr}>{ru}</option>
                        )}
                    </select>
                </div>
            break;
        case 'textarea':
            input = <textarea name={props.name} className={"textarea"}/>
            break;
        default:
            input = <input name={props.name} className={"input"} type={props.type} defaultValue={props.value}/>
    }


    return (
        <div className="field">
            <label className={"label"}>{props.label}</label>
            {input}
        </div>
    )
}

export default class Modal extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        let modalBodyContent = this.props.isForm
            ? (<form id={"model"} encType="multipart/form-data">
                <fieldset>
                    {this.props.children.map(({name_field}, index) =>
                        <Field name={name_field}
                               label={this.props.children[index].title}
                               type={this.props.children[index].type}
                               options={this.props.children[index].options}
                               value={this.props.chosen !== null ? this.props.chosen[name_field] : ""}
                        />
                    )}
                </fieldset>
            </form>)
            :
            (
                //Вывод только существующих полей полей
                this.props.children.map(({title, name_field, type}) =>
                    !this.props.chosen.hasOwnProperty(name_field) ? <></>
                        :
                        <>
                            <b>{title}:</b><br/>
                            <p>{type !== 'class' ? this.props.chosen[name_field] : this.props.chosen[name_field].string}</p>
                        </>
                )
            )

        return (
            <div className="modal is-warning is-active">
                <div className="modal-background"/>
                <div className="modal-card">
                    <Header
                        name={this.props.isForm ? "Ввод" : "Просмотр"}
                        close={this.props.close}
                    />

                    <section className="modal-card-body">
                        {modalBodyContent}
                    </section>

                    <footer className="modal-card-foot">
                        {this.props.isForm
                            ? <button className="button is-warning is-fullwidth" onClick={this.props.add}>
                                Сохранить
                            </button>
                            : <>
                                <button key={1} className="button is-warning is-fullwidth"
                                        onClick={() => this.props.openForm(this.props.chosen.id)}>
                                    Изменить
                                </button>
                                <button key={2} className="button is-warning is-fullwidth"
                                        onClick={() => this.props.delete(this.props.chosen.id)}>
                                    Удалить
                                </button>
                            </>}
                    </footer>
                </div>
            </div>
        )
    }
}