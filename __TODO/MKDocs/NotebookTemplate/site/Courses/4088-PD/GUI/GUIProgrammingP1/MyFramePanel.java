import java.awt.*;
import javax.swing.*;

public class MyFramePanel extends JFrame {
    public MyFramePanel() {
        this.setTitle("MyFrame Title");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(new JButton("hello"));
        JPanel p = new JPanel();
        p.setBackground(Color.BLUE);
        this.add(p);
        p.setLayout(new GridLayout(2, 2, 20, 10));
        for (int i = 0; i < 4; i++) {
            p.add(new JButton("B" + (i+1)));
        }
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFramePanel();
    }
}