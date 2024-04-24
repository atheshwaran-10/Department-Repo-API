package com.springexample.springexample.Service;

import com.springexample.springexample.Entity.Department;
import com.springexample.springexample.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return (List<Department>) departmentRepository.findAll();
    }



    public ResponseEntity<String> deleteDepartment(@PathVariable Long departmentId){
        departmentRepository.deleteById(departmentId);
        return ResponseEntity.ok("Departmetnt Deleted successfully");
    }

    public ResponseEntity<String> updateDepartment(@PathVariable Long departmentId, @RequestBody Department request){

        Optional<Department> c = departmentRepository.findById(departmentId);
        if(c.isPresent()) {
            Department dept=c.get();
            dept.setName(request.getName());
            dept.setEmail(request.getEmail());
            dept.setAge(request.getAge());
            departmentRepository.save(dept);
            return ResponseEntity.ok("Department updated successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
        }
    }


}
