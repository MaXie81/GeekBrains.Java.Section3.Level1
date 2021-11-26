package spring.beans;

import org.springframework.stereotype.Component;
import spring.classes.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    private void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Хлеб", 31.20f));
        productList.add(new Product(2, "Молоко", 57.63f));
        productList.add(new Product(3, "Мясо", 416.00f));
    }

    public List<Product> getProductList() {
        return productList;
    }
}
