package java_vervolg.part1;


public class Example11LawOfDemeterViolation {
    public static void main(String[] args) {
        var order = new Order();

        //Law of Demeter-overtreding, want je vraagt het ene object
        // om een ander object om nóg een ander object te vragen → je
        // weet teveel van de interne structuur.
        var city = order.getCustomer().getAddress().getCity();

        //beter is
        var city2 = order.getCity();
    }
}

class Order {
    private Customer customer;
    Customer getCustomer() {return customer;}
    // delegatiemethode → verschuilt de ketting
    City getCity() {
        return customer.getCity();
    }
}

class Customer {
    Address address;
    Address getAddress() {return address;}
    City getCity() {return address.getCity();}
}

class Address {
    private City city;
    City getCity() {return city;}
}

class City {
    private String name;
}