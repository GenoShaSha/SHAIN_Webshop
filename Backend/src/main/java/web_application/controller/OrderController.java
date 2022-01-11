package web_application.controller;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web_application.interfaces.IOrderService;
import web_application.interfaces.IProductRepo;
import web_application.interfaces.IProductService;
import web_application.model.Member;
import web_application.model.Order;
import web_application.model.Product;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/order")

public class OrderController {

    @Autowired
    IOrderService logic;


    @PostMapping()
    public ResponseEntity createOrder(@RequestBody Order order) {
        if(logic.AddOrder(order)){
            return new ResponseEntity(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder() {
        return ResponseEntity.ok().body(logic.GetAllOrder());
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Order>> getOrderbyUsername(@PathVariable String username){
        List<Order> o = logic.getOrdersByUsername(username);
        return ResponseEntity.ok().body(o);
    }
}
