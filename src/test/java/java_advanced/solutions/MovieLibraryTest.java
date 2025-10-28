package java_advanced.solutions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Voor deze tests wordt aangenomen dat er een type Movie bestaat met:
 * (String title, String genre, double rating, int length, int year)
 * en een MovieLibrary met de opdrachten zoals op de sheets.
 */
class MovieLibraryTest {


    private static Movie m(String t, String g, double r, int len, int y) {
        return new Movie(t, g, r, len, y);
    }

    private static MovieLibrary seeded() {
        MovieLibrary lib = new MovieLibrary();
        lib.addAll(List.of(
                m("Inception", "Sci-Fi", 8.8, 148, 2010),
                m("The Godfather", "Crime", 9.2, 175, 1972),
                m("Pulp Fiction", "Crime", 8.9, 154, 1994),
                m("The Shawshank Redemption", "Drama", 9.3, 142, 1994),
                m("The Dark Knight", "Action", 9.0, 152, 2008),
                m("Interstellar", "Sci-Fi", 8.6, 169, 2014),
                m("The Matrix", "Sci-Fi", 8.7, 136, 1999),
                m("Gladiator", "Action", 8.5, 155, 2000),
                m("Forrest Gump", "Drama", 8.8, 142, 1994),
                m("Fight Club", "Drama", 8.8, 139, 1999),
                m("Parasite", "Thriller", 8.6, 132, 2019),
                m("The Lion King", "Animation", 8.5, 88, 1994),
                m("Whiplash", "Drama", 8.5, 107, 2014),
                m("Toy Story", "Animation", 8.3, 81, 1995),
                m("Coco", "Animation", 8.4, 105, 2017),
                m("Joker", "Thriller", 8.4, 122, 2019),
                m("Titanic", "Romance", 7.9, 195, 1997),
                m("Avengers: Endgame", "Action", 8.4, 181, 2019),
                m("Black Panther", "Action", 7.3, 134, 2018),
                m("La La Land", "Musical", 8.0, 128, 2016),
                m("Mad Max: Fury Road", "Action", 8.1, 120, 2015),
                m("Frozen", "Animation", 7.4, 102, 2013),
                m("Dune", "Sci-Fi", 8.2, 155, 2021),
                m("The Irishman", "Crime", 7.9, 209, 2019),
                m("The Wolf of Wall Street", "Comedy", 8.2, 180, 2013),
                m("Shrek", "Animation", 7.9, 90, 2001),
                m("Gravity", "Sci-Fi", 7.7, 91, 2013),
                m("The Social Network", "Drama", 7.7, 120, 2010),
                m("Guardians of the Galaxy", "Action", 8.0, 121, 2014),
                m("Up", "Animation", 8.3, 96, 2009)
        ));
        return lib;
    }

    @Test
    void add_addAll_ignoreNull_and_all_isDefensive() {
        MovieLibrary lib = new MovieLibrary();
        lib.add(null);
        lib.addAll(null);
        lib.addAll(Arrays.asList(m("X", "Y", 7.0, 100, 2000), null));

        var all = lib.all();
        assertEquals(1, all.size());
        assertThrows(UnsupportedOperationException.class, () -> all.add(m("Z", "Y", 7, 100, 2000)));
    }

