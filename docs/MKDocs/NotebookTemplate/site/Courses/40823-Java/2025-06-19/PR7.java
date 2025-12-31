public class PR7 {
    public static void main(String[] args) {
        try {
            int a = 10 / 0;
            System.out.println("No exception");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException occurred");
        } finally {
            System.out.println("Finally block executed");
        }
    }
}