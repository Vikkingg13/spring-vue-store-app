package by.grigoriev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "product")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private int amount;

    private double price;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.REMOVE})
    @JsonIgnore
    private List<OrderProduct> orderProduct;
}
