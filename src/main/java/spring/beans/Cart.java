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
    private List<Product> listOfProduct = new ArrayList<>();

    public List<Product> getListOfProduct() {return listOfProduct;}
    public void addProduct(Product product) {
        listOfProduct.add(product);}
    public void findAndRemoveProduct(String name, boolean isAll) {
        Product product = listOfProduct.stream().filter(p -> p.getName().equals(name)).findFirst().get();

        if (product == null) return;

        if (isAll)
            listOfProduct.removeIf(p -> p == product);
        else
            listOfProduct.remove(product);
    }
    public String displayProductList() {
        return listOfProduct.stream().map(Product::toString).collect(Collectors.joining("\n"));
    }
}
