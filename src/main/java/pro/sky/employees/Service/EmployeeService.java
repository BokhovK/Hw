package pro.sky.employees.Service;

import org.springframework.stereotype.Service;
import pro.sky.employees.EmployeeAlreadyExistsException;
import pro.sky.employees.Exception.EmployeeNotFoundException;
import pro.sky.employees.Exception.StorageIsFullException;
import pro.sky.employees.model.Employee;

import java.util.*;

@Service
public class EmployeeService {
    private final int max = 5;
    private final Map<String, Employee> employees = new HashMap<>();
    private int salary;
    private final ValidationService validationService;
    public Employee add(String name, String surname, int salary, int department){
    if(employees.size()>=max){
        throw new StorageIsFullException();
    }
    String key = buildkey(name, surname);
    if (employees.containsKey(key)){
        throw new EmployeeAlreadyExistsException();
    }
    Employee employee = new Employee(
            validationService.validate(name),
            validationService.validate(surname),
            salary, department);

    employees.put(key, employee);
    return employee;
    }
    public Employee find(String name, String surname) {
        String key = buildkey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }
    public Employee remove(String name, String surname) {
        String key = buildkey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }
    public Collection<Employee> employees(){
        return Collections.unmodifiableCollection(employees.values());
    }
    private String buildkey(String name, String surname){
        return name+surname;
    }
public Collection<Employee> findAll(){
        return new ArrayList<>(employees.values());
}


}
