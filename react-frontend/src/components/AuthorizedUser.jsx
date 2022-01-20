import jwtDecode from "jwt-decode";
import Home from "./Home";

function AuthorizedUser(page) {
    var token = localStorage.getItem("token");
    if (token != null) {
      var translator = jwtDecode(token);
      if (translator.role === "USER" || translator.role === "ADMIN") {
        return page;
      } else {
        return Home;
      }
    }
    return Home;
  }
  export default AuthorizedUser