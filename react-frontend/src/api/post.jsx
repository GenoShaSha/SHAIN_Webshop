import axios from "axios"
export default (input) => {
    axios.post('http://localhost:8080/member', input)
        .then(response => {
            console.log(response)
        })
}