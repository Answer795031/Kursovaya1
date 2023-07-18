import java.util.Scanner;

public class Main {
    static boolean isExit;

    public static void main(String[] args) {

        System.out.println("\nДобро пожаловать в систему учета персонала!\n");

        action(); // вызов меню

    }


    public static void action() {
        /*
        Метод описывает меню программы для удобного вызова методов из EmployeeBook
        Завернуто в цикл do-while, условием завершения является метод exitProgram, который можно вызвать по желанию.
        */

        Scanner scanner = new Scanner(System.in);
        EmployeeBook empBook = new EmployeeBook(); // создаем экземпляр класса EmployeeBook

        int choice;

        do {

            System.out.println("Доступные действия:\n" +
                    "1 - Вывести список сотрудников\n" +                            // printEmployeeList()
                    "2 - Вывести список сотрудников (отдел)\n" +                    // printEmployeesByDepartment()
                    "3 - Вывести список сотрудников (все отделы)\n" +               // printAllEmployeesByDepartment()
                    "4 - Добавить нового сотрудника\n" +                            // addNewEmployee()
                    "5 - Удалить сотрудника\n" +                                    // deleteEmployee()
                    "6 - Изменить данные сотрудника в списке\n" +                   // empBook.setEmployee()
                    "7 - Найти сотрудника с минимальной з/п\n" +                    // findLowestSalary()
                    "8 - Найти сотрудника с максимальной з/п\n" +                   // findHighestSalary()
                    "9 - Найти сотрудника с минимальной з/п (отдел)\n" +            // findLowestSalaryByDepartment()
                    "10 - Найти сотрудника с максимальной з/п (отдел)\n" +          // findHighestSalaryByDepartment()
                    "11 - Найти сотрудников с з/п меньше указанной\n" +             // findSalaryLessThenValue()
                    "12 - Найти сотрудников с з/п больше указанной\n" +             // findSalaryMoreThenValue()
                    "13 - Найти среднюю з/п по всем сотрудникам\n" +                // findAverageSalary()
                    "14 - Найти среднюю з/п по всем сотрудникам (отдел)\n" +        // findAverageSalaryByDepartment()
                    "15 - Получить сумму з/п всех сотрудников\n" +                  // totalSalary()
                    "16 - Получить сумму з/п всех сотрудников (отдел)\n" +          // totalSalaryByDepartment()
                    "17 - Проиндексировать з/п всех сотрудников в %\n" +            // salaryIncreaseByPercent()
                    "18 - Проиндексировать з/п всех сотрудников в % (отдел)\n" +    // salaryIncreaseByPercentByDepartment()
                    "19 - Выход");

            System.out.print("Введите действие: ");

            // проверка на соответствие введенного числа типу int
            // в случае несоответствия, просит ввести число повторно, не краша программу
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка! Введите число");
                continueProgram();
                action();   // рекурсия
            }

            choice = Integer.parseInt(scanner.next());
            scanner.nextLine();

            // меню реализовано через switch-case. Последним номером выход из проги
            switch (choice) {
                case 1:
                    // Вывести список сотрудников

                    empBook.printEmployeeList();
                    continueProgram();
                    break;

                case 2:
                    // Вывести список сотрудников в отделе

                    empBook.printEmployeesByDepartment();
                    continueProgram();
                    break;

                case 3:
                    // Вывести список сотрудников во всех отделах

                    empBook.printAllEmployeesByDepartment();
                    continueProgram();
                    break;

                case 4:
                    // Добавить нового сотрудника

                    empBook.addNewEmployee();
                    continueProgram();
                    break;

                case 5:
                    // Удалить сотрудника - в методе есть выбор: удалить по ФИО или по ID

                    empBook.deleteEmployee();
                    continueProgram();
                    break;

                case 6:
                    // Изменить существующую запись сотрудника (отдел / зарплата)

                    empBook.setEmployee();
                    continueProgram();
                    break;

                case 7:
                    // Найти сотрудника с минимальной зарплатой

                    empBook.findLowestSalary();
                    continueProgram();
                    break;

                case 8:
                    // Найти сотрудника с максимальной зарплатой

                    empBook.findHighestSalary();
                    continueProgram();
                    break;

                case 9:
                    // Найти сотрудника с минимальной зарплатой в отделе

                    empBook.findLowestSalaryByDepartment();
                    continueProgram();
                    break;

                case 10:
                    // Найти сотрудника с максимальной зарплатой в отделе

                    empBook.findHighestSalaryByDepartment();
                    continueProgram();
                    break;

                case 11:
                    // Найти всех сотрудников с зарплатой меньше указанного значения

                    empBook.findSalaryLessThenValue();
                    continueProgram();
                    break;

                case 12:
                    // Найти всех сотрудников с зарплатой больше указанного значения

                    empBook.findSalaryMoreThenValue();
                    continueProgram();
                    break;

                case 13:
                    // Найти средний размер зарплаты среди всех сотрудников

                    empBook.findAverageSalary();
                    continueProgram();
                    break;

                case 14:
                    // Найти средний размер зарплаты среди всех сотрудников в отделе

                    empBook.findAverageSalaryByDepartment();
                    continueProgram();
                    break;

                case 15:
                    // Найти сумму затрат на зарплаты сотрудникам

                    empBook.totalSalary();
                    continueProgram();
                    break;

                case 16:
                    // Найти сумму затрат на зарплаты сотрудникам в отделе

                    empBook.totalSalaryByDepartment();
                    continueProgram();
                    break;

                case 17:
                    // Проиндексировать зарплаты всех сотрудников на указанный процент

                    empBook.salaryIncreaseByPercent();
                    continueProgram();
                    break;

                case 18:
                    // Проиндексировать зарплаты всех сотрудников в отделе на указанный процент

                    empBook.salaryIncreaseByPercentByDepartment();
                    continueProgram();
                    break;

                case 19:
                    // Выйти из программы

                    exitProgram();
                    break;

                default:
                    // Если вбили число, которого нет в меню

                    System.out.println("Ошибка! Введите верный параметр!");
                    continueProgram();
                    break;
            }

        } while (!isExit); // условие продолжения цикла. Может быть изменено только в методе exitProgram (пункт 19 меню)
    }

    public static void continueProgram() {
        // Метод, отвечающий за индикацию завершения работы очередного метода, после чего происходит возврат в меню
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nНажмите любую клавишу для продолжения... ");
        scanner.hasNextLine();
    }

    public static void exitProgram() {
        // Метод, позволяющий завершить программу - меняет состояние условия продолжения цикла меню
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВыйти из программы? [Yes/No] ");
        switch (scanner.nextLine()) {
            case "No":
                break;
            case "Yes":
                isExit = true;
                break;
            default:
                System.out.println("Ошибка!");
                exitProgram(); // рекурсия
                break;
        }
    }
}