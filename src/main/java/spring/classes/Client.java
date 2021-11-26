package spring.classes;

import spring.beans.Cart;

public class Client {
    private Cart cart;

    public Client(Cart cart) {
        this.cart = cart;
    }

    public Cart getShopCart() {
        return cart;
    }
}
