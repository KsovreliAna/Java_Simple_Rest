package com.ibsu.demo.Services;

import com.ibsu.demo.Entities.Department;
import com.ibsu.demo.Entities.Employee;
import com.ibsu.demo.Repositories.DepartmentRepository;
import com.ibsu.demo.Repositories.EmployeeRepository;
import com.ibsu.demo.Util.GeneralUtil;
import com.ibsu.demo.dto.AddEditEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Employee addEmployee(AddEditEmployee addEditEmployee) throws Exception {
        Employee employee = new Employee();
        GeneralUtil.getCopyOf(addEditEmployee, employee);
        Department department = departmentRepository.findById(addEditEmployee.getDepartmentId()).orElseThrow(() -> new Exception("DEPARTMENT_NOT_FOUND"));
        employee.setEmployeeId(null);
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee find(Long id) throws Exception {
        return employeeRepository.findById(id).orElseThrow(() -> new Exception("EMPLOYEE_NOT_FOUND"));
    }
    @Transactional
    public Employee editEmployee(AddEditEmployee addEditEmployee) throws Exception {
        Employee employee = this.find(addEditEmployee.getEmployeeId());
        GeneralUtil.getCopyOf(addEditEmployee, employee);
        Department department = departmentRepository.findById(addEditEmployee.getDepartmentId()).orElseThrow(() -> new Exception("DEPARTMENT_NOT_FOUND"));
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }
}
