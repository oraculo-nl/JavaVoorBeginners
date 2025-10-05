package java_advanced.solutions;


import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ShoppingCart<T extends Item> {
    private final List<T> items = new ArrayList<>();

    public ShoppingCart<T> add(T item) {
        items.add(Objects.requireNonNull(item));
        return this;
    }

    public ShoppingCart<T> remove(String name) {
        items.removeIf(i -> Objects.equals(i.name(), name));
        return this;
    }

    public ShoppingCart<T> clear() {
        items.clear();
        return this;
    }

    public BigDecimal total() {
        return items.stream()
                .map(Item::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Optional<T> mostExpensive() {
        return items.stream()
                .max(Comparator.comparing(Item::price));
    }

    public Optional<T> findByName(String name) {
        return items.stream()
                .filter(i -> Objects.equals(i.name(), name))
                .findFirst();
    }

    // (optioneel) voor debug/demo:
    @Override
    public String toString() {
        return items.stream().map(Item::name).collect(Collectors.joining(", "));
    }
}
