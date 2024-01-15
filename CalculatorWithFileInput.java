import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            File outputFile = new File("output.txt");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            FileWriter fileWriter = new FileWriter(outputFile);

            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                String resultString = processInputString(inputLine);
                fileWriter.write(inputLine + " = " + resultString + "\n");
            }

            bufferedReader.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error! Failed to read or write file.");
        }
    }

    private static String processInputString(String input) {
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            return "Error! Invalid operation";
        }

        try {
            double a = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double b = Double.parseDouble(parts[2]);

            switch (operator) {
                case "+":
                    return String.valueOf(a + b);
                case "-":
                    return String.valueOf(a - b);
                case "*":
                    return String.valueOf(a * b);
                case "/":
                    if (b == 0) {
                        return "Error! Division by zero";
                    }
                    return String.valueOf(a / b);
                default:
                    return "Error! Invalid operator";
            }
        } catch (NumberFormatException e) {
            return "Error! Not a number";
        }
    }
}
