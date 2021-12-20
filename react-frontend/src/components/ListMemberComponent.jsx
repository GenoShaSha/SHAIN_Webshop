import axios from "axios";
import React, { Component } from "react";
import { Table } from "reactstrap";
import { Button } from "reactstrap";

class ListMemberComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      members: [],
    };
  }
  componentDidMount() {
    axios.get("http://localhost:8080/member").then((response) => {
      this.setState({ members: response.data });
    });
  }

  changeRole(username) {
    axios
      .put(`http://localhost:8080/member/updateRole/${username}`)
      .then((response) => {
        window.location.href = "/member";
      });
  }

  checkRole(role) {
    if (role === "USER") {
      return "ADMIN";
    } else {
      return "USER";
    }
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
            <th>Role</th>
            <th>Make User Into</th>
          </tr>
        </thead>
        <tbody>
          {this.state.members.map((member) => (
            <tr key={member.id}>
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
              <td>{member.role}</td>
              <td>
                <button
                  onClick={() => this.changeRole(member.username)}
                  className="updateButton"
                >
                  {this.checkRole(member.role)}
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    );
  }
}
export default ListMemberComponent;
