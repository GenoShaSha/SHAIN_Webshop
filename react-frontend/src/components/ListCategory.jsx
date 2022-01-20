import React, { Component } from 'react'
import { Table } from 'reactstrap';
import { Button } from 'reactstrap';
import axios from 'axios';

import '../css/list.css'


class ListCategory extends Component {
    constructor(props){
        super(props)
        this.state = {
            categories: []
        }
    }
    componentDidMount(){
      var tok = localStorage.getItem('token');
      axios.get("http://localhost:8080/category",{headers: {"Authorization" : `${tok}`}}).then((response)=>{
           this.setState({categories: response.data}); 
        });
    }

    addCat() {
      this.props.history.push('/category');
  }

    render() {
        return (
[
          <Table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Code</th>
              <th>Gender</th>
              <th>Name</th> 
            </tr>
          </thead>
          <tbody>
            {
              this.state.categories.map(
                category =>
                <tr key = {category.id}>
                  <td>{category.id}</td>
                  <td>{category.catCode}</td>
                  <td>{category.gender}</td>
                  <td>{category.name}</td>
                
                </tr>
              )
            }
          </tbody>   

          
          <br/>
          </Table>,
            <Button  onClick={this.addCat.bind(this)} style={{marginLeft:"10px"}}>Add New Category</Button>
]


      )
    }
}
export default ListCategory
