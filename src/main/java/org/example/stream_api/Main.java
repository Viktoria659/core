package org.example.stream_api;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> iterate = Stream.iterate(1, n -> n + 1)
                .limit(15);
        iterate.forEach(System.out::println);

        Stream.of("k1", "o2", "eerefds")
                .skip(1).
                forEach(System.out::println);

        IntStream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x < 300)
                .map(x -> x + 11)
                .limit(3)
                .forEach(System.out::println);

        List.of(120, 410, 85, 32, 314, 12)
                .parallelStream()
                .filter(x -> x > 10)
                .map(x -> x * 2)
                .forEach(System.out::print);

        System.out.println();

        System.out.println(IntStream.range(0, 10)
                .parallel()
                .map(x -> x * 10)
                .sum());
    }
}
