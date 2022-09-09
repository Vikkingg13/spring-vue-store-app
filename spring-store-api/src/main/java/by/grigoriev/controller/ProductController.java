package by.grigoriev.controller;

import by.grigoriev.dto.ProductDto;
import by.grigoriev.model.Product;
import by.grigoriev.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.grigoriev.converter.ProductConverter.toProduct;

@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product create(@RequestBody ProductDto dto) {
        return productService.create(toProduct(dto));
    }

    @PutMapping("{id}")
    public Product update(@PathVariable Long id, @RequestBody ProductDto dto) {
        return productService.update(id, toProduct(dto));
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("order/{id}")
    public List<Product> findByOrderId(@PathVariable Long id) {
        return productService.findByOrderId(id);
    }

    @DeleteMapping("{id}")
    public List<Product> removeById(@PathVariable Long id) {
        return productService.removeById(id);
    }

}
