package hibernate.service;

import hibernate.dto.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDao implements IEntityDao {
    private SessionService sessionService;
    private Session session;
    private Transaction transaction;

    public ProductDao(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public Product findById(Long id) {
        session = sessionService.getSession();
        transaction = session.beginTransaction();
        Product product = session.find(Product.class, id);
        transaction.commit();
        session.close();

        return product;
    }

    @Override
    public List<Product> findAll() {
        session = sessionService.getSession();
        transaction = session.beginTransaction();
        List<Product> productList = session
                .createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
        transaction.commit();
        session.close();

        return productList;
    }

    @Override
    public void deleteById(Long id) {
        session = sessionService.getSession();
        transaction = session.beginTransaction();
        Product product = session.find(Product.class, id);
        session.delete(product);
        transaction.commit();
        session.close();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        session = sessionService.getSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(product);
        transaction.commit();
        session.close();

        return product;
    }
}
