package by.grigoriev.repository;

import by.grigoriev.model.Order;
import by.grigoriev.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
