package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.data.PaginationData;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.factory.JdbcFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {

    private final JdbcFactory jdbcFactory = JdbcFactory.getInstance();

    private static final String CREATE_EMPLOYEE = "insert into employees values (default, ?, ?, ?)";
    private static final String UPDATE_EMPLOYEE = "update employees set first_name = ?, last_name = ?, age = ? where id = ?";
    private static final String DELETE_EMPLOYEE = "delete from employees where id = ?";
    private static final String FIND_EMPLOYEE = "select * from employees where id = ";
    private static final String FIND_ALL_EMPLOYEE = "select * from employees order by ? limit ?, ?";
    private static final String FIND_ALL_EMPLOYEE_BY_DEPARTMENT = "select id, first_name, last_name, age from employees as e left join dep_emp as de on e.id = de.emp_id where de.dep_id = ?";

    @Override
    public void create(Employee entity) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(CREATE_EMPLOYEE)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setInt(3, entity.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Employee entity) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(UPDATE_EMPLOYEE)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setInt(3, entity.getAge());
            ps.setLong(4, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(DELETE_EMPLOYEE)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<Employee> findById(Long id) {
        try(ResultSet rs = jdbcFactory.getStatement().executeQuery(FIND_EMPLOYEE + id)) {
            rs.next();
            return Optional.of(generateEmployeeByResultSet(rs));
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Collection<Employee> findAll(PaginationData data) {
        StringBuilder order = new StringBuilder();
        order.append(data.getSort());
        order.append(" ");
        order.append(data.getOrderBy());
        int start = (data.getPage() - 1) * data.getSize();
        Collection<Employee> employees = new ArrayList<>();
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(FIND_ALL_EMPLOYEE)) {
            ps.setString(1, order.toString());
            ps.setInt(2, start);
            ps.setInt(3, data.getSize());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                employees.add(generateEmployeeByResultSet(rs));
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Collection<Employee> findAllByDepartment(Long depId) {
        Collection<Employee> employees = new ArrayList<>();
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(FIND_ALL_EMPLOYEE_BY_DEPARTMENT)) {
            ps.setLong(1, depId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                employees.add(generateEmployeeByResultSet(rs));
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Employee generateEmployeeByResultSet(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        Long id = rs.getLong("id");
        String fn = rs.getString("first_name");
        String ln = rs.getString("last_name");
        int age = rs.getInt("age");
        employee.setId(id);
        employee.setFirstName(fn);
        employee.setLastName(ln);
        employee.setAge(age);
        return employee;
    }
}
