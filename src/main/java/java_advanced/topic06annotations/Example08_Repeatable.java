package java_advanced.topic06annotations;// Example08: Repeatable annotations
import java.lang.annotation.*;
import java.util.Arrays;

@Repeatable(Tags.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tag {
    String value();
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tags {
    Tag[] value();
}

@Tag("util")
@Tag("fast")
@Tag("beta")
class Tool {}

class Example08_Repeatable {
    public static void main(String[] args) {
        Tag[] tags = Tool.class.getAnnotationsByType(Tag.class);
        System.out.println("java_advanced.topic06annotations.Tags: " + Arrays.toString(Arrays.stream(tags).map(Tag::value).toArray()));
    }
}