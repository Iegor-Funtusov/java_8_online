package ua.com.alevel.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ua.com.alevel.dto.request.EmployeeRequestDto;
import ua.com.alevel.dto.response.EmployeeResponseDto;
import ua.com.alevel.dto.response.PageResponseDto;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.facade.EmployeeFacade;
import ua.com.alevel.service.EmployeeService;

import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeFacade employeeFacade;

    @GetMapping
    public String allEmployees(Model model, WebRequest request) {
        PageResponseDto<EmployeeResponseDto> page = employeeFacade.findAll(request);
        model.addAttribute("pageData", page);
        return "pages/employees/employee_all";
    }

    @PostMapping
    public ModelAndView searchEmployees(WebRequest request, ModelMap modelMap) {
        Map<String, String[]> map = request.getParameterMap();
        map.forEach(modelMap::addAttribute);
        return new ModelAndView("redirect:/employees", modelMap);
    }

    @GetMapping("/new")
    public String redirectToNewEmployee(Model model) {
        model.addAttribute("employee", new EmployeeRequestDto());
        return "pages/employees/employee_new";
    }

    @PostMapping("/new")
    public String newEmployee(@ModelAttribute EmployeeRequestDto employee) {
        employeeFacade.create(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        employeeFacade.delete(id);
        return "redirect:/employees";
    }

    @GetMapping("/update/{id}")
    public String redirectToUpdateEmployee(@PathVariable Long id, Model model) {
        EmployeeResponseDto employee = employeeFacade.findById(id);
        model.addAttribute("employee", employee);
        return "pages/employees/employee_update";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute EmployeeRequestDto employee) {
        employeeFacade.update(employee, id);
        return "redirect:/employees";
    }

    private static class PageData {

    }
}
