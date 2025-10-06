package java_advanced.topic03generics;

import java.util.function.BiFunction;

// Een class die BiFunction<Integer,Integer,Integer> implementeert
class Adder implements BiFunction<Integer, Integer, Integer> {
    @Override
    public Integer apply(Integer a, Integer b) {
        return a + b;
    }
}

public class Example03Bifunction {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = new Adder();

        int result = add.apply(5, 7); // 12
        System.out.println("Resultaat: " + result);
    }
}




