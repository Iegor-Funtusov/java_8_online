package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.data.PaginationData;
import ua.com.alevel.dto.DepartmentStatistics;
import ua.com.alevel.entity.Department;
import ua.com.alevel.factory.JdbcFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DepartmentDaoImpl implements DepartmentDao {

    private final JdbcFactory jdbcFactory = JdbcFactory.getInstance();

    private static final String ATTACH_EMPLOYEE_TO_DEPARTMENT = "insert into dep_emp values (?, ?)";
    private static final String FIND_DEPARTMENT_STATISTICS = "select d.id, d.name, count(d.id) as count_of_employees from departments as d left join dep_emp as de on d.id = de.dep_id group by d.id";

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
    public Collection<Department> findAll(PaginationData data) {
        return null;
    }

    @Override
    public void attachEmployeeToDepartment(Long depId, Long empId) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(ATTACH_EMPLOYEE_TO_DEPARTMENT)) {
            ps.setLong(1, depId);
            ps.setLong(2, empId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Collection<DepartmentStatistics> findDepartmentStatistics() {
        try(ResultSet rs = jdbcFactory.getStatement().executeQuery(FIND_DEPARTMENT_STATISTICS)) {
            Collection<DepartmentStatistics> collection = new ArrayList<>();
            while (rs.next()) {
                collection.add(generateDepartmentStatisticsByResultSet(rs));
            }
            return collection;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return null;
    }

    private DepartmentStatistics generateDepartmentStatisticsByResultSet(ResultSet rs) throws SQLException {
        DepartmentStatistics departmentStatistics = new DepartmentStatistics();
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        Long countOfEmployees = rs.getLong("count_of_employees");
        departmentStatistics.setDepartmentId(id);
        departmentStatistics.setName(name);
        departmentStatistics.setCountOfEmployees(countOfEmployees);
        return departmentStatistics;
    }
}
