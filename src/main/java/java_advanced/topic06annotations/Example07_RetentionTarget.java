package java_advanced.topic06annotations;// Example07: Demonstrating @Retention and @Target
import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE) // discarded by compiler; not in .class
@Target(ElementType.FIELD)
@interface DocOnly {
    String info();
}

class Example07_RetentionTarget {
    @DocOnly(info = "This field is for documentation; annotation won't be in bytecode")
    int x = 42;

    public static void main(String[] args) {
        System.out.println("Run normally; @java_advanced.topic06annotations.DocOnly is SOURCE-only.");
    }
}