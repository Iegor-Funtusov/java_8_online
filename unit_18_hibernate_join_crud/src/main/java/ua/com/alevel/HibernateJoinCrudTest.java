package ua.com.alevel;

import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.dao.SalaryDao;
import ua.com.alevel.dao.impl.DepartmentDaoImpl;
import ua.com.alevel.dao.impl.EmployeeDaoImpl;
import ua.com.alevel.dao.impl.SalaryDaoImpl;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.entity.Salary;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

public class HibernateJoinCrudTest {

    private final DepartmentDao departmentDao = new DepartmentDaoImpl();
    private final EmployeeDao employeeDao = new EmployeeDaoImpl();
    private final SalaryDao salaryDao = new SalaryDaoImpl();

    public void test() {
//        createDepartment();
//        createEmployee();
//        createSalary();
//        joinSalaryAndEmployee();
//        createEmployeeAndSalary();
//        createDepartmentAndEmployeeAndSalary();
//        observeDepartment();
//        detach();
        remove();
    }

    private void createDepartment() {
        Department department = new Department();
        department.setName("JAVA");
        departmentDao.create(department);
    }

    private void createEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("qq");
        employee.setLastName("QQ");
        employee.setAge(25);
        employeeDao.create(employee);
    }

    private void createSalary() {
        Salary salary = new Salary();
        salary.setEmployeeSalary(new BigDecimal("10000.00"));
        salaryDao.create(salary);
    }

    private void joinSalaryAndEmployee() {
        Employee employee = employeeDao.findById(1L).get();
        Salary salary = salaryDao.findById(1L).get();
        employee.setSalary(salary);
        employeeDao.update(employee);
    }

    private void createEmployeeAndSalary() {
        Employee employee = new Employee();
        employee.setFirstName("ww");
        employee.setLastName("WW");
        employee.setAge(26);
        Salary salary = new Salary();
        salary.setEmployeeSalary(new BigDecimal("11000.00"));
        employee.setSalary(salary);
        employeeDao.create(employee);
    }

    private void createDepartmentAndEmployeeAndSalary() {
        Department department = new Department();
        department.setName("JS");

        Employee employee = new Employee();
        employee.setFirstName("ee");
        employee.setLastName("EE");
        employee.setAge(27);

        Salary salary = new Salary();
        salary.setEmployeeSalary(new BigDecimal("12000.00"));
        employee.setSalary(salary);
        employeeDao.create(employee);

        Set<Employee> employees = department.getEmployees();
        employees.add(employee);
        departmentDao.create(department);
    }

    private void observeDepartment() {
        Department department = departmentDao.findById(5L).get();
        Set<Employee> employees = department.getEmployees();
        System.out.println("employees = " + employees);
        System.out.println("employees size = " + employees.size());
        if (CollectionUtils.isNotEmpty(employees)) {
            for (Employee employee : employees) {
                Set<Department> departments = employee.getDepartments();
                if (CollectionUtils.isNotEmpty(departments)) {
                    for (Department department1 : departments) {
                        Set<Employee> employeeSet = department1.getEmployees();
                        if (CollectionUtils.isNotEmpty(employeeSet)) {}
                    }
                }
//                Salary salary = employee.getSalary();
//                if (salary != null) {
//                    System.out.println("salary = " + salary);
//                }
            }
        }
    }

    private void detach() {
        Department department = departmentDao.findById(5L).get();
        Set<Employee> employees = department.getEmployees();
        if (CollectionUtils.isNotEmpty(employees)) {
            employees.removeIf(employee -> employee.getId().equals(5L));
            departmentDao.update(department);
        }
    }

    private void remove() {
//        Employee employee = employeeDao.findById(3L).get();
        employeeDao.delete(5L);
    }
}
