package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.dto.Product;
import webshop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository assortment;

    @Autowired
    public void setAssortment(ProductRepository assortment) {
        this.assortment = assortment;
    }

    public List<Product> getAllProducts() {
        return assortment.findAll();
    }
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = assortment.findById(id);
        return optionalProduct.isPresent() ? optionalProduct.get() : new Product(null, null, null) ;
    }
    public Product getProductByName(String name) {
        Optional<Product> optionalProduct = assortment.findAll()
                .stream()
                .filter(p -> p.getTitle().equals(name))
                .findFirst();
        return optionalProduct.isPresent() ? optionalProduct.get() : new Product(null, null, null) ;
    }
    public void addProduct(Product product) {
        assortment.save(product);
    }
    public void deleteProductById(Long id) {assortment.deleteById(id);}
    public Long getProductLastId() {
        return assortment.findAll().stream().map(Product::getId).max(Long::compare).get();
    }
}
