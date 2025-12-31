import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {
    public MyDrawPanel() {
        JLabel label = new JLabel("Paint Demo");
        this.setBackground(Color.blue);
        this.add(label);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.orange);
        g.fillRect(20, 50, 100, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        MyDrawPanel panel = new MyDrawPanel();
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}