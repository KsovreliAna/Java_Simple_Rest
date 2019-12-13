package com.ibsu.demo.Controllers;

import com.ibsu.demo.Entities.Department;
import com.ibsu.demo.Services.DepartmentService;
import com.ibsu.demo.dto.SearchDepByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public Department getOne(@PathVariable Long id) throws Exception {
        return departmentService.getDepartmentById(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public List<Department> search(@RequestBody SearchDepByName searchDepByName) {
        return departmentService.getByName(searchDepByName.getName());
    }
}
