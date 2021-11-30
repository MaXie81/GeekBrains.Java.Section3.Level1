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
    public void addProduct(String name, Float price) {
        int maxId = assortment.getListOfAvailableProducts().stream().map(Product::getId).max(Integer::compare).get();
        assortment.addProduct(new Product(maxId, name, price));
    }
    public Product getProductByName(String name) {
        return assortment.getListOfAvailableProducts().stream().filter(p -> p.getName().equals(name)).findFirst().get();
    }
}
