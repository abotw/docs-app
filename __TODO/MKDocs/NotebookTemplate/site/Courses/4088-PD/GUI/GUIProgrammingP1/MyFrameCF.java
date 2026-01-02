import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrameCF extends JFrame {
    public MyFrameCF() {
        this.setTitle("MyFrame Title");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout fl = new FlowLayout();
        this.setLayout(fl);
        JButton b = new JButton("hello");
        b.setBackground(Color.BLUE);
        b.setForeground(new Color(255, 0, 0));
        b.setFont(new Font(Font.SERIF, Font.ITALIC, 40));
        this.add(b);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrameCF();
    }
}