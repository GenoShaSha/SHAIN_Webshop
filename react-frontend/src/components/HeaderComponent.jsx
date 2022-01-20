import React, { Component } from "react";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
} from "reactstrap";
import "../css/Header.css";
import axios from "axios";
import jwtDecode from "jwt-decode";

class HeaderComponent extends Component {
  constructor(props) {
    super(props);
    this.toggle = this.toggle.bind(this);
    this.state = {
      isOpen: false,
      categories: [],
      categoriesmen: [],
      username: "",
      role: null,
    };
  }
  toggle() {
    this.setState({
      isOpen: !this.state.isOpen,
    });
  }

  componentDidMount() {
    axios.get("http://localhost:8080/category/woman").then((response) => {
      this.setState({
        categories: response.data,
      });
      console.log(response.data);
    });

    axios.get("http://localhost:8080/category/man").then((response) => {
      this.setState({
        categoriesmen: response.data,
      });
      console.log(response.data);
    });

    var tok = localStorage.getItem("token");
    if (tok != null) {
      var translator = jwtDecode(tok);
      this.state.username = translator.sub;
      this.state.role = translator.role;
    }
  }

  render() {
    var username = this.state.username;
    var big = username.toUpperCase();
    return (
      <div>
        <Navbar color="dark" light expand="md">
          <NavbarBrand href="/">S. H. A. I. N.</NavbarBrand>
          <NavbarToggler onClick={this.toggle} />
          <Collapse isOpen={this.state.isOpen} navbar>
            <Nav className="ml-auto" navbar>
              <NavItem>
                <NavLink href="/">HOME</NavLink>
              </NavItem>

              <UncontrolledDropdown nav inNavbar>
                <DropdownToggle nav caret>
                  WOMEN
                </DropdownToggle>
                <DropdownMenu right>
                  {this.state.categories.map((category) => (
                    <DropdownItem
                      href={"/" + category.gender + "/" + category.name}
                    >
                      {category.name}
                    </DropdownItem>
                  ))}
                </DropdownMenu>
              </UncontrolledDropdown>

              <UncontrolledDropdown nav inNavbar>
                <DropdownToggle nav caret>
                  MEN
                </DropdownToggle>
                <DropdownMenu right>
                  {this.state.categoriesmen.map((category) => (
                    <DropdownItem
                      href={"/" + category.gender + "/" + category.name}
                    >
                      {category.name}
                    </DropdownItem>
                  ))}
                </DropdownMenu>
              </UncontrolledDropdown>

              <NavItem>
                <NavLink href="/Product/User/Wishlist">WISHLIST</NavLink>
              </NavItem>

              <NavItem>
                <NavLink href="/Product/User/Cart">CART</NavLink>
              </NavItem>

              {this.state.role == "ADMIN" ? (
                <NavItem>
                  <NavLink href="/ListOfCategory">LIST OF CATEGORY</NavLink>
                </NavItem>
              ) : (
                ""
              )}
              {this.state.role == "ADMIN" ? (
                <NavItem>
                  <NavLink href="/member">LIST OF USER</NavLink>
                </NavItem>
              ) : (
                ""
              )}
              {this.state.role == "ADMIN" ? (
                <NavItem>
                  <NavLink href="/ListOfProduct">LIST OF PRODUCT</NavLink>
                </NavItem>
              ) : (
                ""
              )}
              {this.state.role == "ADMIN" ? (
                <NavItem>
                  <NavLink href="/Product/new/Announcement">
                    ANNOUNCEMENT
                  </NavLink>
                </NavItem>
              ) : (
                ""
              )}

              {this.state.role != null ? (
                ""
              ) : (
                <UncontrolledDropdown nav inNavbar>
                  <DropdownToggle nav caret>
                    PROFILE
                  </DropdownToggle>
                  <DropdownMenu right>
                    <DropdownItem href="/SignIn">LOGIN</DropdownItem>
                    <DropdownItem href="/SignUp">REGISTER</DropdownItem>
                  </DropdownMenu>
                </UncontrolledDropdown>
              )}

              {this.state.role != null ? (
                <UncontrolledDropdown nav inNavbar>
                  <DropdownToggle nav caret className="profile">
                    {big}
                  </DropdownToggle>
                  <DropdownMenu right>
                    <DropdownItem href={"/" + this.state.username}>
                      My Profile
                    </DropdownItem>
                    <DropdownItem href="/SignOut">LOGOUT</DropdownItem>
                    <DropdownItem href="/Product/User/Order">
                      MY ORDER
                    </DropdownItem>
                  </DropdownMenu>
                </UncontrolledDropdown>
              ) : (
                ""
              )}
            </Nav>
          </Collapse>
        </Navbar>
      </div>
    );
  }
}
export default HeaderComponent;
