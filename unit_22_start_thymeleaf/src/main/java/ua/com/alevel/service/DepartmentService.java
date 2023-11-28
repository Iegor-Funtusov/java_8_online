package ua.com.alevel.service;

import ua.com.alevel.entity.Department;

import java.util.Collection;

public interface DepartmentService extends CrudService<Department> {

    Collection<Department> findAll();
}
