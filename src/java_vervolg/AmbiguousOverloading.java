package java_vervolg;

public class AmbiguousOverloading {

    void process(String x) {
        System.out.println("int");
    }

    void process(Integer x) {
        System.out.println("Integer");
    }

    public static void main(String[] args) {
        AmbiguousOverloading d = new AmbiguousOverloading();
        //uncomment the following lines to show compiler error due to ambiguity
//        d.process(null); // ???
//        d.process(null);
    }
}


