import javax.swing.JFrame;

public class EmptyWindow {
    public static void main(String[] args) {
        JFrame f = new JFrame("Frame Title");
        f.setSize(400, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}