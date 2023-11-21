package ua.com.alevel.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.repository.EmployeeRepository;
import ua.com.alevel.service.EmployeeService;

import java.util.Collection;

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
    public Collection<Employee> findAll() {
        return employeeRepository.findAll(Sort.by("id").descending());
    }
}
