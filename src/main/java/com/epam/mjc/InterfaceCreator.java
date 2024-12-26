package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String word : x) {
                if (!Character.isUpperCase(word.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> evenValues = new ArrayList<>();
            for (int number : x) {
                if (number % 2 == 0) {
                    evenValues.add(number);
                }
            }
            x.addAll(evenValues);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> correctString = new ArrayList<>();

            for (String sentence : values) {
                var words = sentence.split(" ");

                if ((Character.isUpperCase(sentence.charAt(0))) && (sentence.charAt(sentence.length() - 1) == '.') && words.length > 3) {
                    correctString.add(sentence);
                }
            }
            return correctString;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> stringSizeMap = new HashMap<>();

            for (String value : x) {
                stringSizeMap.put(value, value.length());
            }
            return stringSizeMap;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> combinedList = new ArrayList<>(list1);
            combinedList.addAll(list2);

            return combinedList;
        };
    }
}
