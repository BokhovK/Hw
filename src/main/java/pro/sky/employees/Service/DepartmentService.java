package pro.sky.employees.Service;

import org.springframework.stereotype.Service;
import pro.sky.employees.Exception.EmployeeNotFoundException;
import pro.sky.employees.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> findEmployeesFromDepartment(int department) {
        return  employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment()== department)
                .toList();
    }

    public int calculateSumSalariesOfEmployeesFromDepartment(int department) {
          return  employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment()== department)
                .map(Employee::getSalary)
                .reduce(0, Integer::sum);;
    }

    public int findMaxSalaryFromDepartment(int department) {
         return  employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment()== department)
                .max((Comparator.comparingInt(Employee::getSalary))
                .map(Employee::getSalary)
                        .orElseThrow(EmployeeNotFoundException::new);
    }

    public int findMinSalaryFromDepartment(int department) {
        return employeeService.findAll().stream()
        .filter(employee -> employee.getDepartment()== department)
                .min((Comparator.comparingInt(Employee::getSalary))
                        .map(Employee::getSalary)
                        .orElseThrow(EmployeeNotFoundException::new);
    }

    public Map<Integer, List<Employee>> findEmployeesGroupedByDepartment(int department) {
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
