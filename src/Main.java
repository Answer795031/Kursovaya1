public class Main
{
    // создаем массив для объектов типа Employee
    public static Employee[] employeeList = new Employee[10];

    public static void main(String[] args) {

        // заполняем массив сотрудников
        employeeList[0] = new Employee("Шумской Анатолий Викторович", 3, 25500);
        employeeList[1] = new Employee("Петров Вадим Анатольевич", 2, 28200);
        employeeList[2] = new Employee("Еремеев Егор Витальевич", 3, 70900);
        employeeList[3] = new Employee("Федоров Игорь Павлович", 4, 56000);
        employeeList[4] = new Employee("Трофимова Евгения Юрьевна", 1, 33800);
        employeeList[5] = new Employee("Телецкая Ирина Алексеевна", 5, 24100);
        employeeList[6] = new Employee("Котов Виктор Львович", 4, 47500);
        employeeList[7] = new Employee("Шарова Ангелина Сергеевна", 2, 23000);
        employeeList[8] = new Employee("Костин Антон Олегович", 1, 69000);
        employeeList[9] = new Employee("Иванов Иван Иванович", 5, 43000);

        // выводим список сотрудников
        printEmployeeList();

        // Проверка работоспособности сеттеров
        employeeList[0].setDepartment(5);
        employeeList[0].setSalary(20500);

        // выводим список сотрудников
        printEmployeeList();

        // получаем сумму всех затрат на з/п в месяц
        totalSalary();

        // выводим сотрудников с минимальной и максимальной з/п соответственно
        findLowestSalary();
        findHighestSalary();

        // выводим среднее значение з/п сотрудников
        findAverageSalary();

        // выводим список сотрудников (только ФИО)
        getFIO();

        // индексируем зарплаты всех сотрудников на величину процента, %
        salaryIncreaseByPercent(10);
        printEmployeeList();

        // выводим сотрудников с минимальной и максимальной з/п соответственно внутри конкретного отдела
        findLowestSalaryByDepartment(1);
        findHighestSalaryByDepartment(3);

        // получаем сумму всех затрат на з/п в месяц внутри отдела
        totalSalaryByDepartment(5);

        // выводим среднее значение з/п сотрудников внутри отдела
        findAverageSalaryByDepartment(1);

        // индексируем зарплаты всех сотрудников в отделе на величину процента, %
        salaryIncreaseByPercentByDepartment(5, 12);
        printEmployeeList();

        // выводим список сотрудников по отделу
        getEmployeesByDepartment(5);

    }

    public static void printEmployeeList(){
        // Метод для получения списка сотрудников со всеми данными (ID, имя, отдел, з/п)

        System.out.println("Справичник сотрудников:\n");
        for (Employee i : employeeList) {
            System.out.println(i);
        }
        System.out.println();
    }

    public static void totalSalary(){
        // Метод для вывода общей суммы затрат на зарплаты

        int totalSalary = 0;
        for (Employee i : employeeList){
            totalSalary += i.getSalary();
        }
        System.out.println("\nСумма затрат на зарплаты в месяц: " + totalSalary + " р.\n");
    }

    public static void findLowestSalary(){
        // метод для поиска нищебродов
        // создаем пустой шаблон объекта и инициализируем максимальное значение int для сравнения
        // при выполнении условия сравнения, записываем сотрудника в шаблон для вывода

        int lowestSalary = Integer.MAX_VALUE;
        Employee employee = new Employee(null, 0, 0);

        for (Employee i : employeeList){
            if (lowestSalary > i.getSalary()){
                lowestSalary = i.getSalary();
                employee = i;
            }
        }
        System.out.println("Работник с наименьшей зарплатой:\n" + employee + "\n");
    }

    public static void findHighestSalary(){
        // метод для поиска мажоров
        // создаем пустой шаблон объекта и инициализируем максимальное значение int для сравнения
        // при выполнении условия сравнения, записываем сотрудника в шаблон для вывода

        int lowestSalary = Integer.MIN_VALUE;
        Employee employee = new Employee(null, 0, 0);

        for (Employee i : employeeList){
            if (lowestSalary < i.getSalary()){
                lowestSalary = i.getSalary();
                employee = i;
            }
        }
        System.out.println("Работник с наибольшей зарплатой:\n" + employee + "\n");
    }

    public static void findAverageSalary(){
        // метод для рассчета средней зарплаты

        int averageSalary = 0;

        for (Employee i : employeeList){
            averageSalary += i.getSalary() / employeeList.length;
        }
        System.out.println("Среднее значение зарплат: " + averageSalary + " р.\n");
    }

    public static void getFIO() {
        // вывод ФИО всех сотрудников

        System.out.println("Список ФИО всех сотрудников:\n");
        for (Employee i : employeeList){
            System.out.println(i.getName());
        }
    }

    /*

    Получить в качестве параметра число и найти:
    1. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
    2. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
     */

    public static void salaryIncreaseByPercent(double percent){
        // метод для индексации з/п на указанный процент

        for (Employee i : employeeList){
            i.setSalary(i.getSalary() + (int)(i.getSalary() * percent / 100));
        }
        System.out.println();
    }

    public static void findLowestSalaryByDepartment(int department){
        // метод для поиска нищебродов внутри отдела
        // создаем пустой шаблон объекта и инициализируем максимальное значение int для сравнения
        // при выполнении условия сравнения, записываем сотрудника в шаблон для вывода

        int lowestSalary = Integer.MAX_VALUE;
        Employee employee = new Employee(null, 0, 0);

        for (Employee i : employeeList){
            if ((i.getDepartment() == department) && (lowestSalary > i.getSalary())){
                lowestSalary = i.getSalary();
                employee = i;
            }
        }
        System.out.println("Работник с наименьшей зарплатой в отделе" + department + " :\n" + employee + "\n");
    }

    public static void findHighestSalaryByDepartment(int department){
        // метод для поиска мажоров внутри отдела
        // создаем пустой шаблон объекта и инициализируем максимальное значение int для сравнения
        // при выполнении условия сравнения, записываем сотрудника в шаблон для вывода

        int lowestSalary = Integer.MIN_VALUE;
        Employee employee = new Employee(null, 0, 0);

        for (Employee i : employeeList){
            if ((i.getDepartment() == department) && (lowestSalary < i.getSalary())){
                lowestSalary = i.getSalary();
                employee = i;
            }
        }
        System.out.println("Работник с наибольшей зарплатой в отделе" + department + " :\n" + employee + "\n");
    }

    public static void totalSalaryByDepartment(int department){
        // Метод для вывода общей суммы затрат на зарплаты сотрудников внутри отдела

        int totalSalary = 0;
        for (Employee i : employeeList){
            if (i.getDepartment() == department) {
                totalSalary += i.getSalary();
            }
        }
        System.out.println("\nСумма затрат на зарплаты в месяц в отделе " + department + " : " + totalSalary + " р.\n");
    }

    public static void findAverageSalaryByDepartment(int department){
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

    public static void salaryIncreaseByPercentByDepartment(int department, double percent){
        // метод для индексации з/п в отделе на указанный процент

        for (Employee i : employeeList){
            if (i.getDepartment() == department) {
                i.setSalary(i.getSalary() + (int) (i.getSalary() * percent / 100));
            }
        }
        System.out.println();
    }

    public static void getEmployeesByDepartment(int department) {
        // вывод сотрудников внутри отдела

        System.out.println("Список всех сотрудников отдела " + department);
        for (Employee i : employeeList){
            if (i.getDepartment() == department) {
                System.out.println("ФИО: " + i.getName() + ", Зарплата: " + i.getSalary());
            }
        }
    }
}