import jwtDecode from "jwt-decode";
import Home from "./Home";


function AuthorizedAsAdmin(page) {
    var token = localStorage.getItem("token");
    if (token != null) {
      var translator = jwtDecode(token);
      if (translator.role === "ADMIN") {
        return page;
      }
    }
    return Home;
  }
  export default AuthorizedAsAdmin