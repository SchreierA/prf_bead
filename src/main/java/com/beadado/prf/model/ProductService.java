package com.beadando.prf.model;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int id);
    void deleteProductById(int id);
    void reduceProductQuantity(int productId);
}
