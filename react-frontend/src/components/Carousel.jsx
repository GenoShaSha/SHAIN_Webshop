import React from 'react';
import { UncontrolledCarousel } from 'reactstrap';
import img1 from "../images/ChineseNewYearEdition.png"
import img2 from "../images/SpringEdition.png"
import img3 from "../images/FormalEdition.png"

const items = [
  {
    src: img1 , targetURL:"/W/Dress",
  },
  {
    src: img2,
  },
  {
    src: img3,
  }
];

const Carousel = () => <UncontrolledCarousel items={items} />;

export default Carousel;