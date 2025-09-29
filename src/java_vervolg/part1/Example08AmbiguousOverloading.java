package java_vervolg.part1;

public class Example08AmbiguousOverloading {

    void process(String x) {
        System.out.println("int");
    }

    void process(Integer x) {
        System.out.println("Integer");
    }

    public static void main(String[] args) {
        Example08AmbiguousOverloading d = new Example08AmbiguousOverloading();
        //uncomment the following lines to show compiler error due to ambiguity
//        d.process(null); // ???
//        d.process(null);
    }
}


