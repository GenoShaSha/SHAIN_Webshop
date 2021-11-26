import React from 'react';
import { Switch } from 'react-router';
import { Button, Form, FormGroup, Label, Input, FormText } from 'reactstrap';
import postFormData from '../api/postCat'
import '../css/category.css'

export default class AddCategory extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            code: '',
            name: '',
            gender: '',

        }
        this.changeCodeHandler = this.changeCodeHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeGenderHandler = this.changeGenderHandler.bind(this);
        this.saveCat = this.saveCat.bind(this);
    }

    saveCat = (hndl) => {
        hndl.preventDefault();
        let category = { catCode: this.state.code, name: this.state.name, gender: this.state.gender};
        postFormData(category)
    }


    

    changeCodeHandler = (event) => {
        this.setState({ code: event.target.value });
    }
    changeNameHandler = (event) => {
        this.setState({ name: event.target.value });
    }
    changeGenderHandler = (event) => {
        this.setState({ gender: event.target.value });
    }

    back() {
        this.props.history.push('/ListOfCategory');
    }

    

  render() {
    return (
      <Form>
        <legend className="CatTitle">Category</legend>
        <FormGroup>
          <Label for="CatCode">Code</Label>
          <Input type="code" name="code" id="CatCode" placeholder="Code"             
          value={this.state.code} onChange={this.changeCodeHandler} />
        </FormGroup>
        <FormGroup>
          <Label for="CatName">Name</Label>
          <Input type="name" name="name" id="CatName" placeholder="Name"           
          value={this.state.name} onChange={this.changeNameHandler} />
        </FormGroup>
        <FormGroup>
          <Label for="Gender">Select Gender</Label>
          <Input type="select" name="select" id="exampleSelect" 
          value = {this.state.gender} onChange={this.changeGenderHandler}>
            <option value="" select disabled>Select gender</option>
            <option value="M">M</option>
            <option value="W">W</option>
          </Input>
        </FormGroup>
        <Button  onClick={this.saveCat} style={{marginLeft:"10px"}}>Submit</Button>
        <Button  onClick={this.back.bind(this)} style={{marginLeft:"10px"}}>Back</Button>
      </Form>
    );
    }
  }