package by.grigoriev.service.impl;

import by.grigoriev.exeption.OrderNotFoundException;
import by.grigoriev.exeption.ProductNotFoundException;
import by.grigoriev.model.Order;
import by.grigoriev.model.OrderProduct;
import by.grigoriev.repository.OrderProductRepository;
import by.grigoriev.repository.OrderRepository;
import by.grigoriev.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderProductRepository orderProductRepository;

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Long id, Order order) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
            return orderRepository.save(order);
        }
        throw new ProductNotFoundException("Товар не был найден");
    }

    @Override
    public Order findById(Long id) {
        var product = orderRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("Товар не был найден");
        }
        return product.get();
    }

    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public List<Order> removeById(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return findAll();
        }
        throw new OrderNotFoundException("Заказ не найден!");
    }

    @Override
    public void removeByOrderIdAndProductId(Long orderId, Long productId) {
        OrderProduct orderProduct = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Заказ с таким Id не был найден"))
                .getOrderProduct()
                .stream()
                .filter(e -> e.getProduct().getId().equals(productId))
                .findFirst().orElseThrow(() -> new ProductNotFoundException("Товар с таким Id не был найден"));
        System.out.println(orderProduct.getProduct().getId());
        orderProductRepository.delete(orderProduct);
    }


}

