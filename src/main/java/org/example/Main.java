package org.example;
import java.util.List;

public class Main {
    public static String formatNames(List<String> names) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            if (i % 2 == 0) { // Перевірка на непарний індекс
                if (result.length() > 0) {
                    result.append(", ");
                }
                result.append((i + 1) + ". " + names.get(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "Pasha", "Mykola", "Maria", "Daria");
        String formattedNames = formatNames(names);
        System.out.println(formattedNames);
    }
}
