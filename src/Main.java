import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

       // EmployeeBook empBook = new EmployeeBook();

        action();

    }


    public static void action(){

        Scanner scanner = new Scanner(System.in);
        EmployeeBook empBook = new EmployeeBook();
        Main main = new Main();

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
        int department, salary, id;
        double percent;

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
                "18 - Проиндексировать з/п всех сотрудников в % (отдел)\n");

        System.out.println("Введите действие: ");
        switch (scanner.nextInt()){
            case 1:
                empBook.printEmployeeList();
                break;

            case 2:
                System.out.print("Введите номер отдела: ");
                department = scanner.nextInt();
                empBook.printEmployeesByDepartment(department);
                break;

            case 3:
                empBook.printAllEmployeesByDepartment();
                break;

            case 4:
                System.out.println("Введите данные сотрудника: ");
                System.out.print("Введите имя: ");
                name = scanner.nextLine();
                System.out.print("Введите отдел: ");
                department = scanner.nextInt();
                System.out.print("Введите зарплату: ");
                salary = scanner.nextInt();
                empBook.addNewEmployee(name, department, salary);
                break;

            case 5:
                System.out.println("Удалить сотрудника по: " +
                        "1 - Имени\n" +
                        "2 - ID");
                if (scanner.nextInt() == 1){
                    System.out.print("Введите имя: ");
                    name = scanner.nextLine();
                    empBook.deleteEmployeeByName(name);
                } else if (scanner.nextInt() == 2){
                    System.out.print("Введите ID: ");
                    id = scanner.nextInt();
                    empBook.deleteEmployeeByID(id);
                } else{
                    System.out.println("Ошибка! Введите корректный параметр!");
                }
                break;

            case 6:
                empBook.setEmployee();
                break;

            case 7:
                empBook.findLowestSalary();
                break;

            case 8:
                empBook.findHighestSalary();
                break;

            case 9:
                System.out.print("Введите отдел: ");
                department = scanner.nextInt();
                empBook.findLowestSalaryByDepartment(department);
                break;

            case 10:
                System.out.print("Введите отдел: ");
                department = scanner.nextInt();
                empBook.findHighestSalaryByDepartment(department);
                break;

            case 11:
                System.out.print("Введите сумму: ");
                salary = scanner.nextInt();
                empBook.findSalaryLessThenValue(salary);
                break;

            case 12:
                System.out.print("Введите сумму: ");
                salary = scanner.nextInt();
                empBook.findSalaryMoreThenValue(salary);
                break;

            case 13:
                empBook.findAverageSalary();
                break;

            case 14:
                System.out.print("Введите отдел: ");
                department = scanner.nextInt();
                empBook.findAverageSalaryByDepartment(department);
                break;

            case 15:
                empBook.totalSalary();
                break;

            case 16:
                System.out.print("Введите отдел: ");
                department = scanner.nextInt();
                empBook.totalSalaryByDepartment(department);
                break;

            case 17:
                System.out.print("Введите процент индексации: ");
                percent = scanner.nextDouble();
                empBook.salaryIncreaseByPercent(percent);
                break;

            case 18:
                System.out.print("Введите отдел: ");
                department = scanner.nextInt();
                System.out.print("Введите процент индексации: ");
                percent = scanner.nextDouble();
                empBook.salaryIncreaseByPercentByDepartment(department, percent);
                break;

            default:
                System.out.println("Ошибка! Введите верный параметр!");
                break;
        }
    }

}