package web_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web_application.interfaces.IOrderService;
import web_application.model.Order;
import web_application.model.Product;

import java.net.URI;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/order")

public class OrderController {

    @Autowired
    IOrderService logic;

//    @PostMapping()
//    public ResponseEntity createOrder(@RequestBody Order order) {
//
//    }

}
