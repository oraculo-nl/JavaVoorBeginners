package java_advanced.topic05streams;

import java.util.stream.IntStream;

public class Example04ParallelStreams {

    public static void main(String[] args) {
        int N = 5_000_000;

        // --- 1) Sequentieel: som van kwadraten 1..N ---
        long t1 = System.nanoTime();
        long sumSeq = IntStream.rangeClosed(1, N)
                .mapToLong(x -> (long) x * x)   // voorkom int-overflow
                .sum();
        long t2 = System.nanoTime();

        // --- 2) Parallel: zelfde berekening, maar parallel ---
        long t3 = System.nanoTime();
        long sumPar = IntStream.rangeClosed(1, N)
                .parallel()                     // schakel parallel in
                .mapToLong(x -> (long) x * x)
                .sum();
        long t4 = System.nanoTime();

        System.out.println("Sequential sum  : " + sumSeq + "  in " + ms(t1, t2) + " ms");
        System.out.println("Parallel sum    : " + sumPar + "  in " + ms(t3, t4) + " ms");

        // --- 3) Voorbeeld: volgorde bewaren in parallel stream ---
        System.out.println("\nParallel print (onbepaald):");
        IntStream.rangeClosed(1, 10)
                .parallel()
                .forEach(i -> System.out.print(i + " "));     // volgorde kan door elkaar
        System.out.println("\nParallel print (geordend):");
        IntStream.rangeClosed(1, 10)
                .parallel()
                .forEachOrdered(i -> System.out.print(i + " ")); // volgorde gegarandeerd
    }

    private static long ms(long start, long end) {
        return (end - start) / 1_000_000;
    }
}

