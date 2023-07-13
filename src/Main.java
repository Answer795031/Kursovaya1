public class Main {

    public static void main(String[] args) {

        EmployeeBook empBook = new EmployeeBook();

        // заполняем массив сотрудников
        empBook.addNewEmployee("Шумской Анатолий Викторович", 3, 25500);
        empBook.addNewEmployee("Петров Вадим Анатольевич", 2, 28200);
        empBook.addNewEmployee("Еремеев Егор Витальевич", 3, 70900);
        empBook.addNewEmployee("Федоров Игорь Павлович", 4, 56000);
        empBook.addNewEmployee("Трофимова Евгения Юрьевна", 1, 33800);
        empBook.addNewEmployee("Телецкая Ирина Алексеевна", 5, 24100);
        empBook.addNewEmployee("Котов Виктор Львович", 4, 47500);
        empBook.addNewEmployee("Шарова Ангелина Сергеевна", 2, 23000);
        empBook.addNewEmployee("Костин Антон Олегович", 1, 69000);
        empBook.addNewEmployee("Иванов Иван Иванович", 5, 43000);

        // выводим список сотрудников
        empBook.printEmployeeList();

        // Проверка работоспособности сеттеров
        empBook.setDepartment("Шумской Анатолий Викторович", 5);
        empBook.setSalary("Шумской Анатолий Викторович", 20500);

        // выводим список сотрудников
        empBook.printEmployeeList();

        // получаем сумму всех затрат на з/п в месяц
        empBook.totalSalary();

        // выводим сотрудников с минимальной и максимальной з/п соответственно
        empBook.findLowestSalary();
        empBook.findHighestSalary();

        // выводим среднее значение з/п сотрудников
        empBook.findAverageSalary();

        // выводим список сотрудников (только ФИО)
        empBook.getFIO();

        // индексируем зарплаты всех сотрудников на величину процента, %
        empBook.salaryIncreaseByPercent(10);
        empBook.printEmployeeList();

        // выводим сотрудников с минимальной и максимальной з/п соответственно внутри конкретного отдела
        empBook.findLowestSalaryByDepartment(1);
        empBook.findHighestSalaryByDepartment(3);

        // получаем сумму всех затрат на з/п в месяц внутри отдела
        empBook.totalSalaryByDepartment(5);

        // выводим среднее значение з/п сотрудников внутри отдела
        empBook.findAverageSalaryByDepartment(1);

        // индексируем зарплаты всех сотрудников в отделе на величину процента, %
        empBook.salaryIncreaseByPercentByDepartment(5, 12);
        empBook.printEmployeeList();

        // выводим список сотрудников по отделу
        empBook.getEmployeesByDepartment(5);

        // выводим список сотрудников в з/п меньше указанной
        empBook.findSalaryLessThenValue(52250);

        // выводим список сотрудников в з/п больше или равной указанной
        empBook.findSalaryMoreThenValue(52250);

        // удаление сотрудника
        empBook.deleteEmployee("Иванов Иван Иванович", 9);

    }

//    public static void printEmployeeList(){
//        // Метод для получения списка сотрудников со всеми данными (ID, имя, отдел, з/п)
//
//        System.out.println("Справичник сотрудников:\n");
//        for (Employee i : employeeList) {
//            System.out.println(i);
//        }
//        System.out.println();
//    }
//
//    public static void totalSalary(){
//        // Метод для вывода общей суммы затрат на зарплаты
//
//        int totalSalary = 0;
//        for (Employee i : employeeList){
//            totalSalary += i.getSalary();
//        }
//        System.out.println("\nСумма затрат на зарплаты в месяц: " + totalSalary + " р.\n");
//    }
//
//    public static void findLowestSalary(){
//        // метод для поиска нищебродов
//        // создаем пустой шаблон объекта и инициализируем максимальное значение int для сравнения
//        // при выполнении условия сравнения, записываем сотрудника в шаблон для вывода
//
//        int lowestSalary = Integer.MAX_VALUE;
//        Employee employee = new Employee(null, 0, 0);
//
//        for (Employee i : employeeList){
//            if (lowestSalary > i.getSalary()){
//                lowestSalary = i.getSalary();
//                employee = i;
//            }
//        }
//        System.out.println("Работник с наименьшей зарплатой:\n" + employee + "\n");
//    }
//
//    public static void findHighestSalary(){
//        // метод для поиска мажоров
//        // создаем пустой шаблон объекта и инициализируем максимальное значение int для сравнения
//        // при выполнении условия сравнения, записываем сотрудника в шаблон для вывода
//
//        int lowestSalary = Integer.MIN_VALUE;
//        Employee employee = new Employee(null, 0, 0);
//
//        for (Employee i : employeeList){
//            if (lowestSalary < i.getSalary()){
//                lowestSalary = i.getSalary();
//                employee = i;
//            }
//        }
//        System.out.println("Работник с наибольшей зарплатой:\n" + employee + "\n");
//    }
//
//    public static void findAverageSalary(){
//        // метод для рассчета средней зарплаты
//
//        int averageSalary = 0;
//
//        for (Employee i : employeeList){
//            averageSalary += i.getSalary() / employeeList.length;
//        }
//        System.out.println("Среднее значение зарплат: " + averageSalary + " р.\n");
//    }
//
//    public static void getFIO() {
//        // вывод ФИО всех сотрудников
//
//        System.out.println("Список ФИО всех сотрудников:\n");
//        for (Employee i : employeeList){
//            System.out.println(i.getName());
//        }
//    }
//
//    public static void salaryIncreaseByPercent(double percent){
//        // метод для индексации з/п на указанный процент
//
//        for (Employee i : employeeList){
//            i.setSalary(i.getSalary() + (int)(i.getSalary() * percent / 100));
//        }
//        System.out.println();
//    }
//
//    public static void findLowestSalaryByDepartment(int department){
//        // метод для поиска нищебродов внутри отдела
//        // создаем пустой шаблон объекта и инициализируем максимальное значение int для сравнения
//        // при выполнении условия сравнения, записываем сотрудника в шаблон для вывода
//
//        int lowestSalary = Integer.MAX_VALUE;
//        Employee employee = new Employee(null, 0, 0);
//
//        for (Employee i : employeeList){
//            if ((i.getDepartment() == department) && (lowestSalary > i.getSalary())){
//                lowestSalary = i.getSalary();
//                employee = i;
//            }
//        }
//        System.out.println("Работник с наименьшей зарплатой в отделе" + department + " :\n" + employee + "\n");
//    }
//
//    public static void findHighestSalaryByDepartment(int department){
//        // метод для поиска мажоров внутри отдела
//        // создаем пустой шаблон объекта и инициализируем максимальное значение int для сравнения
//        // при выполнении условия сравнения, записываем сотрудника в шаблон для вывода
//
//        int lowestSalary = Integer.MIN_VALUE;
//        Employee employee = new Employee(null, 0, 0);
//
//        for (Employee i : employeeList){
//            if ((i.getDepartment() == department) && (lowestSalary < i.getSalary())){
//                lowestSalary = i.getSalary();
//                employee = i;
//            }
//        }
//        System.out.println("Работник с наибольшей зарплатой в отделе" + department + " :\n" + employee + "\n");
//    }
//
//    public static void totalSalaryByDepartment(int department){
//        // Метод для вывода общей суммы затрат на зарплаты сотрудников внутри отдела
//
//        int totalSalary = 0;
//        for (Employee i : employeeList){
//            if (i.getDepartment() == department) {
//                totalSalary += i.getSalary();
//            }
//        }
//        System.out.println("\nСумма затрат на зарплаты в месяц в отделе " + department + " : " + totalSalary + " р.\n");
//    }
//
//    public static void findAverageSalaryByDepartment(int department){
//        // метод для рассчета средней зарплаты внутри отдела
//
//        int averageSalary = 0;
//        int counter = 0;
//
//        // считаем количество человек для корректного подсчета средней з/п
//        for (Employee i : employeeList){
//            if (i.getDepartment() == department){
//                counter++;
//            }
//        }
//
//        // выполняем подсчет средней з/п
//        for (Employee i : employeeList){
//            if (i.getDepartment() == department) {
//                averageSalary += i.getSalary() / counter;
//            }
//        }
//        System.out.println("Среднее значение зарплат в отделе " + department + " : " + averageSalary + " р.\n");
//    }
//
//    public static void salaryIncreaseByPercentByDepartment(int department, double percent){
//        // метод для индексации з/п в отделе на указанный процент
//
//        for (Employee i : employeeList){
//            if (i.getDepartment() == department) {
//                i.setSalary(i.getSalary() + (int) (i.getSalary() * percent / 100));
//            }
//        }
//        System.out.println();
//    }
//
//    public static void getEmployeesByDepartment(int department) {
//        // вывод сотрудников внутри отдела
//
//        System.out.println("Список всех сотрудников отдела " + department + ":");
//        for (Employee i : employeeList){
//            if (i.getDepartment() == department) {
//                System.out.println("ФИО: " + i.getName() + ", Зарплата: " + i.getSalary());
//            }
//        }
//    }
//
//    public static void findSalaryLessThenValue(int salary){
//        // метод для поиска сотрудников с з/п меньше указанной
//
//        System.out.println("\nСотрудники с зарплатой меньше " + salary + " р.:");
//        for (Employee i : employeeList){
//            if (i.getSalary() < salary){
//                System.out.println(i);
//            }
//        }
//    }
//
//    public static void findSalaryMoreThenValue(int salary){
//        // метод для поиска сотрудников с з/п большей или равной указанной
//
//        System.out.println("\nСотрудники с зарплатой большей или равной " + salary + " р.:");
//        for (Employee i : employeeList){
//            if (i.getSalary() >= salary){
//                System.out.println(i);
//            }
//        }
//    }
}