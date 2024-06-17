package org.example.exercice6produitsj2ee.service;

import org.example.exercice6produitsj2ee.exeption.NotFoundException;
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
        Product productFound = productRepository.findById(id);
        if (productFound != null ) {
            return productFound;
        } else {
            throw new NotFoundException("Product not found");
        }
    }

    public Product update(int id, String brand, String reference, LocalDate dateOfPurchase, double price, int stock) {
        Product productFound = productRepository.findById(id);
        productFound.setBrand(brand);
        productFound.setReference(reference);
        productFound.setDateOfPurchase(dateOfPurchase);
        productFound.setPrice(price);
        productFound.setStock(stock);
        return productRepository.update(productFound);
    }

    public boolean delete(int id) {
        Product productFound = productRepository.findById(id);
        productRepository.delete(productFound);
        return true;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
