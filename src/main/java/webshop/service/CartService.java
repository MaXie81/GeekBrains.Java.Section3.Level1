package webshop.service;

import org.springframework.stereotype.Service;
import webshop.model.Cart;
import webshop.model.Product;

import java.util.List;

@Service
public class CartService {
    private Cart cart;

    public CartService(Cart cart) {
        this.cart = cart;
    }

    public void addProduct(Product product) {
        List<Product> list = cart.getProductList();
        list.add(product);
        cart.setProductList(list);
    }
    public void deleteProduct(Long id) {
        List<Product> list = cart.getProductList();
        Product product = list.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if (product != null) list.remove(product);
    }
    public List<Product> getProductList() {
        return cart.getProductList();
    }
    public Cart getCart() {return cart;}
}
