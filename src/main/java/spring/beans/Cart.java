package spring.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import spring.classes.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {return productList;}
    public void addProduct(Product product) {productList.add(product);}
    public void findAndRemoveProduct(String name, boolean isAll) {
        Product product = productList.stream().filter(p -> p.getName().equals(name)).findFirst().get();

        if (product == null) return;

        if (isAll)
            productList.removeIf(p -> p == product);
        else
            productList.remove(product);
    }
    public String displayProductList() {
        return productList.stream().map(Product::toString).collect(Collectors.joining("\n"));
    }
}
