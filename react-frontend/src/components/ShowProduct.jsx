import React, { Component } from "react";
import axios from "axios";
import { Card, CardImg, CardText, CardBody,
  CardTitle, CardSubtitle, Button } from 'reactstrap';
import "../css/Card.css"

class ShowProduct extends Component {
  constructor(props) {
    super(props);
    this.state = {
      products: [],
      gender: this.props.match.params.gender,
      name: this.props.match.params.name,
    };
  }

  componentDidMount() {
    axios
      .get(
        `http://localhost:8080/product/${this.state.gender}/${this.state.name}`
      )
      .then((response) => {
        this.setState({
          products: response.data,
        });
        console.log(this.state.products);
      });
  }

  render() {
    return (
      <div className="categoryName">
        <label htmlFor="categoryName" style={{fontSize:"50px"}}>{this.state.name}</label>
      <div className="grid-container">
        {this.state.products.map(product => (   
        <div>
          <div className="wrapper">
            <Card>
            <CardImg src={product.url} alt="Card image cap" />
            <CardBody>
              <CardTitle>Name :{product.productName}</CardTitle>
              <CardSubtitle>Size :{product.size}</CardSubtitle>
              <CardSubtitle>Price :{product.price}</CardSubtitle>
              <CardText>Some quick example text to build on the card title and make up the bulk of the card's content.</CardText>
              <Button style={{marginRight:"10px"}}>CART</Button>
              <Button style={{marginRight:"10px"}}> WISHLIST</Button>
              <Button style={{marginRight:"10px"}}>DESCRIPTION</Button>
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
export default ShowProduct;
