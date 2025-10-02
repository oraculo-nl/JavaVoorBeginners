package java_advanced.generics;

public class Example05GenericExtends {
    // Een abstracte Entity-basis
    static abstract class Entity {
        private final int id;

        protected Entity(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    // Een concrete Entity
    static class User extends Entity {
        private final String name;

        public User(int id, String name) {
            super(id);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // Een generieke Repository die alleen Entities kan opslaan
    static class Repository<T extends Entity> {
        private final java.util.List<T> items = new java.util.ArrayList<>();

        public void add(T item) {
            items.add(item);
        }
        // In de generieke class mag je gewoon de members van
        // Entity gebruiken, ook al weet je verder niets over T
        public T findById(int id) {
            for (T item : items) {
                if (item.getId() == id) {
                    return item;
                }
            }
            return null; // niet gevonden
        }
    }

    public static void main(String[] args) {
        Repository<User> userRepo = new Repository<>();

        userRepo.add(new User(1, "Alice"));
        userRepo.add(new User(2, "Bob"));

        User u = userRepo.findById(2);
        System.out.println("Gevonden user: " + u.getName());
    }
}

