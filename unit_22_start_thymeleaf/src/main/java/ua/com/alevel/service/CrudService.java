package ua.com.alevel.service;

import ua.com.alevel.entity.BaseEntity;

public interface CrudService<E extends BaseEntity> {

    void create(E entity);
    void update(E entity);
    void delete(Long id);
    E findById(Long id);
}
