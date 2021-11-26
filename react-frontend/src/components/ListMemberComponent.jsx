import React, { Component } from 'react'
import MemberService from '../services/MemberService'
import { Table } from 'reactstrap';

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
            <Table>
            <thead>
              <tr>
              <th>ID</th>
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
            </thead>
            <tbody>
              {
                this.state.members.map(
                  member =>
                  <tr key = {member.id}>
                    <td>{member.id}</td>
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
            </Table>
        )
    }
}
export default ListMemberComponent
