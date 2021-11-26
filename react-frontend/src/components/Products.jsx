import React, { useEffect, useState } from "react";
import axios from "axios";
import { Row, Col } from "antd";
import ProductInfo from "./ProductInfo";
import { Card } from "react-bootstrap";

function Products(props) {
  const PropsName = props.match.params.name;
  const PropsGender = props.match.params.gender;
  const [Product, setProduct] = useState([]);

  useEffect(() => {
    axios
      .get(`http://localhost:8080/${PropsGender}/${PropsName}`)
      .then((response) => {
        setProduct(response.data);
        console.log();
      });
  }, []);

  return (
    <>
      <Card className="productPage">
        <Card.Img src={Product.url}></Card.Img>
        <div className="card-options">
          <Card.Title>{Product.name}</Card.Title>
          <Card.Body>
            <ProductInfo detail={Product} />
          </Card.Body>
        </div>
      </Card>
    </>
  );
}

export default Products;