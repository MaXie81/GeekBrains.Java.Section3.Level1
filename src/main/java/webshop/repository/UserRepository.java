package webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webshop.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
}
