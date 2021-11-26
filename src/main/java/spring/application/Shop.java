package spring.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.beans.Cart;
import spring.beans.ProductService;
import spring.classes.Client;

public class Shop {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);

        Client client1 = new Client(context.getBean(Cart.class));
        Client client2 = new Client(context.getBean(Cart.class));

        client1.getShopCart().addProduct(context.getBean(ProductService.class).getProductByName("Хлеб"));
        client1.getShopCart().addProduct(context.getBean(ProductService.class).getProductByName("Хлеб"));
        client1.getShopCart().addProduct(context.getBean(ProductService.class).getProductByName("Мясо"));
        client1.getShopCart().removeProduct(client1.getShopCart().getProductByName("Хлеб"), true);

        client2.getShopCart().addProduct(context.getBean(ProductService.class).getProductByName("Молоко"));
        client2.getShopCart().addProduct(context.getBean(ProductService.class).getProductByName("Мясо"));
        client2.getShopCart().addProduct(context.getBean(ProductService.class).getProductByName("Мясо"));
        client2.getShopCart().removeProduct(client2.getShopCart().getProductByName("Мясо"), false);

        System.out.println("корзина Клиента 1:\n" + client1.getShopCart().displayProductList());
        System.out.println("корзина Клиента 2:\n" + client2.getShopCart().displayProductList());

        context.close();
    }
}
