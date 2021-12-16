package webshop.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import webshop.dto.Product;

import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryOld {
    @PersistenceContext
    Session session;

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return session.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(session.get(Product.class, id));
    }

    @Transactional
    public void save(Product product) {
        session.save(product);
    }

    @Transactional
    public void deleteById(Long id) {
        session.createQuery("delete from Product where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
