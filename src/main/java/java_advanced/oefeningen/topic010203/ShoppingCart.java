package java_advanced.oefeningen.topic010203;

import java.math.BigDecimal;
import java.util.*;

public class ShoppingCart<T extends Item> {
    private final List<T> items = new ArrayList<>();

    public ShoppingCart<T> add(T item) { /* items.add(item); return this; */
        return this;
    }

    public ShoppingCart<T> remove(String name) { /* TODO; return this; */
        return this;
    }

    public ShoppingCart<T> clear() { /* items.clear(); return this; */
        return this;
    }

    public BigDecimal total() {
        // TODO: sommeer price() (denk aan BigDecimal.ZERO en add)
        return BigDecimal.ZERO;
    }

    public Optional<T> mostExpensive() {
        // TODO: max(Comparator.comparing(Item::price))
        return Optional.empty();
    }

    public Optional<T> findByName(String name) {
        // TODO: filter op naam, vind eerste
        return Optional.empty();
    }
}
