package ua.com.alevel.dao;

import ua.com.alevel.entity.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeDao {

    Collection<Employee> findAllByJPQL(int page, int size, String sort, String order, Map<String, Object> parameters);
    Collection<Employee> findAllByCriteria(int page, int size, String sort, String order, Map<String, Object> parameters);
}
