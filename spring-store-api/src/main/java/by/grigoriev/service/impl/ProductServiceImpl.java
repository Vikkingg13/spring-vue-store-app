package by.grigoriev.service.impl;

import by.grigoriev.exeption.ProductNotFoundException;
import by.grigoriev.model.Order;
import by.grigoriev.model.OrderProduct;
import by.grigoriev.model.Product;
import by.grigoriev.repository.OrderRepository;
import by.grigoriev.repository.ProductRepository;
import by.grigoriev.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        }
        throw new ProductNotFoundException("Товар не был найден");
    }

    @Override
    public Product findById(Long id) {
        var product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("Товар не был найден");
        }
        return product.get();
    }

    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> findByOrderId(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(() -> new RuntimeException("Заказ не найден"))
                .getOrderProduct().stream()
                .map(OrderProduct::getProduct)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> removeById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return findAll();
        }
        throw new ProductNotFoundException("Товар не был найден");
    }
}
