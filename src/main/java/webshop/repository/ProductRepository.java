package webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import webshop.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select max(id) from Product")
    Long getLastId();
}
