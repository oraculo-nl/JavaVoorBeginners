package java_advanced.solutions;


import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieLibraryCsvTest {

    @Test
    void readCsv_parsesValid_skipsInvalid() throws Exception {
        // Maak tijdelijk CSV-bestand (UTF-8, ;-gescheiden, geen header)
        Path tmp = Files.createTempFile("movies", ".csv");
        Files.writeString(tmp, String.join(System.lineSeparator(),
                "Inception;Sci-Fi;8.8;148;2010",
                "BadLineWithTooFewColumns",
                "Toy Story;Animation;8.3;81;1995",
                "NotANumber;Sci-Fi;NAN;120;2010",         // ongeldige rating -> moet overslaan
                "Up;Animation;8.3;96;2009"
        ));

        var movies = MovieLibrary.readCsv(tmp); // verwacht: 3 geldige regels

        assertEquals(3, movies.size());
        var titles = movies.stream().map(Movie::title).toList();
        assertTrue(titles.containsAll(List.of("Inception", "Toy Story", "Up")));

        Files.deleteIfExists(tmp);
    }
}

