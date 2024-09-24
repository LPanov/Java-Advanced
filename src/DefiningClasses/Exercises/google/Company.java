package DefiningClasses.Exercises.google;

public class Company {
    String name;
    String department;
    double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return name + " " + department + " " + String.format("%.2f", salary);
    }
}
