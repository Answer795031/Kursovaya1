import java.util.Scanner;

public class Main {
    static boolean isCorrect;

    public static void main(String[] args) {

        // EmployeeBook empBook = new EmployeeBook();

        action();

    }


    public static void action() {

        Scanner scanner = new Scanner(System.in);
        EmployeeBook empBook = new EmployeeBook();

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

        String name;
        int department, salary, id, check;
        double percent;

        do {

            System.out.println("Доступные действия:\n" +
                    "1 - Вывести список сотрудников\n" +
                    "2 - Вывести список сотрудников (отдел)\n" +
                    "3 - Вывести список сотрудников (все отделы)\n" +
                    "4 - Добавить нового сотрудника\n" +
                    "5 - Удалить сотрудника\n" +
                    "6 - Изменить данные сотрудника в списке\n" +
                    "7 - Найти сотрудника с минимальной з/п\n" +
                    "8 - Найти сотрудника с максимальной з/п\n" +
                    "9 - Найти сотрудника с минимальной з/п (отдел)\n" +
                    "10 - Найти сотрудника с максимальной з/п (отдел)\n" +
                    "11 - Найти сотрудников с з/п меньше указанной\n" +
                    "12 - Найти сотрудников с з/п больше указанной\n" +
                    "13 - Найти среднюю з/п по всем сотрудникам\n" +
                    "14 - Найти среднюю з/п по всем сотрудникам (отдел)\n" +
                    "15 - Получить сумму з/п всех сотрудников\n" +
                    "16 - Получить сумму з/п всех сотрудников (отдел)\n" +
                    "17 - Проиндексировать з/п всех сотрудников в %\n" +
                    "18 - Проиндексировать з/п всех сотрудников в % (отдел)\n" +
                    "19 - Выход");

            System.out.print("Введите действие: ");
            switch (scanner.nextInt()) {
                case 1:
                    empBook.printEmployeeList();
                    continueProgram();
                    break;

                case 2:
                    System.out.print("Введите номер отдела: ");
                    department = scanner.nextInt();
                    empBook.printEmployeesByDepartment(department);
                    continueProgram();
                    break;

                case 3:
                    empBook.printAllEmployeesByDepartment();
                    continueProgram();
                    break;

                case 4:
                    System.out.println("\nВведите данные сотрудника: ");
                    System.out.print("Введите ФИО: ");
                    scanner.nextLine();
                    String employeeName = scanner.nextLine();

                    System.out.print("\nВведите отдел: ");
                    department = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("\nВведите зарплату: ");
                    salary = scanner.nextInt();
                    scanner.nextLine();

                    empBook.addNewEmployee(employeeName, department, salary);
                    continueProgram();
                    break;

                case 5:
                    empBook.deleteEmployee();
                    continueProgram();
                    break;

                case 6:
                    empBook.setEmployee();
                    continueProgram();
                    break;

                case 7:
                    empBook.findLowestSalary();
                    continueProgram();
                    break;

                case 8:
                    empBook.findHighestSalary();
                    continueProgram();
                    break;

                case 9:
                    System.out.print("Введите отдел: ");
                    department = scanner.nextInt();
                    empBook.findLowestSalaryByDepartment(department);
                    continueProgram();
                    break;

                case 10:
                    System.out.print("Введите отдел: ");
                    department = scanner.nextInt();
                    empBook.findHighestSalaryByDepartment(department);
                    continueProgram();
                    break;

                case 11:
                    System.out.print("Введите сумму: ");
                    salary = scanner.nextInt();
                    empBook.findSalaryLessThenValue(salary);
                    continueProgram();
                    break;

                case 12:
                    System.out.print("Введите сумму: ");
                    salary = scanner.nextInt();
                    empBook.findSalaryMoreThenValue(salary);
                    continueProgram();
                    break;

                case 13:
                    empBook.findAverageSalary();
                    continueProgram();
                    break;

                case 14:
                    System.out.print("Введите отдел: ");
                    department = scanner.nextInt();
                    empBook.findAverageSalaryByDepartment(department);
                    continueProgram();
                    break;

                case 15:
                    empBook.totalSalary();
                    continueProgram();
                    break;

                case 16:
                    System.out.print("Введите отдел: ");
                    department = scanner.nextInt();
                    empBook.totalSalaryByDepartment(department);
                    continueProgram();
                    break;

                case 17:
                    System.out.print("Введите процент индексации: ");
                    percent = scanner.nextDouble();
                    empBook.salaryIncreaseByPercent(percent);
                    continueProgram();
                    break;

                case 18:
                    System.out.print("Введите отдел: ");
                    department = scanner.nextInt();
                    System.out.print("Введите процент индексации: ");
                    percent = scanner.nextDouble();
                    empBook.salaryIncreaseByPercentByDepartment(department, percent);
                    continueProgram();
                    break;

                case 19:
                    exitProgram();
                    break;

                default:
                    System.out.println("Ошибка! Введите верный параметр!");
                    continueProgram();
                    break;
            }

        } while (!isCorrect);
    }

    public static void continueProgram(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nНажмите любую клавишу для продолжения... ");
        scanner.hasNextLine();
    }

    public static void exitProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВыйти из программы? [Yes/No] ");
        switch (scanner.nextLine()) {
            case "No":
                break;
            case "Yes":
                isCorrect = true;
                break;
            default:
                System.out.println("Ошибка");
                break;
        }
    }

}