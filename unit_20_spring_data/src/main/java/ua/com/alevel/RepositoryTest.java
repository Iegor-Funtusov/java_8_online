package ua.com.alevel;

import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.entity.Salary;
import ua.com.alevel.repository.DepartmentRepository;
import ua.com.alevel.repository.EmployeeRepository;
import ua.com.alevel.repository.SalaryRepository;

import java.math.BigDecimal;
import java.util.Collection;

@Service
@AllArgsConstructor
public class RepositoryTest {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final SalaryRepository salaryRepository;

    public void test() {
//        createDepartment();
//        createEmployee();
//        createSalary();
//        joinSalaryAndEmployee();
        getDepartments();
    }

    private void createDepartment() {
        System.out.println("RepositoryTest.createDepartment");
        Department department = new Department();
        department.setName("SCALA");
        departmentRepository.save(department);
    }

    private void createEmployee() {
        System.out.println("RepositoryTest.createEmployee");
        Employee employee = new Employee();
        employee.setFirstName("qq");
        employee.setLastName("QQ");
        employee.setAge(25);
        employeeRepository.save(employee);
    }

    private void createSalary() {
        Salary salary = new Salary();
        salary.setEmployeeSalary(new BigDecimal("10000.00"));
        salaryRepository.save(salary);
    }

    private void joinSalaryAndEmployee() {
        Employee employee = employeeRepository.findById(1L).get();
        Salary salary = salaryRepository.findById(1L).get();
        employee.setSalary(salary);
        employeeRepository.save(employee);
    }

    private void getDepartments() {
        Collection<Department> departments = departmentRepository.findAllByNameContaining("A");
        if (CollectionUtils.isNotEmpty(departments)) {
            departments.forEach(System.out::println);
        }
    }
}
