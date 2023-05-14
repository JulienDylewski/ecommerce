package fr.limayrac.ecommerce.service;

import fr.limayrac.ecommerce.model.Product;
import fr.limayrac.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(final Integer id) {
        return productRepository.findById(id);
    }
}
