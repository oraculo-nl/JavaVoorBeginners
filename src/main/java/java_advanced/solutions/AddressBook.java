package java_advanced.solutions;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBook<T extends Contact> {
    private final List<T> source = new ArrayList<>();
    private final List<Predicate<T>> filters = new ArrayList<>();
    private Comparator<T> comparator;
    private Integer max;

    public AddressBook<T> add(T t) {
        source.add(Objects.requireNonNull(t));
        return this;
    }

    public AddressBook<T> filter(Predicate<T> p) {
        filters.add(Objects.requireNonNull(p));
        return this;
    }

    public AddressBook<T> sorted(Comparator<T> c) {
        this.comparator = Objects.requireNonNull(c);
        return this;
    }

    public AddressBook<T> limit(int n) {
        if (n < 0) throw new IllegalArgumentException("limit must be >= 0");
        this.max = n;
        return this;
    }

    public List<T> list() {
        Stream<T> s = source.stream();
        for (Predicate<T> f : filters) s = s.filter(f);
        if (comparator != null) s = s.sorted(comparator);
        if (max != null) s = s.limit(max);
        return s.collect(Collectors.toList());
    }

    public Optional<T> first() {
        Stream<T> s = source.stream();
        for (Predicate<T> f : filters) s = s.filter(f);
        if (comparator != null) s = s.sorted(comparator);
        return s.findFirst();
    }
}

