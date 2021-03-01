package com.recorg.recipeorganizer.controller;

import com.recorg.recipeorganizer.entity.Product;
import com.recorg.recipeorganizer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService theProductService) {
        productService = theProductService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable int productId) {
        Product theProduct = productService.getProduct(productId);

        if (theProduct == null) {
            throw new RuntimeException("Product with the id of " + productId + " not found.");
        }

        return theProduct;
    }

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product theProduct) {

        theProduct.setId(0);

        productService.saveProduct(theProduct);

        return theProduct;
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        Product tempProduct = productService.getProduct(productId);

        if (tempProduct == null) {
            throw new RuntimeException("Product of id " + productId + " not found");
        }

        productService.deleteProduct(productId);

        return "Deleted product of id " + productId;
    }
}
