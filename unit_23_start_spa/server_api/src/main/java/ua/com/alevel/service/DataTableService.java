package ua.com.alevel.service;

import org.springframework.data.domain.Page;
import ua.com.alevel.dto.request.PageRequestDto;
import ua.com.alevel.entity.BaseEntity;

public interface DataTableService<E extends BaseEntity> {

    Page<E> findAll(PageRequestDto pageRequestDto);
}
