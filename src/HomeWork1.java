import java.util.Scanner;

/**
 * Создать подобие калькулятора, который будет реализовывать простые
 * операции с двумя числами. (Программа должны быть сделана с
 * “интерфейсом” в консоли)
 *
 * Ввод данных: на вход подается строка с примером (1 + 1),
 * необходимо разложить строку на элементы, и в зависимости от
 * введённого знака выбрать операцию. На входе подаются как
 * положительные, так и отрицательные числа.
 *
 * Пример строки на вход: "100 + 13", "27 * 3", "27 / 3", "6 !", "35 ? 24", "4 ^ 3", "6 - 3"
 *
 * Список операций - (сложение (+), вычитание (-), умножение (*),
 * деление (/), факториал (!), возведение в степень (^) и сравнение двух
 * чисел (?))
 *
 * В меню приложения должно предлагаться: ввести пример,
 * продолжить работать с ответом предыдущего примера и выход.
 *
 * @author     Sergey Nikolaev
 */

public class HomeWork1 {

    public static void main(String[] args) {
        Scanner scr;
        String string = "", temps;
        int tempi;
        boolean flag = true;
        while (true){
              System.out.println("\nВведите цифру, соответствующую пункту меню\n" +
                                "1. Ввести пример.\n" +
                                "2. Продолжить работать с предыдущим ответом.\n" +
                                "3. Выход.");
            scr = new Scanner(System.in);
            int answer = scr.nextInt();
            if (answer == 3) break;
            switch (answer) {
                case 1:
                    System.out.println("\nВведите строку с примером\n" +
                                            "Пример строки на вход: “100 + 13\", \"27 / 3\", \"7 !\", \"4 ^ 3\", \"35 ? 24\"");
                    scr = new Scanner(System.in);
                    if (flag) {
                        string = scr.nextLine();
                        if (string == null || string.isEmpty()) break;
                        else flag = false;
                    }
                    else {
                        temps = scr.nextLine();
                        if (temps == null || temps.isEmpty()) break;
                        else string += ", " + temps;
                    }
                    parser(string);
                    break;
                case 2:
                    if (flag) {
                        System.out.println("Недоступно! Так как нет предыдущего ответа.");
                    }
                    else {
                         String[] stringa = string.split(", ");
                         int number = stringa.length - 1;
                         stringa[number] = stringa[number].substring(1, stringa[number].length() - 1);
                         String[] action = stringa[number].split(" ");
                         if (action[1].equals("?")) {
                             System.out.println("Недоступно! Так как предыдущий ответ - сравнение.");
                             break;
                         }
                         System.out.println("1. Сложение\n" +
                                            "2. Вычитание\n" +
                                            "3. Умножение\n" +
                                            "4. Деление\n" +
                                            "5. Факториал\n" +
                                            "6. Возведение в степень\n" +
                                            "7. Сравнение\n" +
                                            "8. Назад");
                        scr = new Scanner(System.in);
                        tempi = scr.nextInt();
                        if (tempi < 1 || tempi > 7) break;
                        switch (tempi) {
                            case 1://+
                                System.out.println("Для сложения введите чило.\n" +
                                        "Первая часть примера с предыдущим ответом имеет вид: " + parserLastAnswer(string) + " +");
                                scr = new Scanner(System.in);
                                temps = scr.nextLine();
                                if (temps == null || temps.isEmpty()) break;
                                string += ", \"" + parserLastAnswer(string) + " + " + temps + "\"";
                                parser(string);
                                break;
                            case 2://-
                                System.out.println("Для вычитания введите число.\n" +
                                        "Первая часть примера с предыдущим ответом имеет вид: " + parserLastAnswer(string) + " -");
                                scr = new Scanner(System.in);
                                temps = scr.nextLine();
                                if (temps == null || temps.isEmpty()) break;
                                string += ", \"" + parserLastAnswer(string) + " - " + temps + "\"";
                                parser(string);
                                break;
                            case 3://*
                                System.out.println("Для умножения введите число.\n" +
                                        "Первая часть примера с предыдущим ответом имеет вид: " + parserLastAnswer(string) + " *");
                                scr = new Scanner(System.in);
                                temps = scr.nextLine();
                                if (temps == null || temps.isEmpty()) break;
                                string += ", \"" + parserLastAnswer(string) + " * " + temps + "\"";
                                parser(string);
                                break;
                            case 4:///
                                System.out.println("Для деления введите число.\n" +
                                        "Первая часть примера с предыдущим ответом имеет вид: " + parserLastAnswer(string) + " /");
                                scr = new Scanner(System.in);
                                temps = scr.nextLine();
                                if (temps == null || temps.isEmpty()) break;
                                string += ", \"" + parserLastAnswer(string) + " / " + temps + "\"";
                                parser(string);
                                break;
                            case 5://!
                                System.out.println("Факториал предыдущего ответа: " + parserLastAnswer(string) +" !");
                                string += ", \"" + parserLastAnswer(string) +" !" + "\"";
                                parser(string);
                                break;
                            case 6://^
                                System.out.println("Для возведения в степень введите число.\n" +
                                        "Первая часть примера с предыдущим ответом имеет вид: " + parserLastAnswer(string) + " ^");
                                scr = new Scanner(System.in);
                                temps = scr.nextLine();
                                if (temps == null || temps.isEmpty()) break;
                                string += ", \"" + parserLastAnswer(string) + " ^ " + temps + "\"";
                                parser(string);
                                break;
                            case 7://?
                                System.out.println("Для сравнения введите число.\n" +
                                        "Первая часть примера с предыдущим ответом имеет вид: " + parserLastAnswer(string) + " ?");
                                scr = new Scanner(System.in);
                                temps = scr.nextLine();
                                if (temps == null || temps.isEmpty()) break;
                                string += ", \"" + parserLastAnswer(string) + " ? " + temps + "\"";
                                parser(string);
                                break;
                        }
                    }
                    break;
            }
        }
        scr.close();
    }

