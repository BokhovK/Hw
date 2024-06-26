package pro.sky.employees.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employees.Service.DepartmentService;
import pro.sky.employees.model.Employee;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/{id}/employees")
    public List<Employee> findEmployeesFromDepartment(@PathVariable("id") int department){
return departmentService.findEmployeesFromDepartment(department);
    }
    @GetMapping("/{id}/salary/sum")
    public List<Employee> calculateSumSalariesOfEmployeesFromDepartment(@PathVariable("id") int department){
        return departmentService.calculateSumSalariesOfEmployeesFromDepartment(department);
    }
    @GetMapping("/{id}/salary/max")
    public List<Employee> findMaxSalaryFromDepartment(@PathVariable("id") int department){
        return departmentService.findMaxSalaryFromDepartment(department);
    }
    @GetMapping("/{id}/salary/min")
    public List<Employee> findMinSalaryFromDepartment(@PathVariable("id") int department){
        return departmentService.findMinSalaryFromDepartment(department);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> findEmployeesGroupedByDepartment(@PathVariable("id") int department){
        return departmentService.findEmployeesGroupedByDepartment(department);
}
