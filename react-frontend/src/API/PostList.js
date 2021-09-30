import React, { Component } from "react";
import axios from "axios";

class PostList extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             posts : []
        }
    }
    
    
    componentDidMount() {
        axios.get('http://localhost:8080/member')
        .then(response =>{
            this.setState({
                posts: response.data
            })
            console.log(response.data)
        })
    }

    render() {
        const {posts} = this.state
        return(
            <div>
                <h1>List Of Members</h1>
                {
                    posts.map(post => <div key={post.memberID}>{post.name}</div>)
                }   
            </div>
        )
    }
}

export default PostList