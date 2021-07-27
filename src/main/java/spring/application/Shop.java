package spring.application;

import spring.beans.ShopCart;
import spring.classes.Client;
import spring.classes.SpringContext;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static void main(String[] args) {
        List<Client> listOfClient = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            listOfClient.add(new Client(SpringContext.getContext().getBean(ShopCart.class)));
        }

        listOfClient.get(1).getShopCart().putInProduct(1);
        listOfClient.get(1).getShopCart().putInProduct(1);
        listOfClient.get(1).getShopCart().putInProduct(3);
        listOfClient.get(1).getShopCart().putOutProduct(1, true);

        listOfClient.get(2).getShopCart().putInProduct(2);
        listOfClient.get(2).getShopCart().putInProduct(3);
        listOfClient.get(2).getShopCart().putInProduct(3);
        listOfClient.get(2).getShopCart().putOutProduct(3, false);

        System.out.println("корзина Клиента 1:\n" + listOfClient.get(1).getShopCart().getListOfPruduct());
        System.out.println("корзина Клиента 2:\n" + listOfClient.get(2).getShopCart().getListOfPruduct());
    }
}
