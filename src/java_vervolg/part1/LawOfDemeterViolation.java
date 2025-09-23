package java_vervolg.part1;

/**
 * Demeter was a major Greek goddess, sister to Zeus, who presided over the harvest,
 * fertility of the earth, and the sacred laws governing the cycle of life and death.
 *
 * The connection is through the name and the concept of "law". The ancient goddess
 * Demeter was a law-giver, and the modern Law of Demeter is a set of rules for
 * programming that keeps code manageable.
 */

public class LawOfDemeterViolation {
    public static void main(String[] args) {
        var order = new Order();
        var city = order.getCustomer().getAddress().getCity();
    }
}

class Order {
    Customer customer;
    Customer getCustomer() {return customer;}
}

class Customer {
    Address address;
    Address getAddress() {return address;}
}

class Address {
    City city;
    City getCity() {return city;}
}

class City {

}