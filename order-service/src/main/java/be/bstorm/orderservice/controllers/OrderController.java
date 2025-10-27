package be.bstorm.orderservice.controllers;

import be.bstorm.orderservice.services.OrderService;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}")
    public String getOrder(@PathVariable("orderId") String orderId){
        System.out.println("Id recu : " + orderId);

        orderService.createOrder();

        return "777";
    }
}
