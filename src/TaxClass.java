public class TaxClass {

    // Method Overloading - outside main
    void Tax() {
        System.out.println("Zero parameter");
    }

    void Tax(String ex) {
        System.out.println("Exchange");
    }

    void Tax(int t1, double per) {
        System.out.println("Based on the land");
    }

    void Tax(double yi, int gst) {
        System.out.println("Gst tax");
    }

    // Main method
    public static void main(String[] args) {
        TaxClass t = new TaxClass(); // create an object

        t.Tax();                     // calling the methods
        t.Tax("INR");
        t.Tax(10, 2.5);
        t.Tax(100000.0, 18);
    }
}

