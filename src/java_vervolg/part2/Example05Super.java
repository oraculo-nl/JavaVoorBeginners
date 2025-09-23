package java_vervolg.part2;



// Testklasse met main()
public class Example05Super {
    public static void main(String[] args) {

        // Superklasse
        class Animal {
            String name;

            // Constructor met parameter
            Animal(String name) {
                this.name = name;
                System.out.println("Animal constructor called: " + name);
            }
        }

        // Subklasse
        class Dog extends Animal {
            int age;

            // Constructor van Dog roept expliciet super() aan
            Dog(String name, int age) {
                super(name); // roept de Animal-constructor aan
                this.age = age;
                System.out.println("Dog constructor called: " + age + " years old");
            }

            void info() {
                System.out.println(name + " is " + age + " years old.");
            }
        }


        Dog d = new Dog("Buddy", 3);
        d.info();
    }
}

