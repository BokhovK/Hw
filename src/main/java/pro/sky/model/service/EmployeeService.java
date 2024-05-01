package pro.sky.model.service;

import org.springframework.stereotype.Service;
import pro.sky.exception.EmployeeAlreadyAddedException;
import pro.sky.exception.EmployeeNotFoundException;
import pro.sky.exception.EmployeeStorageIsFullException;
import pro.sky.model.Employee;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class EmployeeService {
    private final int maxEmployee = 10;
    private final List<Employee> employees = new ArrayList<>();
    public Employee add(String firstname, String lastName){
      Employee employee = new Employee(firstname, lastName);
      if(employees.contains(employee)){
          throw new EmployeeAlreadyAddedException();
      }
      if(employees.size()>=maxEmployee){
          throw new EmployeeStorageIsFullException();
      }
      employees.add(employee);
      return employee;
    }
    public Employee remove(String firstname, String lastName){
        Employee employee = new Employee(firstname, lastName);
        if(!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }
    public Employee find(String firstname, String lastName){
        Employee employee = new Employee(firstname, lastName);
        if(!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }

        return employee;
    }
    public List<Employee> findAll(){
        return Collection.unmodifiableList(employees);
    }

}
