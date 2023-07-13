public class EmployeeBook {

    /*
    Привести структуру проекта к ООП.

    1. Создать класс EmployeeBook.
    2. Перенести хранилище сотрудников в него (массив), закрыть к нему доступ извне (сделать приватным).
    3. Все статические методы по работе с массивом перенести в этот класс и сделать нестатическими.
    4. Добавить несколько новых методов:
        1. Добавить нового сотрудника (создаем объект, заполняем поля, кладем в массив).
        Нужно найти свободную ячейку в массиве и добавить нового сотрудника в нее. Искать нужно всегда с начала, так как возможно добавление в ячейку удаленных ранее сотрудников.
        2. Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id, обнуляем его ячейку вмассиве).
    5. Изменить сотрудника (получить сотрудника по Ф. И. О., модернизировать его запись):
        1. Изменить зарплату.
        2. Изменить отдел.
        Придумать архитектуру. Сделать или два метода, или один, но продумать его.
    6. Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
     */

    private final Employee[] employeeList = new Employee[10];

    public void addNewEmployee(String name, int department, int salary){

        for (int i = 0; i < employeeList.length; i++){
            if (employeeList[i] == null){
                employeeList[i] = new Employee(name, department, salary);
                break;
            }
        }
    }

    public void deleteEmployee(String name, int id){
        for (int i = 0; i < employeeList.length; i++){
            String checkName = employeeList[i].getName();
            if (checkName.equals(name) || employeeList[i].getID() == id){
                employeeList[i] = null;
                break;
            }
        }
    }

    public void setDepartment(String name, int newDepartment){
        for (int i = 0; i < employeeList.length; i++){
            String checkName = employeeList[i].getName();
            if (checkName.equals(name)){
                employeeList[i].setDepartment(newDepartment);
                break;
            }
        }
    }

    public void setSalary(String name, int newSalary){
        for (int i = 0; i < employeeList.length; i++){
            String checkName = employeeList[i].getName();
            if (checkName.equals(name)){
                employeeList[i].setSalary(newSalary);
                break;
            }
        }
    }

    public void printEmployeeList(){
        // Метод для получения списка сотрудников со всеми данными (ID, имя, отдел, з/п)

        System.out.println("Справочник сотрудников:\n");
        for (Employee i : employeeList) {
            System.out.println(i);
        }
        System.out.println();
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
        Employee employee = new Employee(null, 0, 0);

        for (Employee i : employeeList){
            if (lowestSalary > i.getSalary()){
                lowestSalary = i.getSalary();
                employee = i;
            }
        }
        System.out.println("Работник с наименьшей зарплатой:\n" + employee + "\n");
    }

    public void findHighestSalary(){
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

    public void findAverageSalary(){
        // метод для рассчета средней зарплаты

        int averageSalary = 0;

        for (Employee i : employeeList){
            averageSalary += i.getSalary() / employeeList.length;
        }
        System.out.println("Среднее значение зарплат: " + averageSalary + " р.\n");
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
        Employee employee = new Employee(null, 0, 0);

        for (Employee i : employeeList){
            if ((i.getDepartment() == department) && (lowestSalary > i.getSalary())){
                lowestSalary = i.getSalary();
                employee = i;
            }
        }
        System.out.println("Работник с наименьшей зарплатой в отделе" + department + " :\n" + employee + "\n");
    }

    public void findHighestSalaryByDepartment(int department){
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

    public void getEmployeesByDepartment(int department) {
        // вывод сотрудников внутри отдела

        System.out.println("Список всех сотрудников отдела " + department + ":");
        for (Employee i : employeeList){
            if (i.getDepartment() == department) {
                System.out.println("ФИО: " + i.getName() + ", Зарплата: " + i.getSalary());
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
