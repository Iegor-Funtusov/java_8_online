package ua.com.alevel.facade.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import ua.com.alevel.dto.request.DepartmentRequestDto;
import ua.com.alevel.dto.response.DepartmentResponseDto;
import ua.com.alevel.entity.Department;
import ua.com.alevel.facade.DepartmentFacade;
import ua.com.alevel.service.DepartmentService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class DepartmentFacadeImpl implements DepartmentFacade {

    private final DepartmentService departmentService;

    @Override
    public void create(DepartmentRequestDto departmentRequestDto) {
        Department department = new Department();
        department.setName(departmentRequestDto.getName());
        departmentService.create(department);
    }

    @Override
    public void update(DepartmentRequestDto departmentRequestDto, Long id) {
        Department department = departmentService.findById(id);
        department.setName(departmentRequestDto.getName());
        departmentService.update(department);
    }

    @Override
    public void delete(Long id) {
        departmentService.delete(id);
    }

    @Override
    public DepartmentResponseDto findById(Long id) {
        return new DepartmentResponseDto(departmentService.findById(id));
    }

    @Override
    public Collection<DepartmentResponseDto> findAll() {
        return departmentService.findAll()
                .stream()
                .map(DepartmentResponseDto::new)
                .toList();
    }
}
