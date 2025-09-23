package java_vervolg.part2;


/*
* Interface Segregation Principle (ISP)
* The idea in plain words
* Bad: a single big interface that forces classes to implement methods
* they don’t actually need.
* Good: split large interfaces into smaller, more focused ones,
*  so classes only depend on what they really use.
*
* */

public class Example23SplitInterface {
}

/*
Here Interface Machine is too big — it mixes printing, scanning, and faxing.
SimplePrinter is unhappy, because it doesn’t support scanning or faxing.
*/

interface Machine {
    void print();
    void scan();
    void fax();
}



class SimplePrinter implements Machine {
    @Override
    public void print() {
        System.out.println("Printing...");
    }

    // These methods don’t make sense for a simple printer,
    // but the class is forced to implement them!
    @Override
    public void scan() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void fax() {
        throw new UnsupportedOperationException("Not supported");
    }
}

/*
* Example with ISP applied
* */

interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

class SimplePrinter2 implements Printer {
    @Override
    public void print() {
        System.out.println("Printing...");
    }
}

class MultiFunctionPrinter implements Printer, Scanner, Fax {
    @Override
    public void print() { System.out.println("Printing..."); }

    @Override
    public void scan() { System.out.println("Scanning..."); }

    @Override
    public void fax() { System.out.println("Faxing..."); }
}
