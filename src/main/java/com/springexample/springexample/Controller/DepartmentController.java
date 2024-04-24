package com.springexample.springexample.Controller;

import com.springexample.springexample.Entity.Department;
import com.springexample.springexample.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired

    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @DeleteMapping("/departments/{departmentId}")
    public ResponseEntity deleteDepartment(@PathVariable Long departmentId) {
        return departmentService.deleteDepartment(departmentId);
    }

    @PutMapping("/departments/{departmentId}")
    public ResponseEntity<String> updateDepartmentupdateDepartment(@PathVariable Long departmentId, @RequestBody Department request) {
        return departmentService.updateDepartment(departmentId, request);
    }
}
