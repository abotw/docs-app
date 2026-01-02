import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawLine(50, 50, 100, 100);
    }

    public static void main(String[] args) {
        new MyPanel();
    }
}