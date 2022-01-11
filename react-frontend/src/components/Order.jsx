import React, { Component } from "react";
import axios from "axios";
import {
  Card,
  CardImg,
  CardText,
  CardBody,
  CardTitle,
  CardSubtitle,
  Button,
} from "reactstrap";
import jwtDecode from "jwt-decode";
import "../css/Order.css"

class Order extends Component {
  constructor(props) {
    super(props);
    this.state = {
      orders: [],
    };
  }

  componentDidMount() {
    const token = localStorage.getItem("token");
    var translator = {};
    var role = "";
    var username = "";
    if (token != null) {
      translator = jwtDecode(token);
      role = translator.role;
      username = translator.sub;
    }
    if (role === "USER") {
      axios.get(`http://localhost:8080/order/${username}`).then((response) => {
        this.setState({
          orders: response.data,
        });
      });
    } else if (role === "ADMIN") {
      axios.get(`http://localhost:8080/order`).then((response) => {
        this.setState({
          orders: response.data,
        });
      });
    }
  }

  render() {
    if (this.state.orders.length === 0) {
        return (
          <h2 className={`NoProducts`} style={{ textAlign: "center" }}>
            No orders found!
          </h2>
        );
      } else {
  
    return (
      <div className="orderTitle">
        <label htmlFor="order" style={{ fontSize: "40px" }}>
          Orders
        </label>
        <div className="grid-containerCart">
          {this.state.orders.map((order) => (
            <div>
              <div className="wrapper">
                <Card>
                  <CardBody>
                    <CardTitle
                      className="order"
                      style={{ fontWeight: "bolder" }}
                    >
                    Order Reference: {order.orderReference}
                    </CardTitle>
                    <CardSubtitle></CardSubtitle>
                    {order.products.map((product) => (
                      <div>
                        <div className="wrapper">
                          <Card>
                            <CardImg src={product.url} alt="Card image cap" />
                            <CardBody>
                              <CardTitle>Name :{product.productName}</CardTitle>
                              <CardSubtitle>Size :{product.size}</CardSubtitle>
                            </CardBody>
                          </Card>
                          <br></br>
                        </div>
                      </div>
                    ))}
                    Total Price Of Order :€{order.totalPrice}
                  </CardBody>
                </Card>
                <br></br>
              </div>
            </div>
          ))}
        </div>
      </div>
    );
  }
}
}
export default Order;
