public class DW {
    public static void main(String[] args) {
        int a = 1;
        do {
            System.out.println("Hi");
            a++; // move inside the loop
        } while (a <= 5); // condition is checked after first execution

        System.out.println("Java"); // will run after the loop ends
    }
}
