package spring.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.beans.Cart;
import spring.beans.ShopService;
import spring.classes.Client;

public class Lesson2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);

        ShopService shop = context.getBean(ShopService.class);
        
        Client client1 = new Client(context.getBean(Cart.class));
        Client client2 = new Client(context.getBean(Cart.class));

        client1.getShopCart().addProduct(shop.getProductByName("Хлеб"));
        client1.getShopCart().addProduct(shop.getProductByName("Хлеб"));
        client1.getShopCart().addProduct(shop.getProductByName("Картофель"));
        client1.getShopCart().addProduct(shop.getProductByName("Мясо"));
        client1.getShopCart().findAndRemoveProduct("Хлеб", true);

        client2.getShopCart().addProduct(shop.getProductByName("Молоко"));
        client2.getShopCart().addProduct(shop.getProductByName("Мясо"));
        client2.getShopCart().addProduct(shop.getProductByName("Мясо"));
        client2.getShopCart().findAndRemoveProduct("Мясо", false);

        System.out.println("корзина Клиента 1:\n" + client1.getShopCart().lookProductList());
        System.out.println("корзина Клиента 2:\n" + client2.getShopCart().lookProductList());

        context.close();
    }
}
