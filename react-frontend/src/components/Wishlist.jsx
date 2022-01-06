import React, { Component } from "react";
import { Card, CardImg, CardBody,
  CardTitle, CardSubtitle, Button } from 'reactstrap';
import "../css/Wishlist.css"
import { DataContext } from "./CartActions";

class Wishlist extends Component {
  
  static contextType = DataContext;

  render() {
    const{wishlist, wishlistRemoveProduct, MoveToCart} = this.context;

if(wishlist.length === 0){
    return(
        <div className="noProducts">
            <h2>
            No Product in the WISHLIST, you can add some product!
            </h2>
        </div>
    )
}
else{
    return (
        <div className="wishlist">
          <label htmlFor="wishlist" style={{fontSize:"50px"}}>WISHLIST</label>
        <div className="grid-container">
            {wishlist.map((product) => (   
          <div>
            <div className="wrapper">
              <Card>
              <CardImg src={product.url} alt="Card image cap" />
              <CardBody>
                <CardTitle>Name :{product.productName}</CardTitle>
                <CardSubtitle>Size :{product.size}</CardSubtitle>
                <CardSubtitle>Price :{product.price}</CardSubtitle>
                <Button style={{marginRight:"10px"}} onClick={()=> MoveToCart(product.id)}> ADD TO CART</Button>
                <Button style={{marginRight:"10px"}} onClick={()=> wishlistRemoveProduct(product.id)}> REMOVE FROM WISHLIST</Button>
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
export default Wishlist;
