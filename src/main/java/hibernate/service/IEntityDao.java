package hibernate.service;

import hibernate.dto.Product;

import java.util.List;

public interface IEntityDao {
    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product saveOrUpdate(Product product);
}
