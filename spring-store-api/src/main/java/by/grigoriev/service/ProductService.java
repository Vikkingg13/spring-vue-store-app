package by.grigoriev.service;

import by.grigoriev.model.Order;
import by.grigoriev.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductService {

    Product create(Product product);

    Product update(Long id, Product product);

    Product findById(Long id);

    List<Product> findAll();

    List<Product> findByOrderId(Long id);

    List<Product> removeById(Long id);


}
