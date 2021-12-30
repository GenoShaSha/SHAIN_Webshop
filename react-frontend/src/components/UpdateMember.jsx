import axios from 'axios'
import React,{Component, useEffect, useState} from "react";

function UpdateMember(props) {
    const user = props.match.params.username
    const [Member, setMember] = useState([])
    const [FirstName, setFirstName] = useState([])
    const [LastName, setLastName] = useState([])
    const [BirthDate, setBirthDate] = useState([])
    const [Email, setEmail] = useState([])
    const [PhoneNumb, setPhoneNumb] = useState([])
    const [Address, setAddress]= useState([])
    const [City, setCity] = useState([])
    const [Country, setCountry] = useState([])
    const [PostalCode, setPostalCode] = useState([])
    const [Username, setUsername] = useState([])
    const [Password, setPassword] = useState([])



    useEffect(() => {
        axios.get(`http://localhost:8080/member/${user}`)
        .then(response =>{
            setMember(response.data)
            console.log(response.data)

        })
    },[])

    function saveMember (event){
        event.preventDefault();
        let member = {
            firstName: FirstName,
            lastName : LastName,
            birthDate : BirthDate,
            email : Email,
            phoneNumb : PhoneNumb,
            address : Address,
            city : City,
            country : Country,
            postalCode : PostalCode,
            password : Password,


          };
        axios.put(`http://localhost:8080/member/${Member.username}` , member)
        .then(response =>{
            console.log(response.data)
        })
}

return (
    
    <div>
        <div className="container">
            <div className="row">
                <div className="card col-md-6 offset-md-3 offset-md-3">
                    <h3 className="text-center">UPDATE PROFILE</h3>
                    <div className="card-body">
                        <form style = {{ marginBottom: '10mm' }} >

                            <div className="form=group">
                                <label> First Name : </label>
                                <input placeholder={Member.firstName} name="fname" className="form-control"
                                    value={FirstName} onChange={(e) => setFirstName(e.target.value)}  />
                            </div>
                            <div className="form=group">
                                <label> Last Name : </label>
                                <input placeholder={Member.lastName} name="lname" className="form-control"
                                    value={LastName} onChange={(e) => setLastName(e.target.value)}  />
                                    </div>
                            <div className="form=group">
                                <label> Birth of Date : </label>
                                <input placeholder={Member.birthDate} name="birthDate" className="form-control"
                                    value={BirthDate} onChange={(e) => setBirthDate(e.target.value)} />
                            </div>
                            <div className="form=group">
                                <label> Email : </label>
                                <input placeholder={Member.email} name="email" className="form-control"
                                    value={Email} onChange={(e) => setEmail(e.target.value)} />
                            </div>
                            <div className="form=group">
                                <label> Phone Number : </label>
                                <input placeholder={Member.phoneNumb} name="color" className="form-control"
                                    value={PhoneNumb} onChange={(e) => setPhoneNumb(e.target.value)} />
                            </div>
                            <div className="form=group">
                                <label> Address : </label>
                                <input placeholder={Member.address} name="address" className="form-control"
                                    value={Address} onChange={(e) => setAddress(e.target.value)} />
                            </div>
                            <div className="form=group">
                                <label> City : </label>
                                <input placeholder={Member.city} name="city" className="form-control"
                                    value={City} onChange={(e) => setCity(e.target.value)} />
                            </div>
                            <div className="form=group">
                                <label> Country : </label>
                                <input placeholder={Member.country} name="country" className="form-control"
                                    value={Country} onChange={(e) => setCountry(e.target.value)} />
                            </div>
                            <div className="form=group">
                                <label> Postal Code : </label>
                                <input placeholder={Member.postalCode} name="postalCode" className="form-control"
                                    value={PostalCode} onChange={(e) => setPostalCode(e.target.value)} />
                            </div>
                            <div className="form=group">
                                <label> Password : </label>
                                <input placeholder="*************" name="password" className="form-control"
                                    value={Password} onChange={(e) => setPassword(e.target.value)} />
                            </div>
                            <br></br>
                            <button className="btn btn-success" onClick={saveMember}>Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
)
}
export default UpdateMember;

