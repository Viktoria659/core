package org.example.stream_api;

import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = List.of("a1", "a2", "a3", "a1");

//         К ол-во вхождений "a1"
        long count = list.stream()
                .filter("a1"::equals)
                .count();
        System.out.println(count);

//        Вернуть 1 эл-т коллекции или 0, если коллекция пуста
        System.out.println(list.stream()
                .findFirst()
                .orElse("0"));

//        Вернуть последний эл-т коллекции или "empty" если коллекция пуста
        System.out.println(list.stream()
                .skip(list.size() - 1L)
                .findFirst()
                .orElse("empty"));

//        Найти эл-т в коллекции равный "a3"
        System.out.println(list.stream()
                .filter("a3"::equals)
                .findAny()
                .get());

//        Вернуть 3 эл-т коллекции по порядку
        System.out.println(list.stream()
                .skip(2)
                .findFirst()
                .get());

//        Вернуть 2 элемента, начиная со 2-го
        System.out.println(list.stream()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList()));
    }
}
