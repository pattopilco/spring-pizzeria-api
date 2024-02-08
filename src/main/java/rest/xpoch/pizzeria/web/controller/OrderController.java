package rest.xpoch.pizzeria.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rest.xpoch.pizzeria.persistence.entity.OrderEntity;
import rest.xpoch.pizzeria.persistence.projection.OrderSummary;
import rest.xpoch.pizzeria.service.OrderService;
import rest.xpoch.pizzeria.service.dto.RandomOrderDto;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAll() {
        return ResponseEntity.ok(this.orderService.getAll());
    }

    @GetMapping("/today")
    public ResponseEntity<List<OrderEntity>> getTodayOrders() {
        return ResponseEntity.ok(this.orderService.getTodayOrders());
    }

    @GetMapping("/outside")
    public ResponseEntity<List<OrderEntity>> getOutsideOrders() {
        return ResponseEntity.ok(this.orderService.getOutsideOrders());
    }

    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<List<OrderEntity>> getCustomerOrders(@PathVariable String idCustomer) {
        return ResponseEntity.ok(this.orderService.getCustomerOrders(idCustomer));
    }

    @GetMapping("/summary/{orderId}")
    public ResponseEntity<OrderSummary> getSummary(@PathVariable int orderId) {
        return ResponseEntity.ok(this.orderService.getSummary(orderId));
    }

    @PostMapping("/random")
    public ResponseEntity<Boolean> randomOrder(@RequestBody RandomOrderDto randomOrderDto){
        return ResponseEntity.ok(this.orderService.saveRandomOrder(randomOrderDto));
    }
    
}
