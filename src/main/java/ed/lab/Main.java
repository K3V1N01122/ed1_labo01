package ed.lab;

public class Main {
    private static final ArrayGenerator<Integer> sortedArrayGenerator = length -> {
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = i + 1; // Ascendente
        }
        return array;
    };

    private static final ArrayGenerator<Integer> invertedArrayGenerator = length -> {
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = length - i; // Descendente
        }
        return array;
    };

    private static final ArrayGenerator<Integer> randomArrayGenerator = length -> {
        Integer[] array = new Integer[length];
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(length * 10); // Aleatorio
        }
        return array;
    };

    // Se asignan referencias a los métodos de SortingAlgorithms
    private static final QuickSort<Integer> highPivotQuickSort = SortingAlgorithms::highPivotQuickSort;
    private static final QuickSort<Integer> lowPivotQuickSort = SortingAlgorithms::lowPivotQuickSort;
    private static final QuickSort<Integer> randomPivotQuickSort = SortingAlgorithms::randomPivotQuickSort;

    public static void main(String[] args) {
        final SortingTester<Integer> tester = new SortingTester<>();

        System.out.println("Ordenando un arreglo ordenado:");
        tester.testSorting(sortedArrayGenerator, highPivotQuickSort, "Último elemento como pivote");
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort, "Primer elemento como pivote");
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort, "Elemento aleatorio como pivote");
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido:");
        tester.testSorting(invertedArrayGenerator, highPivotQuickSort, "Último elemento como pivote");
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort, "Primer elemento como pivote");
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort, "Elemento aleatorio como pivote");
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio:");
        tester.testSorting(randomArrayGenerator, highPivotQuickSort, "Último elemento como pivote");
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort, "Primer elemento como pivote");
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort, "Elemento aleatorio como pivote");
        System.out.println("================================");
    }
}
