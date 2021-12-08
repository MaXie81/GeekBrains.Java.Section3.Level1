import dao.ProductDao;
import dto.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Lesson5 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        ProductDao productDao = new ProductDao(session);

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

        session.close();
        sessionFactory.close();
    }
}
