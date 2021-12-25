package webshop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import webshop.model.Cart;
import webshop.model.Product;

import java.util.List;

@Service
@AllArgsConstructor
public class CartService {
    private Cart cart;

    public void addProduct(Product product) {
        List<Product> list = cart.getProductList();
        list.add(product);
        cart.setProductList(list);
    }
    public void deleteProduct(Long id) {
        List<Product> list = cart.getProductList();
        Product product = list.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if (product != null) list.remove(product);
        cart.setProductList(list);
    }
    public List<Product> getProductList() {
        return cart.getProductList();
    }
}
