package org.example.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<People> people = Arrays.asList(new People("Вася", 80, People.Sex.MAN),
                new People("Петя", 23, People.Sex.MAN),
                new People("Петя", 16, People.Sex.MAN),
                new People("Елена", 42, People.Sex.WOMEN),
                new People("Иван Иванович", 69, People.Sex.MAN),
                new People("Вася", 16, People.Sex.MAN));

//      Выбрать мужчин призывного возраста (от 18 до 27)
        List<People> list1 = people.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() <= 27
                        && person.getSex().equals(People.Sex.MAN))
                .collect(Collectors.toList());
        System.out.println(list1);

//      Найти средний возраст мужчин
        OptionalDouble average = people.stream()
                .filter(p -> p.getSex().equals(People.Sex.MAN))
                .mapToInt(People::getAge)
                .average();
        System.out.println(average);
        System.out.println();

//      Найти кол-во людей условно трудоспособного возраста(женщины - от 18 до 55, мужчины - 18-60)
        people.stream()
                .filter(p -> p.getAge() >= 18)
                .filter(person -> (person.getAge() <= 55 && person.getSex().equals(People.Sex.WOMEN))
                        || (person.getAge() <= 60 && person.getSex().equals(People.Sex.MAN)))
                .forEach(System.out::println);
        System.out.println();

//      Отсортировать по имени
        people.stream()
                .sorted(new PeopleNameComparator())
                .forEach(System.out::println);
        System.out.println();

//      Отсортировать по возрасту
        people.stream()
                .sorted(new PeopleAgeComparator())
                .forEach(System.out::println);
        System.out.println();

//      Отсортировать по имени и по возрасту
        people.stream()
                .sorted(new PeopleAgeComparator().thenComparing(new PeopleNameComparator()))
                .forEach(System.out::println);
    }
}