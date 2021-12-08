package hibernate;

import hibernate.configuration.ContextConfig;
import hibernate.service.ProductDao;
import hibernate.dto.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lesson5 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);

        ProductDao productDao = context.getBean("productDao", ProductDao.class);

        System.out.println(productDao.saveOrUpdate(new Product("Хлеб", 25)));

        System.out.println(productDao.saveOrUpdate(new Product("Молоко", 50)));
        System.out.println(productDao.saveOrUpdate(new Product("Сосиски", 250)));

        System.out.println("метод findById: " + productDao.findById(3L));

        productDao.deleteById(3L);
        System.out.println(productDao.findById(3L));

        System.out.println(productDao.saveOrUpdate(new Product("Мясо", 500)));

        System.out.println(productDao.saveOrUpdate(new Product(4L, "Мясо", 700)));

        System.out.println("проверка что все данные после Update сохранились в БД: " + productDao.findById(4L));

        System.out.println("Итоговый список того, что содержится в таблице PRODUCT: " + productDao.findAll());

        context.close();
    }
}
