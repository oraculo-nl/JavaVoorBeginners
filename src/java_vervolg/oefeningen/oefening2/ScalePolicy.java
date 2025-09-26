package java_vervolg.oefeningen.oefening2;


// package nl.school.shapes;

public enum ScalePolicy {
    DOUBLE(2.0),
    HALF(0.5),
    IDENTITY(1.0);

    private final double factor;

    ScalePolicy(double factor) {
        this.factor = factor;
    }

    public double factor() { return factor; }
}
