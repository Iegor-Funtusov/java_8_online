package ua.com.alevel.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.com.alevel.dto.request.DepartmentRequestDto;
import ua.com.alevel.dto.response.DepartmentResponseDto;
import ua.com.alevel.facade.DepartmentFacade;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentFacade departmentFacade;

    @GetMapping
    public Collection<DepartmentResponseDto> findAll() {
        return departmentFacade.findAll();
    }

    @GetMapping("/{id}")
    public DepartmentResponseDto findById(@PathVariable Long id) {
        return departmentFacade.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody DepartmentRequestDto dto) {
        departmentFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody DepartmentRequestDto dto) {
        departmentFacade.update(dto, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        departmentFacade.delete(id);
        return ResponseEntity.ok().build();
    }
}
