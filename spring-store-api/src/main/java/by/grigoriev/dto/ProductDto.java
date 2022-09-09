package by.grigoriev.dto;

import lombok.Data;

@Data
public class ProductDto {

    private String title;

    private String description;

    private int amount;

    private double price;

}