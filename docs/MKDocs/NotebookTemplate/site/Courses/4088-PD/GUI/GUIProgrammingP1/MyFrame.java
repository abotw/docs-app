import javax.swing.JFrame;

public class MyFrame extends JFrame {
    public MyFrame() {
        this.setTitle("MyFrame Title");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new MyPanel());
        this.setVisible(true);
    }
}