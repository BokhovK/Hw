package pro.sky.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.model.Employee;
import pro.sky.model.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RequestMapping("/department")
@RestController
public class DepartmenController {
    private final DepartmentService departmentService;

    public DepartmenController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("max-Salary")
    public Employee findEmployeeWithMaxSalary(@RequestParam int departmentId){
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }
    @GetMapping("min-Salary")
    public Employee findEmployeeWithMinSalary(@RequestParam int departmentId){
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }
    @GetMapping(value = "all", params = {"departmentId"})
    public Collection<Employee> findEmployeesByDepartment(@RequestParam int departmentId){
        return departmentService.findEmployeesByDepartment(departmentId);
    }
    @GetMapping("all")
    public Map<Integer, List<Employee>> findEmployeesByDepartment(){
        return departmentService.findEmployeesByDepartment();
    }
}
