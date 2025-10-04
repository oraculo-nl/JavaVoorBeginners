package java_advanced.generics;

public class Example10TypeErasure {
    // source:
    // https://docs.oracle.com/javase/tutorial/java/generics/bridgeMethods.html
    static class Node<T> {

        public T data;

        public Node(T data) { this.data = data; }

        public void setData(T data) {
            System.out.println("Node.setData");
            this.data = data;
        }
    }

    static class IntegerNode extends Node<Integer> {
        public IntegerNode(Integer data) { super(data); }

        public void setData(Integer data) {
            System.out.println("MyNode.setData");
            super.setData(data);
        }
    }

    public static void main(String[] args) {
        IntegerNode integerNode = new IntegerNode(5);
        Node n = integerNode;            // A raw type - compiler throws an unchecked warning
//        n.setData("Hello");     // Causes a ClassCastException to be thrown.
        Integer x = integerNode.data;

    }
/*     the classcast exception seems to be caused by String -> Integer, but in reality it is
     from String -> Object -> Integer
     because the compiler also has generated a so called 'bridge method' which tries to handle your call n.setData()
     public void setData(Object o) {
            setData((Integer) o);   // cast inserted
     }
     */


}
