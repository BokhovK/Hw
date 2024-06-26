package pro.sky.employees.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.employees.Exception.EmployeeNotFoundException;
import pro.sky.employees.Service.DepartmentService;
import pro.sky.employees.Service.EmployeeService;
import pro.sky.employees.model.Employee;

import javax.naming.ldap.LdapReferralException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentserviceTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentService departmentService;
    private final List<Employee> employees = List.of(
            new Employee("Иван", "Иванов", 50_000, 2),
            new Employee("Иван", "Иванченко", 60_000, 1),
            new Employee("Андрей", "Иванов", 70_000, 1),
            new Employee("Александр", "Иванов", 40_000, 2),
            new Employee("Иван", "Иванко", 60_000, 2)
    );

    @BeforeEach
    public void beforeEach() {
        when(employeeService.findAll()).thenReturn(employees);
    }

    @Test
    public void findEmployeesFromDepartmentTest() {
        assertThat(departmentService.findEmployeesFromDepartment(1))
                .containsExactlyInAnyOrder(
                        new Employee("Иван", "Иванов", 50_000, 2),
                        new Employee("Иван", "Иванченко", 60_000, 1)
                        );
    }

    @Test
    public void calculateSumSalariesOfEmployeesFromDepartmentTest() {
        assertThat(departmentService.calculateSumSalariesOfEmployeesFromDepartment(2))
                .isEqualTo(150_000);
    }

    @Test
    public void calculateSumSalariesOfEmployeesFromDepartmentNegativeTest() {
        assertThat(departmentService.calculateSumSalariesOfEmployeesFromDepartment(2))
                .isEqualTo(0);
    }

    @Test
    public void findMaxSalaryFromDepartmentService() {
        assertThat(departmentService.findMaxSalaryFromDepartment(2))
                .isEqualTo(70_000);
    }

    @Test
    public void findMaxSalaryFromDepartmentNegativeService() {
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> departmentService.findMaxSalaryFromDepartment(4));
    }

    @Test
    public void findMinSalaryFromDepartmentService() {
        assertThat(departmentService.findMinSalaryFromDepartment(2))
                .isEqualTo(40_000);
    }

    @Test
    public void findMinSalaryFromDepartmentNegativeService() {
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> departmentService.findMinSalaryFromDepartment(4));
    }

    @Test
    public void findEmployeesGroupedByDepartmentTest() {
        assertThat(departmentService.findEmployeesGroupedByDepartment(0))
                .containsExactlyInAnyOrderEntriesOf(
                        Map.of(
                                1, List.of(new Employee("Иван", "Иванов", 50_000, 2), new Employee("Иван", "Иванченко", 60_000, 1)),
                                2, List.of(new Employee("Андрей", "Иванов", 70_000, 1), new Employee("Александр", "Иванов", 40_000, 2)),
                                3, List.of(new Employee("Иван", "Иванко", 60_000, 2))
                        )
                );

    }
}
