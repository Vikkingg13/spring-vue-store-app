package by.grigoriev.converter;

import by.grigoriev.dto.ProductDto;
import by.grigoriev.model.Product;

public class ProductConverter {

    public static Product toProduct(ProductDto dto) {
        Product product = new Product();
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setAmount(dto.getAmount());
        return product;
    }

}
