import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            // Создаем объект File для файла input.txt
            File file = new File("input.txt");

            // Создаем FileInputStream для чтения файла
            FileInputStream fileInputStream = new FileInputStream(file);

            // Создаем InputStreamReader для преобразования байтов в символы
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            // Создаем BufferedReader для чтения строки из файла
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Считываем введенную строку из файла
            String input = bufferedReader.readLine();

            // Закрываем потоки после чтения
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();

            // Разбиваем строку на части по пробелам
            String[] parts = input.split(" ");
            
            // Проверяем, что получили ровно 3 части (a, оператор, b)
            if (parts.length != 3) {
                System.out.println("Operation Error!");
                return;
            }

            try {
                // Парсим числа a и b из строк в тип double
                double a = Double.parseDouble(parts[0]);
                String operator = parts[1];
                double b = Double.parseDouble(parts[2]);

                double result = 0.0;

                // Выполняем операцию в зависимости от оператора
                switch (operator) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        // Проверяем деление на ноль
                        if (b == 0) {
                            System.out.println("Error! Division by zero");
                            return;
                        }
                        result = a / b;
                        break;
                    default:
                        System.out.println("Operation Error!");
                        return;
                }

                // Выводим результат
                System.out.println(result);
            } catch (NumberFormatException e) {
                // Обрабатываем ошибку, если одно из чисел не является числом
                System.out.println("Error! Not number");
            }
        } catch (IOException e) {
            // Обрабатываем ошибку, если не удалось прочитать файл
            System.out.println("Error! Failed to read file.");
        }
    }
}
