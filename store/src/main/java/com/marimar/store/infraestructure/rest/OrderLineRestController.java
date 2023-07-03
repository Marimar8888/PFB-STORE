package com.marimar.store.infraestructure.rest;

import com.marimar.store.application.dto.OrderLineDTO;
import com.marimar.store.application.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders/{orderId}")
public class OrderLineRestController {

    private final OrderLineService orderLineService;

    @Autowired
    public OrderLineRestController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    @CrossOrigin
    @GetMapping(value = "/orderLines", produces = "application/json")
    public ResponseEntity<List<OrderLineDTO>> getOrderLinesByOrder(@PathVariable Long orderId){
        List<OrderLineDTO> orderLinesDTO =  orderLineService.getOrderLinesByOrder(orderId);
        return new ResponseEntity<>(orderLinesDTO, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/orderLines", produces = "application/json", consumes = "application/json")
    public ResponseEntity<OrderLineDTO> createOrderLineByOrder(@PathVariable Long orderId, @RequestBody OrderLineDTO orderLineDTO){
        orderLineDTO = orderLineService.createOrderLine(orderId, orderLineDTO);
        return new ResponseEntity<>(orderLineDTO, HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping(value = "/orderLines/{orderLineId}", produces = "application/json")
    public ResponseEntity<OrderLineDTO> getOrderLine (@PathVariable Long orderId, @PathVariable Long orderLineId){
        return orderLineService
                .findByOrderIdAndId(orderId, orderLineId)
                .map(OrderLineDTO -> new ResponseEntity<>(OrderLineDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @CrossOrigin
    @PatchMapping(value = "/orderLines", produces = "application/json", consumes = "application/json")
    public ResponseEntity<OrderLineDTO> saveOrderLineByOrder(@PathVariable Long orderId, @RequestBody OrderLineDTO orderLineDTO){
        orderLineDTO = orderLineService.saveOrderLine(orderLineDTO);
        return new ResponseEntity<>(orderLineDTO, HttpStatus.CREATED);
    }

}
