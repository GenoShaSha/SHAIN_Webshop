import Axios from "axios";
import React, { Component, useEffect, useState } from "react";

function UpdateMember(props) {
  const user = props.match.params.username;
  const [Member, setMember] = useState([]);
  const [FirstName, setFirstName] = useState("");
  const [LastName, setLastName] = useState([]);
  const [BirthDate, setBirthDate] = useState([]);
  const [Email, setEmail] = useState([]);
  const [PhoneNumb, setPhoneNumb] = useState([]);
  const [Address, setAddress] = useState([]);
  const [City, setCity] = useState([]);
  const [Country, setCountry] = useState([]);
  const [PostalCode, setPostalCode] = useState([]);
  const [Password, setPassword] = useState([]);
  const [HACK, setHACK] = useState("");

  const errorMessage = "";

  useEffect(() => {
    var tok = localStorage.getItem('token');
    Axios.get(`http://localhost:8080/member/${user}`,{headers: {"Authorization" : `${tok}`}}).then((response) => {
      setMember(response.data);
      console.log(response.data);
      setHACK("WORK");
      setFirstName(Member.firstName);
      setLastName(Member.lastName);
      setBirthDate(Member.birthDate);
      setEmail(Member.email);
      setPhoneNumb(Member.phoneNumb);
      setAddress(Member.address);
      setCity(Member.city);
      setCountry(Member.country);
      setPostalCode(Member.postalCode);
    }),
      (error) => {
        console.log(error);
        this.setState({ errorMessage: error.message });
      };
  }, [HACK]);

  function saveMember(event) {
    event.preventDefault();
    var tok = localStorage.getItem('token');
    let member = {
      role: Member.role,
      firstName: FirstName,
      lastName: LastName,
      birthDate: BirthDate,
      email: Email,
      phoneNumb: PhoneNumb,
      address: Address,
      city: City,
      country: Country,
      postalCode: PostalCode,
      password: Password,
    };
    Axios.put(`http://localhost:8080/member/${Member.username}`, member,{headers: {"Authorization" : `${tok}`}}).then((response) => {
        console.log(response.data);
        alert("The profile is successfully updated!")
      });
  }

  return (
    <div>
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <h3 className="text-center">UPDATE PROFILE</h3>
            <div className="card-body">
              <form style={{ marginBottom: "10mm" }}>
                <div className="form=group">
                  <label> First Name : </label>
                  <input
                    placeholder={Member.firstName}
                    name="fname"
                    className="form-control"
                    value={FirstName}
                    onChange={(e) => setFirstName(e.target.value)}
                  />
                </div>
                <div className="form=group">
                  <label> Last Name : </label>
                  <input
                    placeholder="last name"
                    name="lname"
                    className="form-control"
                    value={LastName}
                    onChange={(e) => setLastName(e.target.value)}
                  />
                </div>
                <div className="form=group">
                  <label> Birth of Date : </label>
                  <input
                    placeholder="birth of date"
                    name="birthDate"
                    className="form-control"
                    value={BirthDate}
                    onChange={(e) => setBirthDate(e.target.value)}
                  />
                </div>
                <div className="form=group">
                  <label> Email : </label>
                  <input
                    placeholder="email"
                    name="email"
                    className="form-control"
                    value={Email}
                    onChange={(e) => setEmail(e.target.value)}
                  />
                </div>
                <div className="form=group">
                  <label> Phone Number : </label>
                  <input
                    placeholder="phone number"
                    name="color"
                    className="form-control"
                    value={PhoneNumb}
                    onChange={(e) => setPhoneNumb(e.target.value)}
                  />
                </div>
                <div className="form=group">
                  <label> Address : </label>
                  <input
                    placeholder="address"
                    name="address"
                    className="form-control"
                    value={Address}
                    onChange={(e) => setAddress(e.target.value)}
                  />
                </div>
                <div className="form=group">
                  <label> City : </label>
                  <input
                    placeholder="city"
                    name="city"
                    className="form-control"
                    value={City}
                    onChange={(e) => setCity(e.target.value)}
                  />
                </div>
                <div className="form=group">
                  <label> Country : </label>
                  <input
                    placeholder="country"
                    name="country"
                    className="form-control"
                    value={Country}
                    onChange={(e) => setCountry(e.target.value)}
                  />
                </div>
                <div className="form=group">
                  <label> Postal Code : </label>
                  <input
                    placeholder="postal code"
                    name="postalCode"
                    className="form-control"
                    value={PostalCode}
                    onChange={(e) => setPostalCode(e.target.value)}
                  />
                </div>
                <div className="form=group">
                  <label> Password : </label>
                  <input
                    placeholder="*************"
                    name="password"
                    className="form-control"
                    value={Password}
                    onChange={(e) => setPassword(e.target.value)}
                  />
                </div>
                <br></br>
                <button className="btn btn-success" onClick={saveMember}>
                  Save
                </button>
              </form>
              <br></br>
              {errorMessage && (
                <p className="error">
                  {" "}
                  {"Please use the right input on the fields!"}{" "}
                </p>
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
export default UpdateMember;