    public static void parser(String stringp){
        String[] stringa = stringp.split(", ");
        for (int i = 0; i < stringa.length; i++) {
            stringa[i] = stringa[i].substring(1, stringa[i].length() - 1);
            System.out.print(stringa[i] + " = ");
            String[] action = stringa[i].split(" ");
            switch (action[1]) {
                case "+":
                    System.out.println(addition(action));
                    break;
                case "-":
                    System.out.println(subtraction(action));
                    break;
                case "*":
                    System.out.println(multiplication(action));
                    break;
                case "/":
                    System.out.println(division(action));
                    break;
                case "!":
                    System.out.println(factorial(action));
                    break;
                case "^":
                    System.out.println(exponentiation(action));
                    break;
                case "?":
                    comparison(action);
                    break;
            }
        }
    }
    public static int parserLastAnswer(String stringp){
        String[] stringa = stringp.split(", ");
        int number = stringa.length - 1;
        stringa[number] = stringa[number].substring(1, stringa[number].length() - 1);
        String[] action = stringa[number].split(" ");
        int result = 0;
        switch (action[1]) {
                case "+":
                    result = addition(action);
                    break;
                case "-":
                    result = subtraction(action);
                    break;
                case "*":
                    result = multiplication(action);
                    break;
                case "/":
                    result = division(action);
                    break;
                case "!":
                    result = factorial(action);
                    break;
                case "^":
                    result = exponentiation(action);
                    break;
        }
        return result;
    }
    public static int addition(String[] sa){
        return Integer.parseInt(sa[0]) + Integer.parseInt(sa[2]);
    }
    public static int subtraction(String[] sa){
        return Integer.parseInt(sa[0]) - Integer.parseInt(sa[2]);
    }
    public static int multiplication(String[] sa){
        return Integer.parseInt(sa[0]) * Integer.parseInt(sa[2]);
    }
    public static int division(String[] sa){
        return Integer.parseInt(sa[0]) / Integer.parseInt(sa[2]);
    }
    public static int factorial(String[] sa){
        int result = 1;
        for (int i = 1; i <= Integer.parseInt(sa[0]); i++) {
            result = result * i;
        }
        return result;
    }
    public static int exponentiation(String[] sa){
        int result = 1;
        for (int i = 1; i <= Integer.parseInt(sa[2]); i++) {
            result = result * Integer.parseInt(sa[0]);
        }
        return result;
    }
    public static void comparison(String[] sa){
        if (Integer.parseInt(sa[0]) > Integer.parseInt(sa[2])) System.out.println(sa[0] + " > " + sa[2]);
            else if (Integer.parseInt(sa[0]) < Integer.parseInt(sa[2])) System.out.println(sa[0] + " < " + sa[2]);
                    else System.out.println(sa[0] + " = " + sa[2]);
    }
}
