public class PR4 {
    public static void main(String[] args) {
        int i = 2;
        switch(i) {
            case 2:
                System.out.print("Value is two.");
            case 2 + 1:
                System.out.println("Value is three.");
                break;
            default:
                System.out.println("Value is " + i);
                break;
        }
    }
}