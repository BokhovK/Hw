package pro.sky.model.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.exception.EmployeeNotFoundException;
import pro.sky.model.Employee;
import pro.sky.model.service.DepartmentService;
import pro.sky.model.service.EmployeeService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalary(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> findEmployeesByDepartment(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartment() {
        return employeeService.findAll().stream()
                .collect(groupingBy(Employee::getDepartmentId));
    }
}
