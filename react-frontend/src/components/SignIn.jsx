import axios from 'axios'
import React, { Component } from 'react'

class SignIn extends Component {
    constructor(props) {
        super(props)
        this.state = {         
            username: '',
            password: '',
        }
        this.changeUsernameHandler = this.changeUsernameHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.hndlSubmit = this.hndlSubmit.bind(this);
    }



    hndlSubmit = (hndl) =>  {
        hndl.preventDefault();
        axios.post("http://localhost:8080/member/login", {
            username:this.state.username,
            password:this.state.password
        })
            .then(response => { 
                console.log(response);
                const token = "logged in";
                localStorage.setItem("token", token);
                window.location.href = '/';
            },
            (error) => {
                console.log(error);
                this.setState({errorMessage: error.message});
              });
    } 

    changeUsernameHandler = (event) => {
        this.setState({ username: event.target.value });
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
                            <h3 className="text-center">Sign In</h3>
                            <div className="card-body">
                                <form onSubmit = {this.hndlSubmit} style = {{ marginBottom: '30mm' }}>

                                    <div className="form=group">
                                        <label> Username : </label>
                                        <input placeholder="Username" name="usrname" className="form-control"
                                            value={this.state.username} onChange={this.changeUsernameHandler} />
                                    </div>
                                    <div className="form=group">
                                        <label> Password : </label>
                                        <input placeholder="Password" name="password" className="form-control"
                                            value={this.state.password} onChange={this.changePasswordHandler} />
                                    </div>
                                    <br></br>
                                    <button className="btn btn-success" onClick={this.hndlSubmit}>SIGN IN</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
export default SignIn