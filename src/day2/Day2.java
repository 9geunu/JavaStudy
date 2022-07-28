package day2;

import day1.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day2 {
    public static void main(String[] args) {
        String[][] sample = new String[][]{
                {"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}, {"i", "j"}
        };

//        System.out.println(Arrays.deepToString(sample));

        List<String> list = new ArrayList<>(Arrays.asList("Foo", "Bar", "Bar", "Bar", "Foo"));
        Map<String, Long> result = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);

    }
}
