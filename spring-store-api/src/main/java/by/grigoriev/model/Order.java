package by.grigoriev.model;

import by.grigoriev.model.type.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Table(name = "cart")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String customerName;

    private String customerPhone;

    @OneToMany(mappedBy = "cart", cascade = {CascadeType.REMOVE})
    @JsonIgnore
    private List<OrderProduct> orderProduct;
}
