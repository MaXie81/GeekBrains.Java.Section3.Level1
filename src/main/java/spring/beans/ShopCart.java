package spring.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import spring.classes.SpringContext;
import spring.classes.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class ShopCart {
    private List<Product> listOfProduct;

    public ShopCart() {
        this.listOfProduct = new ArrayList<>();
    }

    public String getListOfPruduct() {
        return listOfProduct.stream().map(Product::toString).collect(Collectors.joining("\n"));
    }
    public void putInProduct(long id) {
        Product product;
        product = SpringContext.getContext().getBean(ProductService.class).getProductById(id);
        listOfProduct.add(product);
    }
    public void putOutProduct(long id, boolean isAll) {
        Product product;
        product = listOfProduct.stream().filter(p -> p.getId() == id).findFirst().orElse(null);

        if (isAll)
            listOfProduct.removeIf(p -> p == product);
        else
            listOfProduct.remove(product);
    }
}
