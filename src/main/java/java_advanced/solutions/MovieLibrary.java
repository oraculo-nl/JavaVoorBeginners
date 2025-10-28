package java_advanced.solutions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class MovieLibrary {

    private List<Movie> movies = new ArrayList<>();

    public void add(Movie movie) {
        if (movie != null)
            this.movies.add(movie);
    }

    public void addAll(Collection<Movie> movies) {
        if (movies != null)
            this.movies.addAll(movies.stream()
                    .filter(Objects::nonNull)
                    .toList());
    }

    public List<Movie> all() {
        return this.movies.stream()
                .toList();
    }

    public List<String> titlesSorted() {
        return this.movies.stream()
                .map(Movie::title)
                .sorted()
                .toList();
    }


    public List<Movie> byGenre(String genre) {
        return this.movies.stream()
                .filter(m -> m.genre()
                        .equals(genre))
                .toList();
    }

    public boolean anyHighRated(double threshold) {
        return this.movies.stream()
                .anyMatch(m -> m.rating() >= threshold);
    }

    public double averageRating() {
        return this.movies.stream()
                .mapToDouble(Movie::rating)
                .average()
                .orElse(0.0);
    }

    public List<Movie> topNLongest(int n) {
        if (n > 0) {
            return this.movies.stream()
                    .sorted(Comparator.comparing(Movie::length)
                            .reversed())
                    .limit(n)
                    .toList();
        }
        return Collections.unmodifiableList(new ArrayList<>());
    }

    public List<String> uniqueGenres() {
        return movies.stream()
                .map(Movie::genre)
                .distinct()
                .sorted()
                .toList();
    }

    public Map<String, Long> countByGenre() {
        return this.movies.stream()
                .collect(Collectors.groupingBy(Movie::genre, Collectors.counting()));
    }

    public Map<String, Movie> bestPerGenre() {
        var genres = uniqueGenres();
        Map<String, Movie> bestPerGenre = new HashMap<>();
        genres.forEach(g -> this.movies.stream()
                .filter(m -> m.genre()
                        .equalsIgnoreCase(g))
                .max(Comparator.comparing(Movie::rating))
                .ifPresent(m -> bestPerGenre.put(g, m)));
        return bestPerGenre;
    }

    public List<String> titlesByYearRange(int startYear, int endYear) {
        if (startYear <= endYear) {
            return this.movies.stream()
                    .filter(movie -> movie.year() >= startYear && movie.year() <= endYear)
                    .map(Movie::title)
                    .sorted()
                    .toList();
        }
        return new ArrayList<>();
    }

    public int totalWatchTimeOf(String genre) {
        return this.movies.stream()
                .filter(movie -> movie.genre()
                        .equalsIgnoreCase(genre))
                .mapToInt(movie -> movie.length())
                .sum();
    }

    public List<String> recommendations(double minRating, int maxLength) {

        return this.movies.stream().filter(movie -> movie.rating() >= minRating && movie.length() <= maxLength)
                .sorted(Comparator.comparing(Movie::title, String.CASE_INSENSITIVE_ORDER))
                .sorted(Comparator.comparing(Movie::length))
                .sorted(Comparator.comparing(Movie::rating).reversed())
                .map(Movie::title).toList();
    }


    public int size() {
        return this.movies.size();
    }

    public List<String> searchTokensToTitles(List<List<String>> tokens) {

        var validtokens = tokens.stream().flatMap(strings -> strings.stream())
                .filter(token -> token != null && !token.isBlank())
                .map(String::trim)
                .map(String::toLowerCase)
                .distinct()
                .toList();

        return this.movies.stream().filter(movie -> validtokens.stream().anyMatch(token -> movie.title().toLowerCase().contains(token)))
                .map(Movie::title).sorted().toList();


    }

    public static List<Movie> readCsv(Path path) {
        try (var lines = Files.lines(path)) {
            return lines.map(String::trim)
                    .filter(line -> !line.isBlank())
                    .map(line -> line.split(";"))
                    .filter(parts -> parts.length == 5)
                    .map(parts -> {
                        try {
                            return new Movie(
                                    parts[0],
                                    parts[1],
                                    Double.parseDouble(parts[2]),
                                    Integer.parseInt(parts[3]),
                                    Integer.parseInt(parts[4])
                            );
                        } catch (NumberFormatException e) {
                            return null;
                        }
                    })
                    .filter(movie -> movie != null)
                    .toList();
        } catch (Exception e) {
            return List.of();
        }
    }

}
