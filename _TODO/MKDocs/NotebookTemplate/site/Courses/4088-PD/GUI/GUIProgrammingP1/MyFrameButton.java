import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrameButton extends JFrame {
    public MyFrameButton() {
        this.setTitle("MyFrame Title");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton b = new JButton("hello");
        this.add(b);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrameButton();
    }
}