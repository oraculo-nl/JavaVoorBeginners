package java_advanced.oefeningen.topic010203;

public class Main {
    public static void main(String[] args) {

        //voorbeeldgebruik AddressBook
        var book = new AddressBook<Person>()
                .add(new Person("Alice", 30, java.util.Optional.empty()))
                .add(new Person("Bob", 25, java.util.Optional.empty()))
                .filter(p -> p.name().startsWith("A"))
                .sorted(java.util.Comparator.comparing(oef.person.Person::name))
                .limit(1);

        var first = book.first().map(oef.person.Person::name).orElse("GEEN CONTACT");
        System.out.println(first);

        //voorbeeldgebruik ShopppingCart
        var cart = new ShoppingCart<Product>()
                .add(new Product("Boek", new java.math.BigDecimal("19.95")))
                .add(new Product("Pen", new java.math.BigDecimal("1.50")));

        var label = cart.mostExpensive()
                .map(p -> p.name() + " (€" + p.price() + ")")
                .orElse("Leeg of geen items");

        System.out.println("Totaal: €" + cart.total());
        System.out.println("Duurste: " + label);

    }

}
