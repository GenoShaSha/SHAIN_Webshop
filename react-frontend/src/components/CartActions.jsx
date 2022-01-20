import React, { Component } from "react";
import axios from "axios";

export const DataContext = React.createContext();

export class DataProvider extends Component {
  state = {
    products: [],
    cart: [],
    wishlist: [],
    total: 0,
  };

  addCart = (id) =>{
    const { products, cart } = this.state;
    const check = cart.every((item) => {
      return item.id !== id;
    });
    if (check) {
      const data = products.filter((product) => {
        return product.id === id;
      });
      this.setState({ cart: [...cart, ...data] });
      alert("Product added to cart!");
    } else {
      alert("The product has already been added to the cart!");
    }
  };

  MoveToCart = (id) =>{
    const { wishlist, cart } = this.state;
    const check = cart.every((item) => {
      return item.id !== id;
    });
    if (check) {
      const data = wishlist.filter((product) => {
        return product.id === id;
      });
      this.setState({ cart: [...cart, ...data] });
      this.wishlistRemoveProduct(id);
      alert("Product added to cart!");
    } else {
      alert("The product has already been added to the cart!");
    }
  };

  addToWishlist = (id) =>{
    const { products, wishlist } = this.state;
    const check = wishlist.every((item) => {
      return item.id !== id;
    });
    if (check) {
      const data = products.filter((product) => {
        return product.id === id;
      });
      this.setState({ wishlist: [...wishlist, ...data] });
      alert("Product added to the wishlist!");
    } else {
      alert("The product has already been added to the wishlist!");
    }
  };

  emptyTheCart =() =>{
    this.setState({cart: [], total:0})
  }


  reduction = (id) => {
    const { cart } = this.state;
    cart.forEach((item) => {
      if (item.id === id) {
        if(item.count>0){
          item.count === 1 ? (item.count = 1) : (item.count -= 1);
        }
      }
    });
    this.setState({ cart: cart });
    this.getTotal();
  };


  increase = (id) => {
    const { cart } = this.state;
    cart.forEach((item) => {
      if (item.id === id) {
        item.count += 1;
      }
    });
    this.setState({ cart: cart });
    this.getTotal();
  };


  removeProduct = (id) => {
    if (window.confirm("Do you want to delete this product?")) {
      const { cart } = this.state;
      cart.forEach((item, index) => {
        if (item.id === id) {
          item.count = 1;
          cart.splice(index, 1);
        }
      });
      this.setState({ cart: cart });
      this.getTotal();
    }
  };
  wishlistRemoveProduct = (id) => {
      const { wishlist } = this.state;
      wishlist.forEach((item, index) => {
        if (item.id === id) {
          item.count = 1;
          wishlist.splice(index, 1);
        }
      });
      this.setState({ wishlist: wishlist });
    
  };


  getTotal = () => {
    const { cart } = this.state;
    const res = cart.reduce((prev, item) => {
      return prev + item.price * item.count;
    }, 0);
    this.setState({ total: res });
  };

  componentDidUpdate() {
    localStorage.setItem("dataCart", JSON.stringify(this.state.cart));
    localStorage.setItem("dataWishlist", JSON.stringify(this.state.wishlist));
    localStorage.setItem("dataTotal", JSON.stringify(this.state.total));
  }

  componentDidMount() {
    const dataCart = JSON.parse(localStorage.getItem("dataCart"));
    if (dataCart !== null) {
      this.setState({ cart: dataCart });
    }
    const dataWishlist = JSON.parse(localStorage.getItem("dataWishlist"));
    if (dataWishlist !== null) {
      this.setState({ wishlist: dataWishlist });
    }
    const dataTotal = JSON.parse(localStorage.getItem("dataTotal"));
    if (dataTotal !== null) {
      this.setState({ total: dataTotal });
    }
    

    axios.get("http://localhost:8080/product").then((response) => {
      this.setState({
        products: response.data,
      });
    });

  }

  render() {
    const { products, cart, total,wishlist  } = this.state;
    const { addCart, emptyTheCart, reduction, increase, removeProduct, getTotal, addToWishlist, wishlistRemoveProduct,MoveToCart} = this;
    return (
      <DataContext.Provider
        value={{
          products,
          addCart,
          emptyTheCart,
          cart,
          reduction,
          increase,
          removeProduct,
          total,
          getTotal,
          addToWishlist,
          wishlist,
          wishlistRemoveProduct,
          MoveToCart

        }}
      >
        {this.props.children}
      </DataContext.Provider>
    );
  }
}
