package ua.com.alevel.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.service.EmployeeService;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public String allEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "pages/employees/employee_all";
    }

    @GetMapping("/new")
    public String redirectToNewEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "pages/employees/employee_new";
    }

    @PostMapping("/new")
    public String newEmployee(@ModelAttribute Employee employee) {
        employeeService.create(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

    @GetMapping("/update/{id}")
    public String redirectToUpdateEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "pages/employees/employee_update";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeService.update(employee);
        return "redirect:/employees";
    }
}
