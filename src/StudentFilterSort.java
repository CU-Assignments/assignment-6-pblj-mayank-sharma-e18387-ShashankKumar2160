import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name; this.marks = marks;
    }

    public String toString() {
        return name + ": " + marks;
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Arjun", 85.5),
            new Student("Kriti", 65.0),
            new Student("Ravi", 78.0),
            new Student("Pooja", 91.0)
        );

        List<String> topStudents = students.stream()
            .filter(s -> s.marks > 75)
            .sorted(Comparator.comparingDouble(s -> -s.marks))
            .map(s -> s.name)
            .collect(Collectors.toList());

        System.out.println("Top students: " + topStudents);
    }
}
