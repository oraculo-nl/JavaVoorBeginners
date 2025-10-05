package java_advanced.oefeningen.topic010203;

import java.util.*;
import java.util.function.Predicate;

public class AddressBook<T extends Contact> {
    private final List<T> source = new ArrayList<>();
    private final List<Predicate<T>> filters = new ArrayList<>();
    private Comparator<T> comparator;
    private Integer max;

    public AddressBook<T> add(T t) { /* source.add(t); return this; */
        return this;
    }

    public AddressBook<T> filter(Predicate<T> p) { /* TODO; return this; */
        return this;
    }

    public AddressBook<T> sorted(Comparator<T> c) { /* TODO; return this; */
        return this;
    }

    public AddressBook<T> limit(int n) { /* TODO; return this; */
        return this;
    }

    public java.util.List<T> list() { /* TODO: apply filters, sort, limit */
        return java.util.List.of();
    }

    public java.util.Optional<T> first() { /* TODO: gebruik Optional */
        return java.util.Optional.empty();
    }

}
