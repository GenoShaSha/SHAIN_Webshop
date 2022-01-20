import Home from "./Home";

function AuthenticatedUser(page) {
    var token = localStorage.getItem("token");
    if (token != null) {
      return Home;
    }
    return page;
  }
  export default AuthenticatedUser