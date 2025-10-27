package java_advanced.topic06annotations;// Example09: Type-use annotations (JSR 308)
import java.lang.annotation.*;

/*
 @Target(ElementType.TYPE_USE) tells Java this annotation can be used on any type, not
 just on declarations.
Such annotations are often used by static analysis tools (like Checker Framework, NullAway,
 SpotBugs, or IDEs) to enforce constraints like non-nullness, immutability, or taint checking
  at compile time.*/

@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
@interface NonNull {}

class Example09_TypeUse {
    @NonNull
    static String shout(@NonNull String s) { // annotate parameter and return type
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        @NonNull String msg = shout("hi");
        System.out.println(msg);
    }
}