public class Test5 {
    public static void division(int i, int j) {
        int result = -1;
        try {
            result = i / j;
        } catch(ArithmeticException e) {
            System.out.println("Wrong: " + e.getMessage());
            e.printStackTrace;
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