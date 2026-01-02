public class Test4 {
    public static void division(int i, int j) {
        int result = -1;
        try {
            result = i / j;
        } catch(Exception e) {  // Catches all exceptions!
            System.out.println("Wrong: " + e.getMessage());
        } catch(ArithmeticException e) {    // Unreachable code.
            System.out.println("Wrong: " + e.getMessage());
        } finally {
            System.out.println(i + " / " + j + " = " + result);
        }
    }

    public static void main(String[] args) {
        division(100, 4);
        division(100, 0); // ArithmeticException: / by zero
        System.out.println("End of main()");    // Unreachable
    }
}