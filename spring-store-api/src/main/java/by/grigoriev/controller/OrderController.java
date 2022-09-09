package by.grigoriev.controller;

import by.grigoriev.model.Order;
import by.grigoriev.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @PutMapping("{id}")
    public Order update(@PathVariable Long id, @RequestBody Order order) {
        return orderService.update(id, order);
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("{id}")
    public Order findById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @DeleteMapping("{id}")
    public List<Order> removeById(@PathVariable Long id) {
        return orderService.removeById(id);
    }

    @DeleteMapping
    public void removeProductFromOrder(@RequestParam Long orderId, @RequestParam Long productId) {
        orderService.removeByOrderIdAndProductId(orderId, productId);
    }
}
