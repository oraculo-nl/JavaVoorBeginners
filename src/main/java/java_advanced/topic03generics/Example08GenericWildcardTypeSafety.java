package java_advanced.topic03generics;

import java.util.*;

public class Example08GenericWildcardTypeSafety {


    //Dankzij ? kan de methode printList met elke lijst
    // werken (List<String>, List<Integer>, enz.),
    //maar de compiler verhindert dat je er verkeerde types inschuift.
    static void printList(List<?> list) {
        // list.add("Charlie"); //compiler error!
        for (Object o : list) {
            System.out.println(o);  // lezen mag wel
        }
    }


    public static void main(String[] args) {

        //zonder wildcard
        // Hier kan je alles erin stoppen (String, Integer, etc.).
        // Type safety is zwak.

        List<Object> list = new ArrayList<>();
        list.add("Hello");
        list.add(123);   // compiler vindt dit prima

        for (Object o : list) {
            System.out.println(o);
        }

        // met wildcard

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");

        printList(names);

    }


}

