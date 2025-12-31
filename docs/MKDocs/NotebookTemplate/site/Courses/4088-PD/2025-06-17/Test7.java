import java.util.Scanner;

public class Test7 {
    public static void readPosInt() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a positive integer: ");
        String s = scanner.nextLine();
        int i = Integer.parseInt(s);
        if (i <= 0) {
            throw new Exception(i + " <= 0 !");
        }
        System.out.println("i is: " + i);
    }

    public static void main(String[] args) {
        while(true) {
            try {
                readPosInt();
            } catch(Exception e) {
                System.out.println("Catch: " + e.getMessage());
            }
        }
    }
}