package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.dto.Product;
import webshop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository assortment;

    @Autowired
    public void setAssortment(ProductRepository assortment) {
        this.assortment = assortment;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(assortment.getListOfAvailableProducts());
    }
    public void addProduct(Product product) {
        assortment.addProduct(product);
    }
    public Product getProductById(Integer id) {
        return assortment.getListOfAvailableProducts().stream().filter(p -> p.getId() == id).findFirst().orElseGet(null);
    }
    public Product getProductByName(String name) {
        return assortment.getListOfAvailableProducts().stream().filter(p -> p.getTitle().equals(name)).findFirst().orElseGet(null);
    }
    public int getProductLastId() {
        return assortment.getListOfAvailableProducts().stream().map(Product::getId).max(Integer::compare).get();
    }
}
