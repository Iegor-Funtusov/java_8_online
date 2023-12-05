package ua.com.alevel.controller;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import ua.com.alevel.dto.request.EmployeeRequestDto;
import ua.com.alevel.dto.response.EmployeeResponseDto;
import ua.com.alevel.dto.response.PageResponseDto;
import ua.com.alevel.facade.EmployeeFacade;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeFacade employeeFacade;

    @GetMapping
    public PageResponseDto<EmployeeResponseDto> findAll(WebRequest request) {
        Map<String, Object> map = new HashMap<>();
        String departmentIdParameter = request.getParameter("departmentId");
        if (StringUtils.isNotBlank(departmentIdParameter)) {
            Long departmentId = Long.parseLong(departmentIdParameter);
            map.put("departmentId", departmentId);
        }
        return employeeFacade.findAll(request, map);
    }

    @GetMapping("/{id}")
    public EmployeeResponseDto findById(@PathVariable Long id) {
        return employeeFacade.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EmployeeRequestDto employeeRequestDto) {
        employeeFacade.create(employeeRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody EmployeeRequestDto employeeRequestDto) {
        employeeFacade.update(employeeRequestDto, id);
//        return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        employeeFacade.delete(id);
        return ResponseEntity.ok().build();
    }
}
