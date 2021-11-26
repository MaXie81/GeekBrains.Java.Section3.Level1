package spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.classes.Product;

import java.util.List;

@Component
public class ShopService {
    private ProductRepository repository;

    @Autowired
    public ShopService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.getListOfAvailableProducts();
    }
    public Product getProductByName(String name) {
        return repository.getListOfAvailableProducts().stream().filter(p -> p.getName().equals(name)).findFirst().get();
    }
}
