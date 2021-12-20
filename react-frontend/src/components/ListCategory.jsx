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
        this.editCat = this.editCat.bind(this);
    }
    componentDidMount(){
      axios.get("http://localhost:8080/category").then((response)=>{
           this.setState({categories: response.data}); 
        });
    }

    editCat(id){
      this.props.history.push(`/UpdateCategory/${id}`);
    }

    addCat() {
      this.props.history.push('/category');
      // window.location.href = '/category';

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
              <th>Actions</th>                              
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
                  <td>
                    <button onClick = {()=> this.editCat(category.id)} className="updateButton">Update</button>
                  </td>
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
