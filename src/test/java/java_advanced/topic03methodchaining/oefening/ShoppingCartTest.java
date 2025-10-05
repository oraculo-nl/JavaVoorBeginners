package java_advanced.topic03methodchaining.oefening;


import java_advanced.oefeningen.topic010203.Item;
import java_advanced.oefeningen.topic010203.ShoppingCart;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingCartTest {

    // Testhelper (alleen in test)
    record Product(String name, BigDecimal price) implements Item {
    }

    @Test
    void add_remove_clear_chainet_en_doet_wat_het_belooft() {
        ShoppingCart<Product> cart = new ShoppingCart<>();

        Product boek = new Product("Boek", new BigDecimal("19.95"));
        Product pen = new Product("Pen", new BigDecimal("1.50"));

        assertThat(cart.add(boek)).isSameAs(cart);
        assertThat(cart.add(pen)).isSameAs(cart);

        assertThat(cart.total()).isEqualByComparingTo("21.45");

        assertThat(cart.remove("Pen")).isSameAs(cart);
        assertThat(cart.total()).isEqualByComparingTo("19.95");

        assertThat(cart.clear()).isSameAs(cart);
        assertThat(cart.total()).isEqualByComparingTo("0.00");
    }

    @Test
    void mostExpensive_en_findByName_gebruiken_Optional() {
        ShoppingCart<Product> cart = new ShoppingCart<>();
        cart.add(new Product("Boek", new BigDecimal("10.00")))
                .add(new Product("Laptop", new BigDecimal("899.00")))
                .add(new Product("Muis", new BigDecimal("25.00")));

        assertThat(cart.mostExpensive())
                .isPresent()
                .get()
                .extracting(Product::name)
                .isEqualTo("Laptop");

        assertThat(cart.findByName("Muis")).isPresent();
        assertThat(cart.findByName("Onbekend")).isEmpty();
    }
}
