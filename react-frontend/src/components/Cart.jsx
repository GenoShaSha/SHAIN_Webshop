import React, { Component } from 'react'
import {DataContext} from './CartActions'
import { Card, CardImg, CardBody,
  CardTitle, CardSubtitle, Button } from 'reactstrap';
import jwtDecode from 'jwt-decode'
import axios from 'axios'
import "../css/Cart.css"
import { Label, Input } from "reactstrap";

export class Cart extends Component {
  constructor(props) {
    super(props);
    this.state = {
      address: ""
    };
  }
  static contextType = DataContext;  

  componentDidMount() {
    this.context.getTotal();
}


completeOrder(){
    var CartItems = localStorage.getItem("dataCart");
    var CartTotal = localStorage.getItem("dataTotal");
    var tUsername = null;

    const token = localStorage.getItem("token");
    if (token != null) {
      const translator = jwtDecode(token);
      tUsername = translator.sub;
    }
    var items = JSON.parse(CartItems)

    console.log(items);
    var adder = this.state.address;
    console.log(adder);

    axios
      .post("http://localhost:8080/order",{ totalPrice:CartTotal, username:tUsername, products:items,address : adder})
      .then((response) => {
        console.log(response.data);
        localStorage.removeItem("dataCart");
        localStorage.removeItem("dataTotal");
        alert("The order has been process!")
      });

}

  render() {
    const { cart, increase, reduction, removeProduct, total } = this.context;    
    if (cart.length === 0) {
      return (
        <h2 className={`NoProducts`} style={{ textAlign: "center" }}>
          No products found in your CART, you can add some products!
        </h2>
      );
    } else {
      return (
        <div>
        <div className="cart">
          <label htmlFor="cart" style={{fontSize:"50px"}}>MY CART</label>
        <div className="grid-container">
            {cart.map((product) => (   
          <div>
            <div className="wrapper">
              <Card>
              <CardImg src={product.url} alt="Card image cap" />
              <CardBody>
                <CardTitle>Name :{product.productName}</CardTitle>
                <CardSubtitle>Size :{product.size}</CardSubtitle>
                <CardSubtitle>Single item price :€{product.price}</CardSubtitle>
                <CardSubtitle>Total product Price :€{product.price * product.count}</CardSubtitle>
                <Button style={{marginRight:"10px"}} onClick={()=> increase(product.id)}>{" "} + {" "}</Button>
                <span>{product.count}</span>
                <Button style={{marginRight:"10px"}} onClick={()=> reduction(product.id)}>{" "} - {" "}</Button>
                <br></br>
                <br></br>
                <Button style={{marginRight:"10px"}} onClick={()=> removeProduct(product.id)}>REMOVE FROM CART</Button>
              </CardBody>
            </Card>
            <br></br>
          </div>
          </div>
          ))}
        </div>
        <Label for="CatName">Address:</Label>
        <Input
            type="name"
            name="name"
            id="Name"
            placeholder="Address"
            value={this.state.address}
            onChange={(event) => this.setState({address : event.target.value})}
          />
        <br></br>

        <Button onClick={this.completeOrder.bind(this)} style={{ marginLeft: "10px" }}>
          COMPLETE OEDER
        </Button>
       </div>
        <h2 className='totalPrice'>Total Price :€{total}</h2>
        <br></br>
        </div>
      );
    }
  }
}
export default Cart
