package pro.sky.model.service;

import org.springframework.stereotype.Service;
import pro.sky.exception.EmployeeAlreadyAddedException;
import pro.sky.exception.EmployeeNotFoundException;
import pro.sky.exception.EmployeeStorageIsFullException;
import pro.sky.model.Employee;


import java.util.*;


@Service
public class EmployeeService {
    private final int maxEmployee = 10;
    private final Map<String, Employee> employees = new HashMap<>();
    public Employee add(String firstname, String lastName){
     String key = buildKey(firstname, lastName);
      if(employees.containsKey(key)){
          throw new EmployeeAlreadyAddedException();
      }
      if(employees.size()>=maxEmployee){
          throw new EmployeeStorageIsFullException();
      }
        Employee employee = new Employee(firstname, lastName);
      employees.put(key, employee);
      return employee;
    }
    public Employee remove(String firstname, String lastName){
        String key = buildKey(firstname, lastName);
        if(!employees.containsKey(key)){
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }
    public Employee find(String firstname, String lastName){
        String key = buildKey(firstname, lastName);
        if(!employees.containsKey(key)){
            throw new EmployeeNotFoundException();
        }

        return employees.get(key);
    }
    public String buildKey(String name, String surname){
        return name + surname;
    }
    public List<Employee> findAll(){
        return List.copyOf(new ArrayList<>(employees.values()));
    }

}
