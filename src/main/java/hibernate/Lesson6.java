package hibernate;

import hibernate.configuration.ContextConfig;
import hibernate.dto.Client;
import hibernate.dto.Product;
import hibernate.service.ClientDao;
import hibernate.service.ProductDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lesson6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);

        ProductDao productDao = context.getBean("productDao", ProductDao.class);
        ClientDao clientDao = context.getBean("clientDao", ClientDao.class);

        Product product;
        Client client;

        product = productDao.saveOrUpdate(new Product("Новый продукт", 105));
        System.out.println("Добавлен новый продукт: " + product);

        client = clientDao.saveOrUpdate(new Client("Вася"));
        System.out.println("Новый клиент: " + client);

        client.addProduct(productDao.findById(6L));
        client.addProduct(productDao.findById(1L));
        clientDao.saveOrUpdate(client);

        System.out.println("Покупки нового клиента: " + clientDao.findById(client.getId()));

        client = clientDao.findById(1L);
        System.out.println("Старый клиент: " + client);

        client.addProduct(productDao.findById(6L));
        client.addProduct(productDao.findById(3L));
        clientDao.saveOrUpdate(client);

        System.out.println("Покупки старого клиента: " + clientDao.findById(client.getId()));

        System.out.println("Какие клиенты купили продукты:");
        System.out.println(productDao.findById(1L));
        System.out.println(productDao.findById(3L));
        System.out.println(productDao.findById(6L));

        context.close();
    }
}
