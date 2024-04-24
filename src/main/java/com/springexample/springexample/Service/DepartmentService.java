package com.springexample.springexample.Service;

import com.springexample.springexample.Entity.Department;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface DepartmentService {
    public  Department saveDepartment(Department department);
    public List<Department> getDepartments();
    public ResponseEntity deleteDepartment(Long id);
    public ResponseEntity<String> updateDepartment(Long id,Department department);
}
