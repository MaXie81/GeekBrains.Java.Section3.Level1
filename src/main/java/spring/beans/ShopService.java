package spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.classes.Product;

import java.util.List;

@Component
public class ShopService {
    private ProductRepository assortment;

    @Autowired
    public ShopService(ProductRepository assortment) {
        this.assortment = assortment;
    }

    public List<Product> getAllProducts() {
        return assortment.getListOfAvailableProducts();
    }
    public Product getProductByName(String name) {
        return assortment.getListOfAvailableProducts().stream().filter(p -> p.getName().equals(name)).findFirst().get();
    }
}