    @Test
    void titlesSorted_caseInsensitive() {
        var lib = seeded();
        var titles = lib.titlesSorted();
        assertFalse(titles.isEmpty());
        // controleer dat alfabetische orde plausibel is
        var sortedCopy = titles.stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());
        assertEquals(sortedCopy, titles);
        assertThrows(UnsupportedOperationException.class, () -> titles.add("NEW"));
    }

    @Test
    void byGenre_exact_caseInsensitive_emptyOnNoMatch() {
        var lib = seeded();
        var scifi = lib.byGenre("sCi-Fi");
        assertTrue(scifi.stream().allMatch(m -> m.genre().equalsIgnoreCase("Sci-Fi")));
        assertTrue(lib.byGenre("NonExistingGenre").isEmpty());
    }

    @Test
    void anyHighRated_threshold_inclusive() {
        var lib = seeded();
        assertTrue(lib.anyHighRated(9.3)); // Shawshank 9.3
        assertTrue(lib.anyHighRated(9.0)); // The Dark Knight 9.0
        assertFalse(lib.anyHighRated(9.4));
    }

    @Test
    void averageRating_zeroWhenEmpty() {
        var empty = new MovieLibrary();
        assertEquals(0.0, empty.averageRating(), 1e-9);

        var lib = seeded();
        double avg = lib.averageRating();
        assertTrue(avg > 0 && avg < 10);
    }

    @Test
    void topNLongest_descByLength_thenTitleAsc_caseInsensitive() {
        var lib = seeded();
        // pak top 3 langste films
        var top3 = lib.topNLongest(3);
        assertEquals(3, top3.size());
        // controleer aflopende lengte
        assertTrue(top3.get(0).length() >= top3.get(1).length());
        assertTrue(top3.get(1).length() >= top3.get(2).length());
    }

    @Test
    void uniqueGenres_caseInsensitive_sorted() {
        var lib = seeded();
        var genres = lib.uniqueGenres();
        assertTrue(genres.containsAll(List.of("Action", "Drama", "Sci-Fi", "Animation", "Crime", "Thriller", "Romance", "Comedy", "Musical")));
        var sortedCopy = genres.stream().sorted(String.CASE_INSENSITIVE_ORDER).toList();
        assertEquals(sortedCopy, genres);
    }

    @Test
    void countByGenre_groupsCaseInsensitive() {
        var lib = seeded();
        var map = lib.countByGenre();
        // uit de dataset zijn er meerdere Action, Sci-Fi, Drama etc.
        assertTrue(map.get("Action") >= 1);
        assertTrue(map.get("Sci-Fi") >= 1);
        assertTrue(map.get("Drama") >= 1);
        // keys moeten genormaliseerd (bijv. "Action", "Sci-Fi", ...)
        map.keySet().forEach(k -> assertFalse(k.isBlank()));
    }

    @Test
    void bestPerGenre_highestRating_thenShortest_thenTitle() {
        var lib = seeded();
        var best = lib.bestPerGenre();
        assertNotNull(best.get("Drama"));
        assertNotNull(best.get("Action"));
        // plausibiliteitscheck: beste Crime zou The Godfather of Pulp Fiction moeten zijn (beiden hoog),
        // en bij exact gelijke rating wint de kortste lengte en daarna titel. We checken alleen presence.
        assertTrue(List.of("The Godfather", "Pulp Fiction").contains(best.get("Crime").title()));
    }

    @Test
    void titlesByYearRange_inclusive_sorted() {
        var lib = seeded();
        var titles = lib.titlesByYearRange(1994, 1994); // veel 1994-titels in dataset
        assertFalse(titles.isEmpty());
        // alle titels moeten jaar 1994 hebben
        var all1994 = lib.all().stream()
                .filter(m -> m.year() == 1994)
                .map(Movie::title)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toList();
        assertEquals(all1994, titles);
    }

    @Test
    void totalWatchTimeOf_genreSum_caseInsensitive() {
        var lib = seeded();
        int actionTotal = lib.totalWatchTimeOf("ACTION");
        int recheck = lib.all().stream()
                .filter(m -> m.genre().equalsIgnoreCase("Action"))
                .mapToInt(Movie::length)
                .sum();
        assertEquals(recheck, actionTotal);
    }

    @Test
    void recommendations_minRating_and_maxLength_sortedByRatingDesc_thenLengthAsc() {
        var lib = seeded();
        var recs = lib.recommendations(8.5, 150);
        // alle voldoen aan filters:
        assertTrue(recs.stream().allMatch(t ->
                lib.all().stream().anyMatch(m -> m.title().equals(t) && m.rating() >= 8.5 && m.length() <= 150)
        ));
        // controleer sorteerorde aan de bron (haal de films terug):
        var films = recs.stream()
                .map(title -> lib.all().stream().filter(m -> m.title().equals(title)).findFirst().orElseThrow())
                .toList();
        for (int i = 1; i < films.size(); i++) {
            var a = films.get(i - 1);
            var b = films.get(i);
            if (Double.compare(a.rating(), b.rating()) == 0) {
                assertTrue(a.length() <= b.length());
            } else {
                assertTrue(a.rating() >= b.rating());
            }
        }
    }

    @Test
    void recommendations_filtersAndSorts_exactMatch_andUnmodifiable() {
        var lib = seeded();

        // Verwachte uitkomst objectief afleiden uit de brondata:
        double minRating = 8.5;
        int maxLength = 150;

        var expected = lib.all().stream()
                .filter(m -> m.rating() >= minRating && m.length() <= maxLength)
                .sorted(
                        Comparator.comparingDouble(Movie::rating).reversed()
                                .thenComparingInt(Movie::length)
                                .thenComparing(Movie::title, String.CASE_INSENSITIVE_ORDER)
                )
                .map(Movie::title)
                .toList(); // onwijzigbaar

        var recs = lib.recommendations(minRating, maxLength);

        // 1) Exacte gelijkheid (dus niet vacuüm-waar)
        assertEquals(expected, recs);

        // 2) Onwijzigbaar naar buiten
        assertThrows(UnsupportedOperationException.class, () -> recs.add("X"));
    }

    @Test
    void recommendations_returnsEmpty_whenNoMatches() {
        var lib = seeded();
        var recs = lib.recommendations(9.99, 10); // praktisch geen film haalt dit
        assertTrue(recs.isEmpty());
    }


    @Test
    void searchTokensToTitles_flatMap_distinct_containsAnyToken_caseInsensitive() {
        var lib = seeded();
        var tokens = List.of(
                List.of(" dark ", " king"),
                List.of("MATRIX", "endgame"),
                Arrays.asList("  ", null)
        );
        var titles = lib.searchTokensToTitles(tokens);
        // Bevat titels met een van de tokens als substring (case-insensitive)
        assertTrue(titles.stream().anyMatch(t -> t.equals("The Dark Knight")));
        assertTrue(titles.stream().anyMatch(t -> t.equals("The Lion King")));
        assertTrue(titles.stream().anyMatch(t -> t.equals("The Matrix")));
        assertTrue(titles.stream().anyMatch(t -> t.equals("Avengers: Endgame")));
        // gesorteerd alfabetisch (case-insensitive)
        var sortedCopy = titles.stream().sorted(String.CASE_INSENSITIVE_ORDER).toList();
        assertEquals(sortedCopy, titles);
        // uniek
        assertEquals(new HashSet<>(titles).size(), titles.size());
    }

}
