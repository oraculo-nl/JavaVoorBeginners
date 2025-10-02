package java_advanced.generics;

@FunctionalInterface
interface InterfaceHello {
    void sayHello();
}


public class aExample01FunctionalInterface {
    InterfaceHello h = () -> System.out.println("Hello World!");
    public static void main(String[] args) {
        aExample01FunctionalInterface e = new aExample01FunctionalInterface();
        e.h.sayHello();
    }


}