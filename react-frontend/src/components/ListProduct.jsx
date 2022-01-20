import React, { Component } from "react";
import { Table } from "reactstrap";
import { Button } from "reactstrap";
import axios from "axios";

import "../css/list.css";

class ListProduct extends Component {
  constructor(props) {
    super(props);
    this.state = {
      products: [],
    };
    // this.editProd = this.editProd.bind(this);
  }
  componentDidMount() {
    var tok = localStorage.getItem('token');
    axios.get("http://localhost:8080/product",{headers: {"Authorization" : `${tok}`}}).then((response) => {
      this.setState({ products: response.data });
    });
  }
  addProd() {
    this.props.history.push("/AddProduct");
  }
  editProd(e,artNumb) {
      e.preventDefault()
    this.props.history.push(`/Product/qty/${artNumb}`);
  }

  render() {
    return [
      <Table>
        <thead style={{ textAlign: "center" }}>
          <tr>
            <th>ID</th>
            <th>Article Number</th>
            <th>Name</th>
            <th>Price</th>
            <th>Size</th>
            <th>Quantity</th>
            <th>Update</th>
          </tr>
        </thead>
        <tbody style={{ textAlign: "center" }}>
          {this.state.products.map((product) => (
            <tr key={product.id}>
              <td>{product.id}</td>
              <td>{product.articleNumber}</td>
              <td>{product.productName}</td>
              <td>{product.price}</td>
              <td>{product.size}</td>
              <td>{product.qty}</td>
              <td>
                <Button
                  onClick={(e) => {this.editProd(e,product.articleNumber)}
          }
                  style={{ marginLeft: "10px" }}
                >
                  Update Quantity
                </Button>
              </td>
            </tr>
          ))}
        </tbody>

        <br />
      </Table>,
      <Button onClick={this.addProd.bind(this)} style={{ marginLeft: "10px" }}>
        Add New Product
      </Button>,
      
    ];
  }
}
export default ListProduct;
