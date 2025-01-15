package org.example.stream_api;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> iterate = Stream.iterate(1, n -> n + 1)
                .limit(15);
        iterate.forEach(System.out::println);

        Stream.of("k1", "o2", "eerefds")
                .skip(1).
                forEach(System.out::println);
    }
}
