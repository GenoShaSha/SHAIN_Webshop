import React, { Component } from 'react'
import postFormData from '../api/post'

class AddMemberComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            memberID: '',
            name: '',
            email: '',
            phoneNumb: '',
            address: '',
            password: ''
        }
        this.changeMemberIdHandler = this.changeMemberIdHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePhoneNumbHandler = this.changePhoneNumbHandler.bind(this);
        this.changeAddressHandler = this.changeAddressHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.saveMember = this.saveMember.bind(this);
    }



    saveMember = (hndl) => {
        hndl.preventDefault();
        let member = { memberID: this.state.memberID, name: this.state.name, email: this.state.email, phoneNumb: this.state.phoneNumb, address: this.state.address, password: this.state.password };
        postFormData(member)
    }
    

    changeNameHandler = (event) => {
        this.setState({ name: event.target.value });
    }
    changeMemberIdHandler = (event) => {
        this.setState({ memberID: event.target.value });
    }
    changeEmailHandler = (event) => {
        this.setState({ email: event.target.value });
    }
    changePhoneNumbHandler = (event) => {
        this.setState({ phoneNumb: event.target.value });
    }
    changeAddressHandler = (event) => {
        this.setState({ address: event.target.value });
    }
    changePasswordHandler = (event) => {
        this.setState({ password: event.target.value });
    }

    cancel() {
        this.props.history.push('/member');
    }

    render() {
        return (
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Sign Up</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form=group">
                                        <label> Member ID : </label>
                                        <input placeholder="Member ID" name="memberID" className="form-control"
                                            value={this.state.memberID} onChange={this.changeMemberIdHandler} />
                                    </div>
                                    <div className="form=group">
                                        <label> Name : </label>
                                        <input placeholder="Name" name="name" className="form-control"
                                            value={this.state.name} onChange={this.changeNameHandler} />
                                    </div>
                                    <div className="form=group">
                                        <label> Email : </label>
                                        <input placeholder="Email" name="email" className="form-control"
                                            value={this.state.email} onChange={this.changeEmailHandler} />
                                    </div>
                                    <div className="form=group">
                                        <label> Phone Number : </label>
                                        <input placeholder="Phone Number" name="phoneNumb" className="form-control"
                                            value={this.state.phoneNumb} onChange={this.changePhoneNumbHandler} />
                                    </div>
                                    <div className="form=group">
                                        <label> Address : </label>
                                        <input placeholder="Address" name="address" className="form-control"
                                            value={this.state.address} onChange={this.changeAddressHandler} />
                                    </div>
                                    <div className="form=group">
                                        <label> Password : </label>
                                        <input placeholder="Password" name="password" className="form-control"
                                            value={this.state.password} onChange={this.changePasswordHandler} />
                                    </div>
                                    <button className="btn btn-success" onClick={this.saveMember}>Save</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{ marginLeft: "20px" }}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
export default AddMemberComponent