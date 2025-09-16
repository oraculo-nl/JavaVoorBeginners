package java_vervolg;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Scanner;

class Something {
    int a, b, c, d;
}

public class ProfilerExample {
    public static void main(String[] args) {

        ArrayList<Object> objects = new ArrayList<Object>();

        while (true) {
            System.out.println("1 Fill Heap 2 Fill Heap & Non-Heap 3 Create threads");
            System.out.println("Enter your choice (1,2,3) and press Enter:");
            Scanner sc = new Scanner(System.in);
            var answer = sc.nextInt();
            if (answer == 1) {
                for (int i = 1; i <= 10000000; i++) {
                    objects.add(new Something());
                }
                System.out.println("Created 1 million objects");
            } else if (answer == 2) {
                for (int i = 1; i <= 1000; i++) {
                    ClassLoader loader = new ClassLoader() {
                    };
                    Object proxy = Proxy.newProxyInstance(
                            loader,
                            new Class[]{Runnable.class},
                            (o, m, a) -> null);
                    objects.add(proxy);
                }
                System.out.println("Created 1000 new Proxy classes");
                System.out.println("Aantal objects: " + objects.size());
            } else if (answer == 3) {
                for (int i = 1; i <= 1000; i++) {
                    Thread thread = new Thread(() -> {
                        while (true)
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                    });
                    thread.start();
                }
                System.out.println("Created 1000 threads");
                System.out.println("Aantal objects: " + objects.size());
            }

        }
    }
}
