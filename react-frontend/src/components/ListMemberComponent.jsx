import React, { Component } from 'react'
import MemberService from '../services/MemberService'
import '../css/home.css'

class ListMemberComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
            members: []
        }
        this.signUp = this.signUp.bind(this); 
    }
    componentDidMount(){
        MemberService.getMembers().then((response)=>{
           this.setState({members: response.data}); 
        });
    }

    signUp(){
        this.props.history.push('/signUp');
    }
    render() {
        return (
            <div>
                <h2 className="text-center">List of Member</h2>     
                 <div className="row">
                     <button className="btn btn-primary" onClick={this.signUp}>Sign Up</button>
                 </div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                            <tr>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Birth Date</th>                               
                                <th>Email</th>
                                <th>Phone Number</th>
                                <th>Address</th>
                                <th>City</th>
                                <th>Country</th>
                                <th>Postal Code</th>
                                <th>Username</th>
                                <th>Password</th>
                            </tr>
                        <tbody>
                            {
                                this.state.members.map(
                                    member =>
                                    <tr key = {member.id}>
                                        <td>{member.firstName}</td>
                                        <td>{member.lastName}</td>
                                        <td>{member.birthDate}</td>
                                        <td>{member.email}</td>
                                        <td>{member.phoneNumb}</td>
                                        <td>{member.address}</td>
                                        <td>{member.city}</td>
                                        <td>{member.country}</td>
                                        <td>{member.postalCode}</td>
                                        <td>{member.username}</td>
                                        <td>{member.password}</td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>          
            </div>
        )
    }
}
export default ListMemberComponent
