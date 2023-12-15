package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.BaseEntity;

public interface CrudService<E extends BaseEntity> {
    void create(E entity);
    E findById(Long id);
}
