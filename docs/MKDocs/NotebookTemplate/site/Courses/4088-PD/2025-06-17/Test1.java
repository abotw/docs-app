public class Test1 {
    public static void division(int i, int j) {
        System.out.print(i + " / " + j + " = ");
        int result = i / j;
        System.out.println(result);
    }

    public static void main(String[] args) {
        division(100, 4);
        division(100, 0); // ArithmeticException: / by zero
        System.out.println("End of main()");    // Unreachable
    }
}