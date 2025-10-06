package java_advanced.topic04lambdas;

@FunctionalInterface
interface InterfaceHello {
    void sayHello();
}


public class Example02FunctionalInterface {
    static InterfaceHello h = () -> System.out.println("Hello World!");

    public static void main(String[] args) {
        h.sayHello();
    }


}