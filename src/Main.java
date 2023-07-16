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

        // удаление сотрудника по имени
        empBook.deleteEmployeeByName("Иванов Иван Иванович");
        empBook.printEmployeeList();

        // удаление сотрудника по ID
        empBook.deleteEmployeeByID(9);
        empBook.printEmployeeList();

        // добавление нового сотрудника
        empBook.addNewEmployee("Тарасов Максим Дмитриевич", 4, 200000);
        empBook.printEmployeeList();

    }

}