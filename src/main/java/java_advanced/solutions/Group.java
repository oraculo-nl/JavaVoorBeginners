package java_advanced.solutions;

import java.util.ArrayList;
import java.util.List;

public class Group<T extends Person> {
    private
    final List<T> members = new
            ArrayList<>();

    public void add(T member) {
        if (member == null) {
            throw new IllegalArgumentException();
        }
        members.add(member);
    }

    public boolean isEmpty() {
        return members.isEmpty();
    }

    public int size() {
        return members.size();
    }

    public T get(int index) {
        return members.get(index);
    }

    public void clear() {
        members.clear();
    }
}
