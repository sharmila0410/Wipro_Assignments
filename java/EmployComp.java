import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        // First, compare by salary
        int salaryComparison = Double.compare(emp1.getSalary(), emp2.getSalary());
        
        // If salaries are the same, compare by name
        if (salaryComparison == 0) {
            return emp1.getName().compareTo(emp2.getName());
        }
        
        return salaryComparison;
    }
}

public class EmployComp {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 50000));
        employees.add(new Employee("Alice", 60000));
        employees.add(new Employee("Bob", 50000));
        employees.add(new Employee("Charlie", 55000));

        // Sort the list using the custom comparator
        Collections.sort(employees, new EmployeeComparator());

        // Print the sorted list
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}