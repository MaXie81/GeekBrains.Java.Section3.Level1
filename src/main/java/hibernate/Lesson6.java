package hibernate;

import hibernate.configuration.ContextConfig;
import hibernate.service.ProductDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lesson6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);

        ProductDao productDao = context.getBean("productDao", ProductDao.class);
    }
}
