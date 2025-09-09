package java_vervolg;

public record RecordExample(String name, String address) {
    public static void main(String[] args) {
        var r = new RecordExample("Jan", "Herenstraat 1");

        System.out.println(r);
    }
}
