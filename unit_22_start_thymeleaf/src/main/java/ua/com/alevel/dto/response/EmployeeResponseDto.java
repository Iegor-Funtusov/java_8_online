package ua.com.alevel.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.entity.Salary;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class EmployeeResponseDto extends ResponseDto {

    private String firstName;
    private String lastName;
    private Integer age;
    private String salary;
    private List<DepartmentInfo> departmentInfoList;

    public EmployeeResponseDto(Employee employee) {
        setId(employee.getId());
        setFirstName(employee.getFirstName());
        setLastName(employee.getLastName());
        setAge(employee.getAge());
        Salary salary1 = employee.getSalary();
        if (salary1 != null) {
            setSalary(salary1.getEmployeeSalary().toString());
        } else {
            setSalary("00.00");
        }
        Set<Department> departments = employee.getDepartments();
        if (CollectionUtils.isNotEmpty(departments)) {
            List<DepartmentInfo> departmentInfos = departments
                    .stream()
                    .map(DepartmentInfo::new)
                    .toList();
            setDepartmentInfoList(departmentInfos);
        }
    }

    @Getter
    @Setter
    private static class DepartmentInfo {
        private Long departmentId;
        private String name;

        DepartmentInfo(Department department) {
            setDepartmentId(department.getId());
            setName(department.getName());
        }
    }
}
