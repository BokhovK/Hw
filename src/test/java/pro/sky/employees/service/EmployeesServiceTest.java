package pro.sky.employees.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.employees.Service.EmployeeService;
import pro.sky.employees.Service.ValidationService;
import pro.sky.employees.model.Employee;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeesServiceTest {
    private final EmployeeService employeeService = new EmployeeService(new ValidationService());
    private final List<Employee> employees = List.of(
            new Employee("Иван", "Петров", 50_000, 1),
            new Employee("Пётр", "Иванов", 60_000, 1),
            new Employee("Иван", "Сидоров", 40_000, 2)
    );
    @BeforeEach
    public void beforeEach(){
        employees.forEach(employee -> employeeService.add(employee.getName(), employee.getSurname(), employee.getSalary(), employee.getDepartment()));
        }
    @AfterEach
    public void afterEach(){
    employeeService.findAll.forEach(employee -> employeeService.remove(employee.getName(), employee.getSurname()));
    }
    @Test
public void addTest(){
    Employee expected = new Employee("Иван", "Андреев", 90_000, 2);
   Employee actual = employeeService.add("Иван", "Андреев", 90_000, 2);
   assertThat(actual).isEqualTo(expected);
        assertThat(actual).isEqualTo(employeeService.find("Иван","Андреев"));
        assertThat(actual).isIn(employeeService.findAll());
    }
    @Test
    public void whenEmployeeServiceIsFullThenExceptionIsThrown(){
        Employee expected = new Employee("Иван", "Андреев",90_000,2);
        Employee actual = employeeService.add("Иван", "Андреев", 90_000, 2);
        assertThat(actual).isEqualTo(expected);
        assertThat(actual).isEqualTo(employeeService.find("Иван","Андреев"));
        assertThat(actual).isIn(employeeService.findAll());
    }


}
