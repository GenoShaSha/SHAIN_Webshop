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

class HeaderComponent extends Component {
  constructor(props) {
    super(props);
    this.toggle = this.toggle.bind(this);
    this.state = {
      isOpen: false,
      categories: [],
      categoriesmen: [],
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

              {isAuthenticated === "logged in" ? (
              ""
              ) : (
                <NavItem>
                <NavLink href="/SignIn">
                  LOGIN
                </NavLink>
              </NavItem>
              )}

              {isAuthenticated === "logged in" ? (
                <NavItem>
                  <NavLink href="/SignOut">
                    LOGOUT
                  </NavLink>
                </NavItem>
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
