package ua.com.alevel.dao;

import ua.com.alevel.dto.DepartmentStatistics;
import ua.com.alevel.entity.Department;

import java.util.Collection;

public interface DepartmentDao extends CrudDao<Department> {

    void attachEmployeeToDepartment(Long depId, Long empId);
    Collection<DepartmentStatistics> findDepartmentStatistics();
}
