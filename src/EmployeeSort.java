import java.util.*;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name; this.age = age; this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class EmployeeSort {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, 50000),
            new Employee("Bob", 25, 60000),
            new Employee("Charlie", 28, 55000)
        );

        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("Sorted by name: " + employees);

        employees.sort(Comparator.comparingInt(Employee::getAge));
        System.out.println("Sorted by age: " + employees);

        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.println("Sorted by salary (desc): " + employees);
    }
}
