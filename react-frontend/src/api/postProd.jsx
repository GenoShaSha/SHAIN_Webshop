import axios from "axios";

export default (input) => {
  axios.post("http://localhost:8080/product", input).then((response) => {
    console.log(response);
  });
};
