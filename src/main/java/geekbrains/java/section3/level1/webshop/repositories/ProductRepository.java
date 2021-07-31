package geekbrains.java.section3.level1.webshop.repositories;

import geekbrains.java.section3.level1.webshop.main.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> listOfProducts;

    @PostConstruct
    private void init() {
        listOfProducts = new ArrayList<>(Arrays.asList(
            new Product(1L, "Хлеб", 31.70f),
            new Product(2L, "Молоко", 54.15f),
            new Product(3L, "Колбаса", 230.00f)
        ));
    }

    public List<Product> getListOfProducts() {
        return Collections.unmodifiableList(listOfProducts);
    }
    public void addProduct(Product product) {
        listOfProducts.add(product);
    }
}
