package ua.com.alevel.service;

import ua.com.alevel.entity.BaseEntity;

public interface CrudService<BE extends BaseEntity> {

    void create(BE be);
    void update(BE be);
    void delete(String id);
    BE findOne(String id);
    BE[] findAll();
}
