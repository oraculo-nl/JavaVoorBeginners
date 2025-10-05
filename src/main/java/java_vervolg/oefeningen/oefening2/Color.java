package java_vervolg.oefeningen.oefening2;


// package nl.school.shapes;

public enum Color {
    RED("Red", "#FF0000"),
    GREEN("Green", "#00FF00"),
    BLUE("Blue", "#0000FF"),
    BLACK("Black", "#000000"),
    WHITE("White", "#FFFFFF");

    private final String label;
    private final String hex;

    Color(String label, String hex) {
        this.label = label;
        this.hex = hex;
    }

    public String label() { return label; }
    public String hex() { return hex; }
}
