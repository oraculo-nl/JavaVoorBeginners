package java_advanced.topic06annotations;// Example06: Defining and using a simple custom annotation
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface Todo {
    String value();
    String owner() default "team";
}

@Todo(value = "Refactor this class", owner = "Alice")
class WorkInProgress {
    @Todo("Split into smaller methods")
    void doWork() {
        System.out.println("Working...");
    }
}

class Example06_CustomAnnotation {
    public static void main(String[] args) throws Exception {
        Todo classAnno = WorkInProgress.class.getAnnotation(Todo.class);
        System.out.println("Class TODO: " + classAnno.value() + " (owner=" + classAnno.owner() + ")");

        Todo methodAnno = WorkInProgress.class.getDeclaredMethod("doWork").getAnnotation(Todo.class);
        System.out.println("Method TODO: " + methodAnno.value());
    }
}