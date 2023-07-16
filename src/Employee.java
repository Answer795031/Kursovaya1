import java.util.Objects;

public class Employee{

    private final String name;      // имя (неизменяемое поле)
    private int department;         // отдел
    private int salary;             // зарплата
    private static int counter = 1; // счетчик для id
    private int id;                 // id сотрудника

    public Employee(String name, int department, int salary){
        // конструктор

        this.id = getID();

        this.name = name;
        this.department = department;
        this.salary = salary;


    }

    @Override
    public String toString(){
        // переопределяем метод toString

        return this.id + ". ФИО: " + getName() + ", Отдел: " + getDepartment() + ", Зарплата: " + getSalary() + " р.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary
                                                 && id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, salary, id);
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

        this.id = Employee.counter;
        Employee.counter++;

        if (Employee.counter > 10){
            Employee.counter = 1;
        }

        return this.id;
    }
}
