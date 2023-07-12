import java.util.Objects;

public class Employee{

    private final String name;      // имя (неизменяемое поле)
    private int department;         // отдел
    private int salary;             // зарплата
    private static int counter = 1; // счетчик для id
    private int id;                 // id сотрудника
    private int totalSalary;

    public Employee(String name, int department, int salary){
        // конструктор

        this.name = name;
        this.department = department;
        this.salary = salary;
        this.id = getID();
        counter++;

    }

    @Override
    public String toString(){
        // переопределяем метод toString

        return id + ". ФИО: " + getName() + ", Отдел: " + getDepartment() + ", Зарплата: " + getSalary() + " р.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id
                && totalSalary == employee.totalSalary && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, salary, id, totalSalary);
    }

    public String getName(){
        //геттер для имени

        return this.name;
    }

    public int getDepartment(){
        // геттер для отдела

        return this.department;
    }

    public void setDepartment(int department){
        // сеттер для отдела

        this.department = department;
    }

    public int getSalary(){
        // геттер для зарплаты

        return this.salary;
    }

    public void setSalary(int salary){
        // сеттер для зарплаты

        this.salary = salary;
    }

    public int getID() {
        // геттер для id

        this.id = counter;
        return id;
    }



}
