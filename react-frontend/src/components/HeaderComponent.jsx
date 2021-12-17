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
      username : ''
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

    var tok = localStorage.getItem("token")
    var decoded = jwtDecode(tok)
    this.state.username = decoded.sub
  }

  render() {
    const isAuthenticated = localStorage.getItem("token")

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
                    <DropdownItem href={"/" + category.gender + "/" + category.name}>
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
                    <DropdownItem href={"/" + category.gender + "/" + category.name}>
                      {category.name}
                    </DropdownItem>
                  ))}
                </DropdownMenu>
              </UncontrolledDropdown>

              <NavItem>
                <NavLink href="https://github.com/reactstrap/reactstrap">
                  WISHLIST
                </NavLink>
              </NavItem>

              <NavItem>
                <NavLink href="https://github.com/reactstrap/reactstrap">
                  CART
                </NavLink>
              </NavItem>

              <NavItem>
                <NavLink href="/ListOfCategory">LIST OF CATEGORY</NavLink>
              </NavItem>


              <NavItem>
                <NavLink href="/AddProduct">CREATE PRODUCT</NavLink>
              </NavItem>

              {isAuthenticated != null ? (
              ""
              ) : (
              <UncontrolledDropdown nav inNavbar>
              <DropdownToggle nav caret>
                PROFILE
              </DropdownToggle>
              <DropdownMenu right>
                  <DropdownItem href="/SignIn">
                    LOGIN
                  </DropdownItem>
                  <DropdownItem href="/SignUp">
                    REGISTER
                  </DropdownItem> 
              </DropdownMenu>
            </UncontrolledDropdown>
              )}
              {isAuthenticated != null ? (
                  <UncontrolledDropdown nav inNavbar>
                  <DropdownToggle nav caret>
                    PROFILE
                  </DropdownToggle>
                  <DropdownMenu right>
                  <DropdownItem href={"/" + this.state.username}>
                        My Profile
                      </DropdownItem>
                      <DropdownItem href="/SignOut">
                        LOGOUT
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
