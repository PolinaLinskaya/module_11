package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersArray {
    public static String sortAndJoinNumbers(String[] inputArray) {
        List<Integer> numbers = new ArrayList<>();

        for (String input : inputArray) {
            List<Integer> currentNumbers = Arrays.stream(input.split(", "))
                    .map(Integer::parseInt)
                    .toList();
            numbers.addAll(currentNumbers);
        }

        numbers.sort(Integer::compareTo);

        String result = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        return result;
    }

    public static void main(String[] args) {
        String[] inputArray = {"1, 2, 0", "4, 5"};
        String sortedAndJoinedNumbers = sortAndJoinNumbers(inputArray);
        System.out.println(sortedAndJoinedNumbers);
    }
}

