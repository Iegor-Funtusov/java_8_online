package ua.com.alevel.dao.impl;
import jakarta.persistence.Query;
import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.entity.Department;

import java.util.Collection;
import java.util.Optional;

public class DepartmentDaoImpl implements DepartmentDao {

    @Override
    public void create(Department entity) {

    }

    @Override
    public void update(Department entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Department> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Department> findAll() {
        return null;
    }
}
