package java_vervolg.part2;

@FunctionalInterface
interface InterfaceHello {
    void sayHello();
}


public class Example24FunctionalInterface {
    InterfaceHello h = () -> System.out.println("Hello World!");
    public static void main(String[] args) {
        Example24FunctionalInterface e = new Example24FunctionalInterface();
        e.h.sayHello();
    }


}