package java_advanced.topic06annotations;// Example10: Parameter-level annotations with simple runtime check
import java.lang.annotation.*;
import java.lang.reflect.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Range {
    int min();
    int max();
}

class Calculator {
    @Range(min = 0, max = 100)
    int percent(int value) { return value; }
}

class Example10_ParameterAnnotation {
    static void inspect() throws Exception {
        Method m = Calculator.class.getDeclaredMethod("percent", int.class);
        Range r = m.getAnnotation(Range.class);
        System.out.println("@java_advanced.topic06annotations.Range on method: [" + r.min() + ", " + r.max() + "]");

        Annotation[][] pa = m.getParameterAnnotations();
        System.out.println("Parameter annotations length: " + pa[0].length);
    }

    public static void main(String[] args) throws Exception {
        inspect();
    }
}

/*
This example shows how to:
Define an annotation that can be used on both methods and parameters (@Target({METHOD, PARAMETER})).
Keep it available at runtime (@Retention(RUNTIME)).
Apply it to a method.
Read it reflectively using the Java Reflection API.*/
