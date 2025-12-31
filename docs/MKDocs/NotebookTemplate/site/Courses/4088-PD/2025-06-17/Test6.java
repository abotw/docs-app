import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Input a positive integer: ");
            String s = scanner.nextLine();
            try {
                int i = Integer.parseInt(s);
                if (i <= 0) {
                    throw new Exception(i + " <= 0 !");
                }
                System.out.println("i is: " + i);
            } catch(Exception e) {
                System.out.println("Catch: " + e.getMessage());
            }
        }
    }
}