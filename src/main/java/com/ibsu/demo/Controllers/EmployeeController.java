package com.ibsu.demo.Controllers;

import com.ibsu.demo.Entities.Employee;
import com.ibsu.demo.Services.EmployeeService;
import com.ibsu.demo.Util.GeneralUtil;
import com.ibsu.demo.dto.AddEditEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public Employee addEmployee(@RequestBody AddEditEmployee addEditEmployee) throws Exception {
        GeneralUtil.checkRequiredProperties(addEditEmployee, Arrays.asList("firstName", "lastName", "hireDate", "salary", "departmentId"));
        return employeeService.addEmployee(addEditEmployee);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public Employee getAll(@PathVariable Long id) throws Exception {
        return employeeService.find(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT, produces = {"application/json"})
    @ResponseBody
    public Employee editEmployee(@RequestBody AddEditEmployee addEditEmployee) throws Exception {
        GeneralUtil.checkRequiredProperties(addEditEmployee, Arrays.asList("employeeId", "firstName", "lastName",  "departmentId"));
        return employeeService.editEmployee(addEditEmployee);
    }
}
