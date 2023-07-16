import java.util.Scanner;

public class EmployeeBook {

    Scanner scanner = new Scanner(System.in);

    private final Employee[] employeeList = new Employee[10];



    public void addNewEmployee(String name, int department, int salary){

        for (int i = 0; i < employeeList.length; i++){
            if (employeeList[i] == null){
                employeeList[i] = new Employee(name, department, salary);
                employeeList[i].getID(i + 1);   // магия
                break;
            }
        }
    }

    public void deleteEmployeeByName(String name){
        for (int i = 0; i < employeeList.length; i++){

            if (employeeList[i] == null){
                continue;
            }

            String checkName = employeeList[i].getName();

            if (checkName.equals(name)){
                employeeList[i] = null;
                break;
            }
        }
    }

    public void deleteEmployeeByID(int id){
        for (int i = 0; i < employeeList.length; i++){

            if (employeeList[i] == null){
                continue;
            }

            if (employeeList[i].getID(i + 1) == id){
                employeeList[i] = null;
                break;
            }
        }
    }

    public void setEmployee(){
        System.out.println("Введите имя сотрудника:");
        String name = scanner.nextLine();

        for (Employee i : employeeList){

            if (i == null){
                continue;
            }

            String checkName = i.getName();

            if (checkName.equals(name)){
                System.out.println("Введите параметр, который необходимо изменить:\n" +
                        "1 - отдел;\n" +
                        "2 - зарплата.");

                switch (scanner.nextInt()){
                    case 1:
                        System.out.println("Введите номер нового отдела:");
                        int newDepartment = scanner.nextInt();

                        if (newDepartment < 1 || newDepartment > 5) {
                            System.out.println("Такого отдела не существует");
                            break;
                        }

                        i.setDepartment(newDepartment);
                        break;

                    case 2:
                        System.out.println("Введите новую зарплату:");
                        int newSalary = scanner.nextInt();
                        i.setSalary(newSalary);
                        break;

                    default:
                        System.out.println("Ошибка! Введен неверный параметр!");
                        break;
                }
                break;
            }
        }
    }

    public void printEmployeeList(){
        // Метод для получения списка сотрудников со всеми данными (ID, имя, отдел, з/п)

        System.out.println("Справочник сотрудников:");
        for (Employee i : employeeList) {
            System.out.println(i);
        }
        System.out.println();
    }

    public void printAllEmployeesByDepartment(){
        System.out.println("\nОтдел 1:");

        for(Employee i : employeeList){
            if (i == null){
                continue;
            }

            if (i.getDepartment() == 1){
                System.out.println("ФИО: " + i.getName() + ", Зарплата: " + i.getSalary() + " р.");
            }
        }

        System.out.println("\nОтдел 2:");

        for(Employee i : employeeList){
            if (i == null){
                continue;
            }

            if (i.getDepartment() == 2){
                System.out.println("ФИО: " + i.getName() + ", Зарплата: " + i.getSalary() + " р.");
            }
        }

        System.out.println("\nОтдел 3:");

        for(Employee i : employeeList){
            if (i == null){
                continue;
            }

            if (i.getDepartment() == 3){
                System.out.println("ФИО: " + i.getName() + ", Зарплата: " + i.getSalary() + " р.");
            }
        }

        System.out.println("\nОтдел 4:");

        for(Employee i : employeeList){
            if (i == null){
                continue;
            }

            if (i.getDepartment() == 4){
                System.out.println("ФИО: " + i.getName() + ", Зарплата: " + i.getSalary() + " р.");
            }
        }

        System.out.println("\nОтдел 5:");

        for(Employee i : employeeList){
            if (i == null){
                continue;
            }

            if (i.getDepartment() == 5){
                System.out.println("ФИО: " + i.getName() + ", Зарплата: " + i.getSalary() + " р.");
            }
        }
    }

    public void totalSalary(){
        // Метод для вывода общей суммы затрат на зарплаты

        int totalSalary = 0;
        for (Employee i : employeeList){
            totalSalary += i.getSalary();
        }
        System.out.println("\nСумма затрат на зарплаты в месяц: " + totalSalary + " р.\n");
    }

    public void findLowestSalary(){
        // метод для поиска нищебродов
        // создаем пустой шаблон объекта и инициализируем максимальное значение int для сравнения
        // при выполнении условия сравнения, записываем сотрудника в шаблон для вывода

        int lowestSalary = Integer.MAX_VALUE;

        for (Employee i : employeeList){
            if (lowestSalary > i.getSalary()){
                lowestSalary = i.getSalary();
            }
        }

        for (Employee i : employeeList){
            int checkSalary = i.getSalary();
            if (checkSalary == lowestSalary){
                System.out.println("\nРаботник с наименьшей зарплатой:\n" + i);
            }
        }
    }

