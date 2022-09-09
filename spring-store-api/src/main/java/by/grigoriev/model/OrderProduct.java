package by.grigoriev.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter @Getter
public class OrderProduct {

    @Id
    private Long id;

    @ManyToOne
    private Order cart;

    @ManyToOne
    private Product product;
}
