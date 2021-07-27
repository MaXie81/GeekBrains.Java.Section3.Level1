package spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.classes.Product;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProduct() {
        return repository.getListOfProduct();
    }
    public Product getProductById(long id) {
        return repository.getListOfProduct().stream().filter(p -> p.getId() == id).findFirst().get();
    }
}
