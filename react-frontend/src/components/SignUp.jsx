import axios from 'axios'
import React, { Component } from 'react'
import "../css/form.css"


class SignUp extends Component {
    constructor(props) {
        super(props)
        this.state = {         
            username: '',
            email: '',
            password: '',
        }
        this.changeUsernameHandler = this.changeUsernameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.saveMember = this.saveMember.bind(this);
    }


    saveMember = (hndl) => {
        hndl.preventDefault();
        let member = { username: this.state.username,email: this.state.email,  password: this.state.password , role : "USER"};
        axios.post('http://localhost:8080/member', member)
        .then(response => {
            console.log(response)
        })    
        window.location.href = '/SignIn';

    }


    changeUsernameHandler = (event) => {
        this.setState({ username: event.target.value });
    }
    changeEmailHandler = (event) => {
        this.setState({ email: event.target.value });
    }
    changePasswordHandler = (event) => {
        this.setState({ password: event.target.value });
    }


    render() {
        return (
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">REGISTER</h3>
                            <div className="card-body">
                                <form onSubmit = {this.hndlSubmit} style = {{ marginBottom: '30mm' }}>

                                    <div className="form=group">
                                        <label> Username : </label>
                                        <input placeholder="Username" name="usrname" className="form-control"
                                            value={this.state.username} onChange={this.changeUsernameHandler} />
                                    </div>
                                    <div className="form=group">
                                        <label> Email : </label>
                                        <input placeholder="Email" name="email" className="form-control"
                                            value={this.state.email} onChange={this.changeEmailHandler} />
                                    </div>

                                    <div className="form=group">
                                        <label> Password : </label>
                                        <input placeholder="Password" name="password" className="form-control"
                                            value={this.state.password} onChange={this.changePasswordHandler} />
                                    </div>
                                    <br></br>
                                    <button name="btn" className="btn btn-success" onClick={this.saveMember}>SIGN UP</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
export default SignUp