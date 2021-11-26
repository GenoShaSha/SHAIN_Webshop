import React, { Component } from 'react'
import CategoryService from '../services/CategoryService'
import { Table } from 'reactstrap';
import { Button } from 'reactstrap';

// import '../css/category.css'


class ListCategory extends Component {
    constructor(props){
        super(props)
        this.state = {
            categories: []
        }
    }
    componentDidMount(){
        CategoryService.getCategories().then((response)=>{
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
