package spring.classes;

import spring.beans.ShopCart;

public class Client {
    private ShopCart shopCart;

    public Client(ShopCart shopCart) {
        this.shopCart = shopCart;
    }

    public ShopCart getShopCart() {
        return shopCart;
    }
}
