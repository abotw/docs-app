import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrameLayout extends JFrame {
    public MyFrameLayout() {
        this.setTitle("MyFrame Title");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlowLayout fl = new FlowLayout();

        this.setLayout(fl);
        for (int i = 1; i <= 4; i++) {
            JButton b = new JButton("button" + i);
            this.add(b);
        }
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrameLayout();
    }
}