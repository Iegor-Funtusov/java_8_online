package ua.com.alevel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Entity
@Table(name = "salaries")
public class Salary extends BaseEntity {

    @Digits(integer = 6, fraction = 2)
    @Column(name = "employee_salary", nullable = false)
    private BigDecimal employeeSalary;
}
