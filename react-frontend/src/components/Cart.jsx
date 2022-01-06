import React, { Component } from 'react'
import {DataContext} from './CartActions'
import {Link} from 'react-router-dom'
import "../css/Cart.css"

export class Cart extends Component {
  static contextType = DataContext;  
  
  componentDidMount() {
      this.context.getTotal();      
}

  render() {
    const { cart, increase, reduction, removeProduct, total } = this.context;    
    if (cart.length === 0) {
      return (
        <h2 className={`NoProducts`} style={{ textAlign: "center" }}>
          No products in cart
        </h2>
      );
    } else {
      return (
        <>
          {cart.map((item) => (
            <div className="details cart" key={item.id}>
              <div className="delete" onClick={() => removeProduct(item._id)}>
                X
              </div>
              <img class="CartImg" src={item.url} alt="" />
              <div className="box">
                <div className="row">
                  <h2>{item.name}</h2>
                  <span>${item.price * item.count}</span>
                </div>
                <div className="amount">
                  <button className="count" onClick={() => reduction(item.id)}>
                    {" "}
                    -{" "}
                  </button>
                  <span>{item.count}</span>
                  <button className="count" onClick={() => increase(item.id)}>
                    {" "}
                    +{" "}
                  </button>
                </div>
              </div>
            </div>
          ))}
          <div className="total">
            <Link to="/payment">Payment</Link>
            <h3>Total: ${total}</h3>
          </div>
        </>
      );
    }
  }
}
export default Cart
