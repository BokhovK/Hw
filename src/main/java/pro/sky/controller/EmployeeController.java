package pro.sky.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.model.Employee;
import pro.sky.model.service.EmployeeService;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
   @GetMapping("/add")
    public Employee add(@RequestParam String firstname,
                        @RequestParam String lastName){
       return employeeService.add(firstname, lastName);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstname,
                        @RequestParam String lastName){
return employeeService.remove(firstname, lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstname,
                        @RequestParam String lastName){
        return employeeService.find(firstname, lastName);
    }
    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
}
