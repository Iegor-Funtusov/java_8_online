package ua.com.alevel.dao;

import ua.com.alevel.entity.Employee;

import java.util.Collection;

public interface EmployeeDao extends CrudDao<Employee> {

    Collection<Employee> findAllByDepartment(Long depId);
}
