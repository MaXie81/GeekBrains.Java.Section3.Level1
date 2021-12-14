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

        Product product = new Product("Молоко", 55);
        productDao.saveOrUpdate(product);

        System.out.println(productDao.findById(1L));
        System.out.println(productDao.findById(2L));

        context.close();
    }
}
