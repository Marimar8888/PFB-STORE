package com.marimar.store.infraestructure.rest;

import com.marimar.store.application.dto.OrderDTO;
import com.marimar.store.application.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderRestController {

    private final OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @CrossOrigin
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<List<OrderDTO>> getOrders(){
        List<OrderDTO> ordersDto = orderService.getOrders();
        return new ResponseEntity<>(ordersDto, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value = "/orders/{orderId}", produces = "application/json")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long orderId){
        return orderService
                .getOrderById(orderId)
                .map(orderDTO -> new ResponseEntity(orderDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @CrossOrigin
    @PostMapping(value ="/orders", produces = "application/json", consumes = "application/json")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDto){
        orderDto = orderService.createOrder(orderDto);
        return  new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }
    @CrossOrigin
    @DeleteMapping(value = "/orders/{orderId}" )
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
