public class PR3 {
    public static void main(String[] args) {
        int x = 0,
            y = 4,
            z = 5;
        if (x > 2) {
            if (y < 5) {
                System.out.println("Message one");
            } else {
                System.out.println("Message two");
            }
        } else if (z > 5) {
            System.out.println("Message three");
        } else {
            System.out.println("Message four");
        }
    }
}