package ua.com.alevel.service.impl;

import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.MapUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.dto.request.PageRequestDto;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.repository.EmployeeRepository;
import ua.com.alevel.service.EmployeeService;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public void create(Employee entity) {
        employeeRepository.save(entity);
    }

    @Override
    public void update(Employee entity) {
        employeeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Page<Employee> findAll(PageRequestDto pageRequestDto) {
        Specification<Employee> specification = null;
        Map<String, Object> map = pageRequestDto.getParamMap();
        if (MapUtils.isNotEmpty(map)) {
            Long departmentId = (Long) map.get("departmentId");
            specification = (root, query, cb) -> {
                Join<Department, Employee> departmentsEmployee = root.join("departments");
                return cb.equal(departmentsEmployee.get("id"), departmentId);
            };
        }

        PageRequest pageRequest;
        if (pageRequestDto.getSortType().equals("desc")) {
            pageRequest = PageRequest.of(
                    pageRequestDto.getPage() - 1,
                    pageRequestDto.getSize(),
                    Sort.by(pageRequestDto.getSortBy()).descending());
        } else {
            pageRequest = PageRequest.of(
                    pageRequestDto.getPage() - 1,
                    pageRequestDto.getSize(),
                    Sort.by(pageRequestDto.getSortBy()).ascending());
        }
        if (specification != null) {
            return employeeRepository.findAll(specification, pageRequest);
        }
        return employeeRepository.findAll(pageRequest);
    }
}
