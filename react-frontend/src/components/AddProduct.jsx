import React from 'react';
import { Switch } from 'react-router';
import { Button, Form, FormGroup, Label, Input, FormText } from 'reactstrap';
import postFormData from '../api/postProd'
import '../css/category.css'
import axios from 'axios';

export default class AddProduct extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            artNumb: '',
            name: '',
            categories: [],
            size: '',
            quantity: '',
            price: '',
            category: '',


        }
        this.changeArtNumbHandler = this.changeArtNumbHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeCategoryHandler = this.changeCategoryHandler.bind(this);
        this.changeSizeHandler = this.changeSizeHandler.bind(this);
        this.changeQuantityHandler = this.changeQuantityHandler.bind(this);
        this.changePriceHandler = this.changePriceHandler.bind(this);

        this.saveProd = this.saveProd.bind(this);
    }

    saveProd = (hndl) => {
        hndl.preventDefault();
        const product = { articleNumber: this.state.artNumb, productName: this.state.name, categoryId: this.state.category, size: this.state.size, qty: this.state.quantity, price: this.state.price};
        console.log(product);
        axios.post("http://localhost:8080/product", product).then((response) => {
            console.log(response);
    });
    }

    
  componentDidMount() {
    axios.get("http://localhost:8080/category").then((response) => {
      this.setState({
        categories: response.data,
      });
      console.log(response.data);
    });
}



    changeArtNumbHandler = (event) => {
        this.setState({ artNumb: event.target.value });
    }
    changeNameHandler = (event) => {
        this.setState({ name: event.target.value });
    }
    changeCategoryHandler = (event) => {
        this.setState({ category: this.state.categories[event.target.value] });
        console.log(this.state.category);
    }
    changeSizeHandler = (event) => {
        this.setState({ size: event.target.value });
    }
    changeQuantityHandler = (event) => {
        this.setState({ quantity: event.target.value });
    }
    changePriceHandler = (event) => {
        this.setState({ price: event.target.value });
    }

    back() {
        this.props.history.push('/ListOfCategory');
    }

    

  render() {
    return (
      <Form>
        <legend className="CatTitle">New Product</legend>
        <FormGroup>
          <Label for="artNumb">Article Number:</Label>
          <Input type="artNumb" name="artNumb" id="artNumb" placeholder="artNumb"             
          value={this.state.artNumb} onChange={this.changeArtNumbHandler} />
        </FormGroup>
        <FormGroup>
          <Label for="CatName">Name:</Label>
          <Input type="name" name="name" id="CatName" placeholder="Name"           
          value={this.state.name} onChange={this.changeNameHandler} />
        </FormGroup>
        <FormGroup>
          <Label for="Gender">Select category</Label>
          <Input type="select" name="select" id="exampleSelect" 
          value = {this.state.category} onChange={this.changeCategoryHandler}>
            <option value="" select disabled>Select category</option>
            {this.state.categories.map((category,index) => (
                         <option value={category.id}>{category.name} {category.id}- Gender: {category.gender} </option>
                  ))}
          </Input>
        
        </FormGroup>
        <FormGroup>
          <Label for="size">Size:</Label>
          <Input type="size" name="size" id="size" placeholder="size"           
          value={this.state.size} onChange={this.changeSizeHandler} />
        </FormGroup>
        <FormGroup>
          <Label for="quantity">Quantity:</Label>
          <Input type="quantity" name="quantity" id="quantity" placeholder="quantity"           
          value={this.state.quantity} onChange={this.changeQuantityHandler} />
        </FormGroup>
        <FormGroup>
          <Label for="price">Price:</Label>
          <Input type="price" name="price" id="price" placeholder="price"           
          value={this.state.price} onChange={this.changePriceHandler} />
        </FormGroup>
        <Button  onClick={this.saveProd} style={{marginLeft:"10px"}}>Submit</Button>
        <Button  onClick={this.back.bind(this)} style={{marginLeft:"10px"}}>Back</Button>
      </Form>
    );
    }
  }
