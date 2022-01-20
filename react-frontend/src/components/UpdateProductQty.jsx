import Axios from "axios";
import React, { Component, useEffect, useState } from "react";
import { FormGroup, Label, Input } from "reactstrap";

function UpdateProductQty(props) {
  const articleNumber = props.match.params.artNumb;
  const [Product, setProduct] = useState([]);
  const [Quantity, setQuantity] = useState([]);
  const [HACK, setHACK] = useState("");
  const errorMessage = "";

  useEffect(() => {
    var tok = localStorage.getItem('token');
    Axios.get(`http://localhost:8080/product/${articleNumber}`,{headers: {"Authorization" : `${tok}`}}) .then((response) => {
        setProduct(response.data);
        console.log(response.data);
        setHACK("WORK");
        setQuantity(Product.qty);
      }),
      (error) => {
        console.log(error);
        this.setState({ errorMessage: error.message });
      };
  }, [HACK]);

  function saveProduct(event) {
    event.preventDefault();
    var tok = localStorage.getItem('token');
    let product = {
      qty: Quantity,
    };
    Axios.put(`http://localhost:8080/product/${Product.articleNumber}`, product)
      .then((response) => {
        console.log(response.data);
        window.location.href = "/ListOfProduct";
      });
  }

  return (
    <div>
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <h3 className="text-center">UPDATE PRODUCT</h3>
            <div className="card-body">
              <form style={{ marginBottom: "10mm" }}>
                <div className="form=group">
                  <label> Product Name : </label>
                  <input
                    placeholder={Product.productName}
                    name="pName"
                    className="form-control"
                    value={Product.productName}
                  />
                </div>
                <div className="form=group">
                  <label>Quantity : </label>
                  <input
                    placeholder="qnty"
                    name="qnty"
                    className="form-control"
                    value={Quantity}
                    onChange={(e) => setQuantity(e.target.value)}
                  />
                </div>
                <br></br>
                <button className="btn btn-success" onClick={saveProduct}>
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
export default UpdateProductQty;
