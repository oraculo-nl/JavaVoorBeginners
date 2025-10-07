package java_advanced.solutions;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        var m = new Movie("deer hunter", "drama", 8.5, 120, 2019);
        System.out.println(m.genre());

//        var l = List.of("", null);
//        System.out.println(l);

        var a = Arrays.asList(" ", null);
        System.out.println(a);

    }
}
