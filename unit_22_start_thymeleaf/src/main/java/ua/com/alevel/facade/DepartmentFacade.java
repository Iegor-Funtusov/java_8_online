package ua.com.alevel.facade;

import ua.com.alevel.dto.request.DepartmentRequestDto;
import ua.com.alevel.dto.response.DepartmentResponseDto;

import java.util.Collection;

public interface DepartmentFacade extends CrudFacade<DepartmentRequestDto, DepartmentResponseDto> {

    Collection<DepartmentResponseDto> findAll();
}
