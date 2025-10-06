package java_advanced.topic04lambdas;

public class Example10LambdaThis {
    private String name = "OuterClass";

    public void run() {
        Runnable r1 = new Runnable() {      // anonieme klasse
            private String name = "AnonymousClass";

            @Override
            public void run() {
                System.out.println("Anonieme klasse this.name = " + this.name);
            }
        };

        Runnable r2 = () -> {               // lambda-expressie
            System.out.println("Lambda this.name = " + this.name);
        };

        r1.run();
        r2.run();
    }

    public static void main(String[] args) {
        new Example10LambdaThis().run();
    }
}
