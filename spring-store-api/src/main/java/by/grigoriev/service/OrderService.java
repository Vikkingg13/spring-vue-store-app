package by.grigoriev.service;

import by.grigoriev.model.Order;

import java.util.List;

public interface OrderService {

    Order create(Order order);

    Order update(Long id, Order order);

    Order findById(Long id);

    List<Order> findAll();

    List<Order> removeById(Long id);

    void removeByOrderIdAndProductId(Long orderId, Long productId);
}
