package ua.com.alevel.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.facade.DepartmentFacade;

@Controller
@RequestMapping(path = "/departments")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentFacade departmentFacade;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("departments", departmentFacade.findAll());
        return "/pages/departments/department_all";
    }
}
