package ua.com.alevel;

import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.dao.impl.DepartmentDaoImpl;
import ua.com.alevel.dao.impl.EmployeeDaoImpl;
import ua.com.alevel.data.PaginationData;
import ua.com.alevel.dto.DepartmentStatistics;
import ua.com.alevel.entity.Employee;

import java.util.Collection;

public class TestJdbc {

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();
    private final DepartmentDao departmentDao = new DepartmentDaoImpl();

    public void test() {
//        createEmployee();
//        updateEmployee();
//        deleteEmployee();
//        findEmployee();
//        findAllEmployee();
//        attachEmployeeToDepartment();
//        findAllByDepartment();
        findDepartmentStatistics();
    }

    private void createEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("test");
        employee.setLastName("test");
        employee.setAge(10);
        employeeDao.create(employee);
    }

    private void updateEmployee() {
        Employee employee = new Employee();
        employee.setId(29L);
        employee.setFirstName("test");
        employee.setLastName("test");
        employee.setAge(20);
        employeeDao.update(employee);
    }

    private void deleteEmployee() {
        employeeDao.delete(30L);
    }

    private void findEmployee() {
        Employee employee = employeeDao.findById(29L).get();
        System.out.println("employee = " + employee);
    }

    private void findAllEmployee() {
        PaginationData data = new PaginationData();
        data.setPage(2);
        data.setSize(10);
        data.setSort("id");
        data.setOrderBy("desc");
        Collection<Employee> collection = employeeDao.findAll(data);
        for (Employee employee : collection) {
            System.out.println("employee = " + employee);
        }
    }

    private void attachEmployeeToDepartment() {
        departmentDao.attachEmployeeToDepartment(3L, 13L);
    }

    private void findAllByDepartment() {
        Collection<Employee> employees = employeeDao.findAllByDepartment(1L);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }

    private void findDepartmentStatistics() {
        Collection<DepartmentStatistics> collection = departmentDao.findDepartmentStatistics();
        for (DepartmentStatistics departmentStatistics : collection) {
            System.out.println("departmentStatistics = " + departmentStatistics);
        }
    }
}
