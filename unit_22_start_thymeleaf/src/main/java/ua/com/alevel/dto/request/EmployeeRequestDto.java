package ua.com.alevel.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDto extends RequestDto {

    private String firstName;
    private String lastName;
    private Integer age;
}
