import React, { Component } from 'react'
import postFormData from '../api/post'

class AddMember extends Component {
    constructor(props) {
        super(props)
        this.state = {
           
            firstname: '',
            lastname: '',
            birthDate: '',
            email: '',
            phoneNumb: '',
            address: '',
            city: '',
            country: '',
            postalCode: '',
            username: '',
            password: '',
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeLNameHandler = this.changeLNameHandler.bind(this);
        this.changeBirthDateHandler = this.changeBirthDateHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePhoneNumbHandler = this.changePhoneNumbHandler.bind(this);
        this.changeAddressHandler = this.changeAddressHandler.bind(this);
        this.changeCityHandler = this.changeCityHandler.bind(this);
        this.changeCountryHandler = this.changeCountryHandler.bind(this);
        this.changePostalCodeHandler = this.changePostalCodeHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.saveMember = this.saveMember.bind(this);
    }



    saveMember = (hndl) => {
        hndl.preventDefault();
        let member = { firstName: this.state.firstname,lastName: this.state.lastname,birthDate: this.state.birthDate, email: this.state.email, phoneNumb: this.state.phoneNumb, address: this.state.address, city: this.state.city, country: this.state.country, postalCode: this.state.postalCode, username: this.state.username, password: this.state.password };
        postFormData(member)
    }
    

    changeNameHandler = (event) => {
        this.setState({ firstname: event.target.value });
    }
    changeLNameHandler = (event) => {
        this.setState({ lastname: event.target.value });
    }
    changeBirthDateHandler = (event) => {
        this.setState({ birthDate: event.target.value });
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
    changeCityHandler = (event) => {
        this.setState({ city: event.target.value });
    }
    changeCountryHandler = (event) => {
        this.setState({ country: event.target.value });
    }
    changePostalCodeHandler = (event) => {
        this.setState({ postalCode: event.target.value });
    }
    changeUsernameHandler = (event) => {
        this.setState({ username: event.target.value });
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
                                <form style = {{ marginBottom: '30mm' }} >

                                    <div className="form=group">
                                        <label> Fist Name : </label>
                                        <input placeholder="First Name" name="fname" className="form-control"
                                            value={this.state.firstname} onChange={this.changeNameHandler} />
                                    </div>
                                    <div className="form=group">
                                        <label> Last Name : </label>
                                        <input placeholder="Last Name" name="lname" className="form-control"
                                            value={this.state.lastname} onChange={this.changeLNameHandler} />
                                    </div>
                                    <div className="form=group">
                                        <label> Birth Date : </label>
                                        <input placeholder="Birth Date" name="birthDate" className="form-control"
                                            value={this.state.birthDate} onChange={this.changeBirthDateHandler} />
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
                                        <label> City : </label>
                                        <input placeholder="City" name="city" className="form-control"
                                            value={this.state.city} onChange={this.changeCityHandler} />
                                    </div>
                                    <div className="form=group">
                                        <label> Country : </label>
                                        <input placeholder="Country" name="country" className="form-control"
                                            value={this.state.country} onChange={this.changeCountryHandler} />
                                    </div>
                                    <div className="form=group">
                                        <label> Postal Code : </label>
                                        <input placeholder="Postal Code" name="postalCode" className="form-control"
                                            value={this.state.postalCode} onChange={this.changePostalCodeHandler} />
                                    </div>
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


                                    <button className="btn btn-success" onClick={this.saveMember}>Save</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{ marginLeft: "20px" }}>Back</button>
                                </form>
                            

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
export default AddMember