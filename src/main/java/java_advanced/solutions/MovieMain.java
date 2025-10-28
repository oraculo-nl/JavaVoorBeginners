package java_advanced.solutions;

import java.nio.file.Path;
import java.util.List;

public class MovieMain {

    public static void main(String[] args) {
        try {
            // 1 Pad naar het CSV-bestand (pas aan indien nodig)
            Path path = Path.of("movies.csv");

            // 2 Lees de films in via de bonusmethode
            List<Movie> movies = MovieLibrary.readCsv(path);
            System.out.println("Aantal ingelezen films: " + movies.size());

            // 3 Maak de bibliotheek aan en vul deze
            MovieLibrary lib = new MovieLibrary();
            lib.addAll(movies);

            // 4 Voorbeeld: alle titels alfabetisch
            System.out.println("\nTitels alfabetisch:");
            lib.titlesSorted()
                    .forEach(System.out::println);

            // 5 Voorbeeld: top-3 langste films
            System.out.println("\nTop 3 langste films:");
            lib.topNLongest(3)
                    .forEach(m ->
                            System.out.printf("%s (%d min)%n", m.title(), m.length()));

            // 6 Gemiddelde rating
            System.out.printf("%nGemiddelde rating: %.2f%n", lib.averageRating());

            // 7 Genres en aantal films
            System.out.println("\nAantal films per genre:");
            lib.countByGenre()
                    .forEach((g, c) ->
                            System.out.printf("%s: %d%n", g, c));

            // 8 Beste film per genre
            System.out.println("\nBeste film per genre:");
            lib.bestPerGenre()
                    .forEach((g, m) ->
                            System.out.printf("%s → %s (%.1f)%n", g, m.title(), m.rating()));

            // 9 Aanbevelingen: rating ≥ 8.5, lengte ≤ 140 min
            System.out.println("\nAanbevolen films (rating ≥ 8.5, max 140 min):");
            lib.recommendations(8.5, 140)
                    .forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("Fout bij inlezen van CSV: " + e.getMessage());
        }
    }
}
