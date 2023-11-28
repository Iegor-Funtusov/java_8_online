package ua.com.alevel.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;

import java.util.Set;

@Getter
@Setter
public class DepartmentResponseDto extends ResponseDto {

    private String name;
    private int countOfEmployees;

    public DepartmentResponseDto(Department department) {
        setId(department.getId());
        setName(department.getName());
        Set<Employee> employees = department.getEmployees();
        if (CollectionUtils.isNotEmpty(employees)) {
            setCountOfEmployees(employees.size());
        }
    }
}
