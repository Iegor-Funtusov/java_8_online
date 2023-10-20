package ua.com.alevel.service;

import ua.com.alevel.entity.BaseEntity;

import java.util.Collection;

public interface CrudService<BE extends BaseEntity> {

    void create(BE be);
    void update(BE be);
    void delete(Long id);
    BE findOne(Long id);
    Collection<BE> findAll();
}
