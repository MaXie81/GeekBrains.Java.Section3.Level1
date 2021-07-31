package geekbrains.java.section3.level1.webshop.servicies;

import geekbrains.java.section3.level1.webshop.main.Product;
import geekbrains.java.section3.level1.webshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getListOfProducts();
    }
    public Product getProductById(Long id) {
        return productRepository.getListOfProducts().stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }
    public void addProduct(long id, String title, float cost) {
        productRepository.addProduct(new Product(id, title, cost));
    }
    public long getId() {
        long maxId;
        maxId = productRepository.getListOfProducts().stream().mapToLong(product -> product.getId()).max().getAsLong();
        return ++maxId;
    }
}
