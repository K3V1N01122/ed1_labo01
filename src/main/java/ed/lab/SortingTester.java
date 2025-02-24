package ed.lab;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingTester<T extends Comparable<T>> {
    private static final int ARRAY_SIZE = 1000; // Reducido de 10000 a 1000
    private static final int TEST_SIZE = 100; // Reducido de 1000 a 100

    public void testSorting(ArrayGenerator<T> generator, QuickSort<T> quickSort, String methodDescription) {
        T[] array = generator.generate(ARRAY_SIZE);

        List<Duration> durations = new ArrayList<>(TEST_SIZE);

        for (int i = 0; i < TEST_SIZE; i++) {
            T[] copy = Arrays.copyOf(array, array.length);
            Instant start = Instant.now();

            quickSort.sort(copy);

            Instant end = Instant.now();
            durations.add(Duration.between(start, end));
        }

        double average = durations.stream()
                .mapToLong(Duration::toMillis)
                .average()
                .orElse(0);

        long sum = durations.stream()
                .mapToLong(Duration::toMillis)
                .sum();

        System.out.printf("\t[%s] Tiempo promedio: %.2f ms\n", methodDescription, average);
        System.out.printf("\t[%s] Sumatoria de tiempo: %d ms\n", methodDescription, sum);
    }
}
