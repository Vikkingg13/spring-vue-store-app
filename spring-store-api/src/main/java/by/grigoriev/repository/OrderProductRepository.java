package by.grigoriev.repository;

import by.grigoriev.model.OrderProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {
    @Override
    void delete(OrderProduct entity);
}
