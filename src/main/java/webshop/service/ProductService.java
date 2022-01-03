package webshop.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import webshop.model.Product;
import webshop.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public List<Product> getAllProductsPage(Pageable pageable) {
        return productRepository.findAll(pageable).stream().collect(Collectors.toList());
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    public void addProduct(Product product) {
        productRepository.save(product);
    }
    public void editProduct(Product product) {
        productRepository.save(product);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);}
    public Long getProductLastId() {
        return productRepository.getLastId();
    }
}
