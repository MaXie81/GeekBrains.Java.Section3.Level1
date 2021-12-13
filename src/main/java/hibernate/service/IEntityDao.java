package hibernate.service;

import java.util.List;

public interface IEntityDao<T> {
    T findById(Long id);
    List<T> findAll();
    void deleteById(Long id);
    T saveOrUpdate(T entity);
}
