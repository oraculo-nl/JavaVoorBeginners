package java_advanced.generics;

import java.util.ArrayList;

public class Test {

    static class Entry<T> {
        T value;
        //create constructor
        Entry(T value) {
            this.value = value;
        }
    }

    // using generics you can

    public static void main(String[] args) {
        ArrayList<Entry> list = new ArrayList<>();

        Entry<String> entry1 = new Entry("Tekst");
        Entry<Integer> entry2 = new Entry(123);

        list.add(entry1);
        list.add(entry2);

        for (Entry e : list) {
            System.out.println(e.value);
        }

    }
}
