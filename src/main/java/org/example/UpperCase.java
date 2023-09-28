package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UpperCase {
    public static List<String> formatAndSortStrings(List<String> inputStrings) {
        List<String> result = new ArrayList<>();

        for (String str : inputStrings) {
            result.add(str.toUpperCase());
        }

        Collections.sort(result, Collections.reverseOrder());

        return result;
    }

    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "Pasha", "Mykola", "Maria", "Daria");
        List<String> formattedAndSortedStrings = formatAndSortStrings(names);

        for (String str : formattedAndSortedStrings) {
            System.out.println(str);
        }
    }
}

