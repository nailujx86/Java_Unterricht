package woche_6;

import java.util.Random;

public class StreamsTest {
    public static void main(String[] args) {
        Random random = new Random();
        // random.ints().limit(10).forEach(System.out::println);
        random.ints().limit(2).map(a -> Math.abs(a)).reduce((a, b) -> a + b).stream().forEach(System.out::println);
    }
}