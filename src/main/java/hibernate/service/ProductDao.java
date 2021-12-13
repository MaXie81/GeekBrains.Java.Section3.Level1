package hibernate.service;

import hibernate.dto.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ProductDao implements IProductDao {
    private SessionService sessionService;
    private Session session;
    private Transaction transaction;

    public ProductDao(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostConstruct
    public void postConstruct() {
        this.session = sessionService.getSession();
    }

    @Override
    public Product findById(Long id) {
        transaction = session.beginTransaction();
        Product product = session.find(Product.class, id);
        transaction.commit();

        return product;
    }

    @Override
    public List<Product> findAll() {
        transaction = session.beginTransaction();
        List<Product> productList = session
                .createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
        transaction.commit();

        return productList;
    }

    @Override
    public void deleteById(Long id) {
        transaction = session.beginTransaction();
        Product product = session.find(Product.class, id);
        session.delete(product);
        transaction.commit();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        transaction = session.beginTransaction();
        if (product.getId() == null) {
            Long id = (Long) session.save(product);
            product = session.find(Product.class, id);
        } else {
            product = (Product) session.merge(product);
        }
        transaction.commit();

        return product;
    }
}
