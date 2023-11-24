package ua.com.alevel.service;

import org.springframework.data.domain.Page;
import ua.com.alevel.dto.request.PageRequestDto;
import ua.com.alevel.entity.BaseEntity;

import java.util.Collection;

public interface CrudService<E extends BaseEntity> {

    void create(E entity);
    void update(E entity);
    void delete(Long id);
    E findById(Long id);
    Page<E> findAll(PageRequestDto pageRequestDto);
}