    public void findHighestSalary(){
        // метод для поиска мажоров
        // создаем пустой шаблон объекта и инициализируем максимальное значение int для сравнения
        // при выполнении условия сравнения, записываем сотрудника в шаблон для вывода

        int lowestSalary = Integer.MIN_VALUE;

        for (Employee i : employeeList){
            if (lowestSalary < i.getSalary()){
                lowestSalary = i.getSalary();
            }
        }

        for (Employee i : employeeList){
            int checkSalary = i.getSalary();
            if (checkSalary == lowestSalary){
                System.out.println("\nРаботник с наибольшей зарплатой:\n" + i);
            }
        }
    }

    public void findAverageSalary(){
        // метод для рассчета средней зарплаты

        int averageSalary = 0;

        for (Employee i : employeeList){
            averageSalary += i.getSalary() / employeeList.length;
        }
        System.out.println("\nСреднее значение зарплат: " + averageSalary + " р.\n");
    }

    public void getFIO() {
        // вывод ФИО всех сотрудников

        System.out.println("Список ФИО всех сотрудников:\n");
        for (Employee i : employeeList){
            System.out.println(i.getName());
        }
    }

    public void salaryIncreaseByPercent(double percent){
        // метод для индексации з/п на указанный процент

        for (Employee i : employeeList){
            i.setSalary(i.getSalary() + (int)(i.getSalary() * percent / 100));
        }
        System.out.println();
    }

    public void findLowestSalaryByDepartment(int department){
        // метод для поиска нищебродов внутри отдела
        // создаем пустой шаблон объекта и инициализируем максимальное значение int для сравнения
        // при выполнении условия сравнения, записываем сотрудника в шаблон для вывода

        int lowestSalary = Integer.MAX_VALUE;

        for (Employee i : employeeList){
            if ((i.getDepartment() == department) && (lowestSalary > i.getSalary())){
                lowestSalary = i.getSalary();
            }
        }

        for (Employee i : employeeList){
            int checkSalary = i.getSalary();
            if (checkSalary == lowestSalary){
                System.out.println("\nРаботник с наименьшей зарплатой в отделе:\n" + i);
            }
        }
    }

    public void findHighestSalaryByDepartment(int department){
        // метод для поиска мажоров внутри отдела
        // создаем пустой шаблон объекта и инициализируем максимальное значение int для сравнения
        // при выполнении условия сравнения, записываем сотрудника в шаблон для вывода

        int lowestSalary = Integer.MIN_VALUE;

        for (Employee i : employeeList){
            if ((i.getDepartment() == department) && (lowestSalary < i.getSalary())){
                lowestSalary = i.getSalary();
            }
        }

        for (Employee i : employeeList){
            int checkSalary = i.getSalary();
            if (checkSalary == lowestSalary){
                System.out.println("\nРаботник с наибольшей зарплатой в отделе:\n" + i);
            }
        }
    }

    public void totalSalaryByDepartment(int department){
        // Метод для вывода общей суммы затрат на зарплаты сотрудников внутри отдела

        int totalSalary = 0;
        for (Employee i : employeeList){
            if (i.getDepartment() == department) {
                totalSalary += i.getSalary();
            }
        }
        System.out.println("\nСумма затрат на зарплаты в месяц в отделе " + department + " : " + totalSalary + " р.\n");
    }

    public void findAverageSalaryByDepartment(int department){
        // метод для рассчета средней зарплаты внутри отдела

        int averageSalary = 0;
        int counter = 0;

        // считаем количество человек для корректного подсчета средней з/п
        for (Employee i : employeeList){
            if (i.getDepartment() == department){
                counter++;
            }
        }

        // выполняем подсчет средней з/п
        for (Employee i : employeeList){
            if (i.getDepartment() == department) {
                averageSalary += i.getSalary() / counter;
            }
        }
        System.out.println("Среднее значение зарплат в отделе " + department + " : " + averageSalary + " р.\n");
    }

    public void salaryIncreaseByPercentByDepartment(int department, double percent){
        // метод для индексации з/п в отделе на указанный процент

        for (Employee i : employeeList){
            if (i.getDepartment() == department) {
                i.setSalary(i.getSalary() + (int) (i.getSalary() * percent / 100));
            }
        }
        System.out.println();
    }

    public void printEmployeesByDepartment(int department) {
        // вывод сотрудников внутри отдела

        System.out.println("Список всех сотрудников отдела " + department + ":");
        for (Employee i : employeeList){
            if (i.getDepartment() == department) {
                System.out.println("ФИО: " + i.getName() + ", Зарплата: " + i.getSalary() + " р.");
            }
        }
    }

    public void findSalaryLessThenValue(int salary){
        // метод для поиска сотрудников с з/п меньше указанной

        System.out.println("\nСотрудники с зарплатой меньше " + salary + " р.:");
        for (Employee i : employeeList){
            if (i.getSalary() < salary){
                System.out.println(i);
            }
        }
    }

    public void findSalaryMoreThenValue(int salary){
        // метод для поиска сотрудников с з/п большей или равной указанной

        System.out.println("\nСотрудники с зарплатой большей или равной " + salary + " р.:");
        for (Employee i : employeeList){
            if (i.getSalary() >= salary){
                System.out.println(i);
            }
        }
    }
}
