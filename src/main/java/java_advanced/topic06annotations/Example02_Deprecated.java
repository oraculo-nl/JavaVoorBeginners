package java_advanced.topic06annotations;

// Example02: Using @Deprecated to mark old APIs
class Example02_Deprecated {
    @Deprecated(since = "1.0", forRemoval = false)
    static void oldMethod() { System.out.println("Old method"); }

    static void newMethod() { System.out.println("New method"); }

    public static void main(String[] args) {
        // You may see a compiler warning here:
        oldMethod();
        newMethod();
    }
}