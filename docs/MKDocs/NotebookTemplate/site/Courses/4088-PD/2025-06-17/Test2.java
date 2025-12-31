import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Input an integer: ");
            String s = scanner.nextLine();
            try {
                int i = Integer.parseInt(s);
                System.out.println("i is: " + i);
            } catch(NumberFormatException e) {
                System.out.println("Wrong!");
            }
        }
    }
}