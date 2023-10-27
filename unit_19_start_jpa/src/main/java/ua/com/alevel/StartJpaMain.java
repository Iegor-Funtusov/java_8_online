package ua.com.alevel;

import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.dao.impl.EmployeeDaoImpl;
import ua.com.alevel.entity.Employee;

public class StartJpaMain {
    public static void main(String[] args) {
        System.out.println("Hello StartJpaMain!");

        EmployeeDao employeeDao = new EmployeeDaoImpl();

        Employee employee = new Employee();
        employee.setFirstName("qq");
        employee.setLastName("QQ");
        employee.setAge(25);
        employeeDao.create(employee);
    }
}
