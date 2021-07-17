import React from "react";

function Thead(props) {
    return (
        <thead>
        {props.header.map(field =>
            <td>{field}</td>
        )}
        </thead>
    );
}

class Rows extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (this.props.items.map((item) =>
            <tr>
                <td>
                    <button className="button is-warning is-fullwidth"
                            onClick={() => this.props.open(item.id)}>
                        {item.nameRace}
                    </button>
                </td>
                <td>{item.strength}</td>
                <td>{item.lifespan}</td>
                <td>{item.sectionBestiary}</td>
                <td>{item.population}</td>
                <td>{item.location}</td>
                <td>{item.food}</td>
                <td>{item.regardToHumanoid}</td>
                <td>{item.regardToAll}</td>
            </tr>
        ));
    }
}

class Tfoot extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <tfoot>
            <td colSpan={this.props.amount}>
                <button className="button is-warning is-fullwidth" onClick={this.props.open}>
                    {this.props.name}
                </button>
            </td>
            </tfoot>
        );
    }
}

export default class Table extends React.Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <table class="table is-bordered is-striped has-background-warning">
                <Thead header={this.props.fields}/>
                <Rows
                    items={this.props.items}
                    open={this.props.info}
                />
                <Tfoot
                    name={this.props.footerName}
                    open={this.props.form}
                    amount={this.props.fields.length}/>
            </table>
        )
    }
}