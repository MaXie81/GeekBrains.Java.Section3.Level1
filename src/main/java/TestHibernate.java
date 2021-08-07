import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TestHibernate {
    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        EntityManager entityManager = factory.createEntityManager();

        Product productFromDB;
        Product product = new Product(1, "Хлеб", 31.15f);
//        Product product = new Product(2, "Молоко", 54.00f);

//        entityManager.getTransaction().begin();
//        entityManager.persist(product);
//        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        productFromDB = entityManager.find(Product.class, 1L);
        entityManager.getTransaction().commit();

        System.out.println(productFromDB);

        productFromDB.setCost(34.00f);

        entityManager.getTransaction().begin();
        entityManager.merge(productFromDB);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        productFromDB = entityManager.find(Product.class, 1L);
        entityManager.getTransaction().commit();

        System.out.println(productFromDB);
    }
}
