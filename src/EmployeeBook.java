import java.util.Scanner;

public class EmployeeBook {

    Scanner scanner = new Scanner(System.in);

    private String name;
    private int department, salary, check;
    private double percent;

    private final Employee[] employeeList = new Employee[10]; // массив сотрудников

    public void addNewEmployee() {
        // Метод для добавления нового сотрудника

        System.out.println("\nВведите данные сотрудника: ");
        System.out.print("Введите ФИО: ");

        // Проверка на соответствие вводимого параметра типу int
        while (scanner.hasNextInt()) {
            System.out.println("Ошибка! ФИО не должно содержать цифр!");
            System.out.print("Введите ФИО: ");
            scanner.next();
        }

        name = scanner.nextLine();

        System.out.print("\nВведите номер отдела: ");

        // Проверка на соответствие вводимого параметра типу int
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите число");
            System.out.print("Введите номер отдела: ");
            scanner.next();
        }

        department = scanner.nextInt();
        scanner.nextLine();

        // Проверка на соответствие существующим отделам { 1 - 5 }
        check = checkDepartment(department);
        switch (check){
            case 0:
                addNewEmployee(); // рекурсия
            case 1:
        }

        System.out.print("\nВведите зарплату: ");

        // Проверка на соответствие вводимого параметра типу int
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите число");
            System.out.print("Введите зарплату: ");
            scanner.next();
        }

        salary = scanner.nextInt();

        // Проверка зарплаты на отрицательное значение
        check = checkSalary(salary);
        switch (check){
            case 0:
                addNewEmployee(); // рекурсия
            case 1:
        }

        scanner.nextLine();


        for (int i = 0; i < employeeList.length; i++) {
            // Проходимся по массиву - если нашли пустой элемент, вписываем в него нового сотрудника

            if (employeeList[i] == null) {
                employeeList[i] = new Employee(name, department, salary);
                employeeList[i].getID(i + 1);   // магия, хз как работает, но работает
                break;
            }
        }
    }

    public void deleteEmployee() {
        // Метод для удаления сотрудника из списка на выбор - по ФИО или по ID

        System.out.println("Удалить сотрудника по:\n" +
                "1 - Имени\n" +
                "2 - ID");

        System.out.print("Введите параметр: ");

        // Проверка на соответствие вводимого параметра типу int
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите число");
            System.out.print("Введите параметр: ");
            scanner.next();
        }

        check = scanner.nextInt();
        scanner.nextLine();

        switch (check) {
            case 1:
                // Удаление по имени

                System.out.print("Введите ФИО: ");

                // Проверка на соответствие вводимого параметра типу int
                // Простенько. Уже не стал заморачиваться с проверкой на наличие цифр в строке где есть буквы =)
                while (scanner.hasNextInt()) {
                    System.out.println("Ошибка! ФИО не должно содержать цифр!");
                    System.out.print("Введите ФИО: ");
                    scanner.next();
                }

                name = scanner.nextLine();

                for (int i = 0; i < employeeList.length; i++) {

                    if (employeeList[i] == null) {
                        // Игнорируем пустые строки

                        continue;
                    }

                    String checkName = employeeList[i].getName(); // переменная для сравнения имен

                    if (checkName.equals(name)) {
                        // Если ФИО совпали - удаляем запись

                        employeeList[i] = null;
                        break;
                    }
                }

                break;

            case 2:
                // Удаление по ID

                System.out.print("Введите ID: ");

                // Проверка на соответствие вводимого параметра типу int
                while (!scanner.hasNextInt()) {
                    System.out.println("Ошибка! Введите число");
                    System.out.print("Введите ID: ");
                    scanner.next();
                }

                int id = scanner.nextInt();

                for (int i = 0; i < employeeList.length; i++) {

                    if (employeeList[i] == null) {
                        // Игнорируем пустые строки

                        continue;
                    }

                    // Если совпал ID - удаляем
                    if (employeeList[i].getID(i + 1) == id) {
                        employeeList[i] = null;
                        break;
                    }
                }

                break;

            default:
                System.out.println("Ошибка! Введите корректный параметр!");
                break;
        }

    }

    public void setEmployee() {
        // Метод для изменения существующих записей сотрудников

        scanner.nextLine();
        System.out.print("Введите ФИО: ");

        // Проверка на соответствие вводимого параметра типу int
        while (scanner.hasNextInt()) {
            System.out.println("Ошибка! ФИО не должно содержать цифр");
            System.out.print("Введите ФИО: ");
            scanner.next();
        }

        name = scanner.nextLine();

        for (Employee i : employeeList) {

            if (i == null) {
                continue;
            }

            String checkName = i.getName();

            // Если обнаружено совпадение ФИО
            if (checkName.equals(name)) {
                System.out.println("Параметры, которые можно изменить:\n" +
                        "1 - отдел\n" +
                        "2 - зарплата");

                System.out.print("Введите параметр: ");

                // Проверка на соответствие вводимого параметра типу int
                while (!scanner.hasNextInt()) {
                    System.out.println("Ошибка! Введите число");
                    System.out.print("Введите параметр: ");
                    scanner.next();
                }

                int check = scanner.nextInt();
                scanner.nextLine();

                switch (check) {
                    case 1:
                        // Изменение отдела

                        System.out.print("Введите номер нового отдела: ");

                        // Проверка на соответствие вводимого параметра типу int
                        while (!scanner.hasNextInt()) {
                            System.out.println("Ошибка! Введите число");
                            System.out.print("Введите номер нового отдела: ");
                            scanner.next();
                        }

                        int newDepartment = scanner.nextInt();

                        // Проверка на соответствие существующим отделам { 1 - 5 }
                        check = checkDepartment(department);
                        switch (check){
                            case 0:
                                setEmployee(); // рекурсия
                            case 1:
                        }

                        i.setDepartment(newDepartment);
                        break;

                    case 2:
                        // Изменение зарплаты

                        System.out.print("Введите новую зарплату: ");

                        // Проверка на соответствие вводимого параметра типу int
                        while (!scanner.hasNextInt()) {
                            System.out.println("Ошибка! Введите число");
                            System.out.print("Введите новую зарплату: ");
                            scanner.next();
                        }

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

    public void printEmployeeList() {
        // Метод для получения списка сотрудников со всеми данными (ID, имя, отдел, з/п)

        System.out.println("\nСправочник сотрудников:");
        for (Employee i : employeeList) {
            System.out.println(i);
        }
        System.out.println();
    }

    public void printAllEmployeesByDepartment() {
        // Метод для получения списка сотрудников по каждому отделу
        // Делаем столько прохождений по массиву, сколько существует отделов

        System.out.println("\nОтдел 1:");

        for (Employee i : employeeList) {
            if (i == null) {
                continue;
            }

            if (i.getDepartment() == 1) {
                System.out.println("ФИО: " + i.getName() + ", Зарплата: " + i.getSalary() + " р.");
            }
        }

        System.out.println("\nОтдел 2:");

        for (Employee i : employeeList) {
            if (i == null) {
                continue;
            }

            if (i.getDepartment() == 2) {
                System.out.println("ФИО: " + i.getName() + ", Зарплата: " + i.getSalary() + " р.");
            }
        }

        System.out.println("\nОтдел 3:");

        for (Employee i : employeeList) {
            if (i == null) {
                continue;
            }

            if (i.getDepartment() == 3) {
                System.out.println("ФИО: " + i.getName() + ", Зарплата: " + i.getSalary() + " р.");
            }
        }

        System.out.println("\nОтдел 4:");

        for (Employee i : employeeList) {
            if (i == null) {
                continue;
            }

            if (i.getDepartment() == 4) {
                System.out.println("ФИО: " + i.getName() + ", Зарплата: " + i.getSalary() + " р.");
            }
        }

        System.out.println("\nОтдел 5:");

        for (Employee i : employeeList) {
            if (i == null) {
                continue;
            }

            if (i.getDepartment() == 5) {
                System.out.println("ФИО: " + i.getName() + ", Зарплата: " + i.getSalary() + " р.");
            }
        }
    }

    public void totalSalary() {
        // Метод для вывода общей суммы затрат на зарплаты

        int totalSalary = 0;
        for (Employee i : employeeList) {
            totalSalary += i.getSalary();
        }
        System.out.println("\nСумма затрат на зарплаты в месяц: " + totalSalary + " р.\n");
    }

    public void findLowestSalary() {
        // Метод для поиска нищебродов

        int lowestSalary = Integer.MAX_VALUE;

        // Сначала ищем минимальную зарплату в списке
        for (Employee i : employeeList) {
            if (lowestSalary > i.getSalary()) {
                lowestSalary = i.getSalary();
            }
        }

        // Затем ищем сотрудника с такой зарплатой. Если есть два и более таких работника, будут выведены все
        for (Employee i : employeeList) {
            int checkSalary = i.getSalary();
            if (checkSalary == lowestSalary) {
                System.out.println("\nРаботник с наименьшей зарплатой:\n" + i);
            }
        }
    }

    public void findHighestSalary() {
        // Метод для поиска мажоров

        int lowestSalary = Integer.MIN_VALUE;

        // Сначала ищем максимальную зарплату в списк
        for (Employee i : employeeList) {
            if (lowestSalary < i.getSalary()) {
                lowestSalary = i.getSalary();
            }
        }

        // Затем ищем сотрудника с такой зарплатой. Если есть два и более таких работника, будут выведены все
        for (Employee i : employeeList) {
            int checkSalary = i.getSalary();
            if (checkSalary == lowestSalary) {
                System.out.println("\nРаботник с наибольшей зарплатой:\n" + i);
            }
        }
    }

    public void findAverageSalary() {
        // Метод для рассчета средней зарплаты

        int averageSalary = 0;

        for (Employee i : employeeList) {
            averageSalary += i.getSalary() / employeeList.length;
        }
        System.out.println("\nСреднее значение зарплат: " + averageSalary + " р.\n");
    }

    public void getFIO() {
        // Метод для вывода ФИО всех сотрудников. Не включен в быстрый доступ через меню за ненадобностью

        System.out.println("Список ФИО всех сотрудников:\n");
        for (Employee i : employeeList) {
            System.out.println(i.getName());
        }
    }

    public void salaryIncreaseByPercent() {
        // Метод для индексации з/п на указанный процент

        System.out.print("Введите процент индексации: ");

        // Проверка на соответствие вводимого параметра типу double
        while (!scanner.hasNextDouble()) {
            System.out.println("Ошибка! Введите число");
            System.out.print("Введите процент индексации: ");
            scanner.next();
        }

        percent = scanner.nextDouble();

        check = checkPercent(percent);
        switch (check){
            case 0:
                salaryIncreaseByPercent(); // рекурсия
            case 1:
        }

        for (Employee i : employeeList) {
            i.setSalary(i.getSalary() + (int) (i.getSalary() * percent / 100));
        }
        System.out.println();
    }

    public void findLowestSalaryByDepartment() {
        // Метод для поиска нищебродов внутри отдела.
        // Функционал аналогичен методу findLowestSalary(), но с проверкой на соответствие департаменту

        System.out.print("Введите номер отдела: ");

        // Проверка на соответствие вводимого параметра типу int
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите число");
            System.out.print("Введите номер отдела: ");
            scanner.next();
        }

        department = scanner.nextInt();

        // Проверка на соответствие существующим отделам { 1 - 5 }
        check = checkDepartment(department);
        switch (check){
            case 0:
                findLowestSalaryByDepartment(); // рекурсия
            case 1:
        }


        int lowestSalary = Integer.MAX_VALUE;

        for (Employee i : employeeList) {
            if ((i.getDepartment() == department) && (lowestSalary > i.getSalary())) {
                lowestSalary = i.getSalary();
            }
        }

        for (Employee i : employeeList) {
            int checkSalary = i.getSalary();
            if (checkSalary == lowestSalary) {
                System.out.println("\nРаботник с наименьшей зарплатой в отделе:\n" + i);
            }
        }
    }

    public void findHighestSalaryByDepartment() {
        // Метод для поиска мажоров внутри отдела
        // Функционал аналогичен методу findHighestSalary(), но с проверкой на соответствие департаменту

        System.out.print("Введите номер отдела: ");

        // Проверка на соответствие вводимого параметра типу int
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите число");
            System.out.print("Введите номер отдела: ");
            scanner.next();
        }

        department = scanner.nextInt();

        // Проверка на соответствие существующим отделам { 1 - 5 }
        check = checkDepartment(department);
        switch (check){
            case 0:
                findHighestSalaryByDepartment(); // рекурсия
            case 1:
        }

        int lowestSalary = Integer.MIN_VALUE;

        for (Employee i : employeeList) {
            if ((i.getDepartment() == department) && (lowestSalary < i.getSalary())) {
                lowestSalary = i.getSalary();
            }
        }

        for (Employee i : employeeList) {
            int checkSalary = i.getSalary();
            if (checkSalary == lowestSalary) {
                System.out.println("\nРаботник с наибольшей зарплатой в отделе:\n" + i);
            }
        }
    }

    public void totalSalaryByDepartment() {
        // Метод для вывода общей суммы затрат на зарплаты сотрудников внутри отдела

        System.out.print("Введите номер отдела: ");

        // Проверка на соответствие вводимого параметра типу int
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите число");
            System.out.print("Введите номер отдела: ");
            scanner.next();
        }

        department = scanner.nextInt();

        // Проверка на соответствие существующим отделам { 1 - 5 }
        check = checkDepartment(department);
        switch (check){
            case 0:
                totalSalaryByDepartment(); // рекурсия
            case 1:
        }

        int totalSalary = 0;
        for (Employee i : employeeList) {
            if (i.getDepartment() == department) {
                totalSalary += i.getSalary();
            }
        }
        System.out.println("\nСумма затрат на зарплаты в месяц в отделе " + department + " : " + totalSalary + " р.\n");
    }

    public void findAverageSalaryByDepartment() {
        // Метод для рассчета средней зарплаты внутри отдела

        System.out.print("Введите номер отдела: ");

        // Проверка на соответствие вводимого параметра типу int
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите число");
            System.out.print("Введите номер отдела: ");
            scanner.next();
        }

        department = scanner.nextInt();

        // Проверка на соответствие существующим отделам { 1 - 5 }
        check = checkDepartment(department);
        switch (check){
            case 0:
                findAverageSalaryByDepartment(); // рекурсия
            case 1:
        }


        int averageSalary = 0;
        int counter = 0;

        // Считаем количество человек для корректного подсчета средней з/п
        for (Employee i : employeeList) {
            if (i.getDepartment() == department) {
                counter++;
            }
        }

        // Выполняем подсчет средней з/п внутри отдела
        for (Employee i : employeeList) {
            if (i.getDepartment() == department) {
                averageSalary += i.getSalary() / counter;
            }
        }
        System.out.println("Среднее значение зарплат в отделе " + department + " : " + averageSalary + " р.\n");
    }

    public void salaryIncreaseByPercentByDepartment() {
        // Метод для индексации з/п в отделе на указанный процент

        System.out.print("Введите номер отдела: ");

        // Проверка на соответствие вводимого параметра типу int
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите число");
            System.out.print("Введите номер отдела: ");
            scanner.next();
        }

        department = scanner.nextInt();

        // Проверка на соответствие существующим отделам { 1 - 5 }
        check = checkDepartment(department);
        switch (check){
            case 0:
                salaryIncreaseByPercentByDepartment(); // рекурсия
            case 1:
        }

        System.out.print("Введите процент индексации: ");

        // Проверка на соответствие вводимого параметра типу double
        while (!scanner.hasNextDouble()) {
            System.out.println("Ошибка! Введите число");
            System.out.print("Введите процент индексации: ");
            scanner.next();
        }

        percent = scanner.nextDouble();

        check = checkPercent(percent);
        switch (check){
            case 0:
                salaryIncreaseByPercentByDepartment(); // рекурсия
            case 1:
        }

        for (Employee i : employeeList) {
            if (i.getDepartment() == department) {
                i.setSalary(i.getSalary() + (int) (i.getSalary() * percent / 100));
            }
        }
        System.out.println();
    }

    public void printEmployeesByDepartment() {
        // Метод для получения списка сотрудников внутри отдела

        System.out.print("Введите номер отдела: ");

        // Проверка на соответствие вводимого параметра типу int
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите число");
            System.out.print("Введите номер отдела: ");
            scanner.next();
        }

        department = scanner.nextInt();

        // Проверка на соответствие существующим отделам { 1 - 5 }
        check = checkDepartment(department);
        switch (check){
            case 0:
                printEmployeesByDepartment(); // рекурсия
            case 1:
        }

        System.out.println("Список всех сотрудников отдела " + department + ":");
        for (Employee i : employeeList) {
            if (i.getDepartment() == department) {
                System.out.println("ФИО: " + i.getName() + ", Зарплата: " + i.getSalary() + " р.");
            }
        }
    }

    public void findSalaryLessThenValue() {
        // Метод для поиска сотрудников с з/п меньше указанной

        System.out.print("Введите сумму: ");

        // Проверка на соответствие вводимого параметра типу int
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите число");
            System.out.print("Введите сумму: ");
            scanner.next();
        }

        salary = scanner.nextInt();

        // Проверка зарплаты на отрицательное значение
        check = checkSalary(salary);
        switch (check){
            case 0:
                findSalaryLessThenValue(); // рекурсия
            case 1:
        }

        System.out.println("\nСотрудники с зарплатой меньше " + salary + " р.:");
        for (Employee i : employeeList) {
            if (i.getSalary() < salary) {
                System.out.println(i);
            }
        }
    }

    public void findSalaryMoreThenValue() {
        // Метод для поиска сотрудников с з/п большей или равной указанной

        System.out.print("Введите сумму: ");

        // Проверка на соответствие вводимого параметра типу int
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите число");
            System.out.print("Введите сумму: ");
            scanner.next();
        }

        salary = scanner.nextInt();

        // Проверка зарплаты на отрицательное значение
        check = checkSalary(salary);
        switch (check){
            case 0:
                findSalaryMoreThenValue(); // рекурсия
            case 1:
        }


        System.out.println("\nСотрудники с зарплатой большей или равной " + salary + " р.:");
        for (Employee i : employeeList) {
            if (i.getSalary() >= salary) {
                System.out.println(i);
            }
        }
    }

    public static int checkDepartment(int department){
        // Метод для проверки значения департамента { 1 - 5 }

        if (department < 1 || department > 5) {
            System.out.println("Такого отдела не существует!");
            return 0;
        } else {
            return 1;
        }
    }

    public static int checkSalary(int salary){
        // Метод для проверки значения зарплаты на положительное
        if (salary < 0) {
            System.out.println("Зарплата не может быть отрицательной!");
            return 0;
        } else {
            return 1;
        }
    }

    public static int checkPercent(double percent){
        // Метод для проверки значения зарплаты на положительное
        if (percent <= 0) {
            System.out.println("Процент не может быть отрицательным или равняться 0!");
            return 0;
        } else {
            return 1;
        }
    }

}
