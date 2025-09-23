package java_advanced;

@FunctionalInterface
interface InterfaceHello {
    void sayHello();
}


public class Example01FunctionalInterface {
    InterfaceHello h = () -> System.out.println("Hello World!");
    public static void main(String[] args) {
        Example01FunctionalInterface e = new Example01FunctionalInterface();
        e.h.sayHello();
    }


}