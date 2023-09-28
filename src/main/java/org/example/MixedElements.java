package org.example;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

public class MixedElements {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iteratorFirst = first.iterator();
        Iterator<T> iteratorSecond = second.iterator();

        Iterator<T> zippedIterator = new Iterator<T>() {
            boolean useFirst = true;

            @Override
            public boolean hasNext() {
                return iteratorFirst.hasNext() && iteratorSecond.hasNext();
            }

            @Override
            public T next() {
                if (useFirst) {
                    useFirst = false;
                    return iteratorFirst.next();
                } else {
                    useFirst = true;
                    return iteratorSecond.next();
                }
            }
        };

        return Stream.generate(() -> {
            if (zippedIterator.hasNext()) {
                return zippedIterator.next();
            } else {
                return null;
            }
        }).takeWhile(Objects::nonNull);
    }

    public static void main(String[] args) {
        Stream<Integer> firstStream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> secondStream = Stream.of(6, 7, 8, 9);

        Stream<Integer> zippedStream = zip(firstStream, secondStream);

        zippedStream.forEach(System.out::println);
    }
}

