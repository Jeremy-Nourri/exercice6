package org.example.exercice6produitsj2ee.service;

import org.example.exercice6produitsj2ee.model.Product;
import org.example.exercice6produitsj2ee.repository.ProductRepository;

import java.time.LocalDate;
import java.util.List;

public class ProductService  {

    private ProductRepository productRepository = new ProductRepository();

    public Product add(String brand, String reference, LocalDate dateOfPurchase, double price, int stock) {
        Product product = new Product(brand, reference, dateOfPurchase, price, stock);
        return productRepository.add(product);
    }

    public Product findById(int id) {
        return productRepository.findById(id);
    }

    public Product update(int id, String brand, String reference, LocalDate dateOfPurchase, double price, int stock) {
        Product product = productRepository.findById(id);
        if (product != null) {
            product.setBrand(brand);
            product.setReference(reference);
            product.setDateOfPurchase(dateOfPurchase);
            product.setPrice(price);
            product.setStock(stock);
            return productRepository.update(product);
        } else {
            return null;
        }
    }

    public boolean delete(int id) {
        Product product = productRepository.findById(id);
        return productRepository.delete(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
